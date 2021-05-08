package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.HSQLCaseFragment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();

        List<Asistencia> asistencias = (List<Asistencia>) session.createQuery("FROM Asistencia").list();

        System.out.println("Listo todas las ASISTENCIAS de todos los cursos de todas las alumnas: ");
        for(Asistencia asistencia: asistencias)
            System.out.println(asistencia);

        List<Curso> cursos = (List<Curso>) session.createQuery("FROM Curso").list();
        System.out.println("Listo ahora todos los CURSOS de la Academia:");
        for (Curso curso: cursos)
            System.out.println(curso);

        List<Docente> docentes = (List<Docente>) session.createQuery("FROM Docente").list();
        System.out.println("Listo los DOCENTES de todos los cursos:");
        for(Docente docente: docentes)
            System.out.println(docente);

        List<Alumna>alumnas = (List<Alumna>) session.createQuery("FROM Alumna").list();
        System.out.println("Por ultimo, listamos a las ALUMNAS de todos los cursos: ");
        for(Alumna alumna: alumnas)
            System.out.println(alumna);

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su CODIGO DE DOCENTE: ");
        Integer idDocente = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el Id de Curso que le asignaron: ");
        Integer idCurso = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese la cantidad de clases que tiene el curso: ");
        Integer cantidad = Integer.parseInt(sc.nextLine());

        System.out.println("Ingrese los dias de cursada tiene el Curso asignado (1= lunes, miercoles y viernes, 2=martes, jueves y sabado: ) ");
        Integer isCursada = Integer.parseInt(sc.nextLine());

        System.out.println("Por último, ingrese la fecha de inicio del curso: (AAAA-MM-DD)");
        LocalDate fechaInicio = LocalDate.parse(sc.nextLine());

        //Ponele que empieza el lunes 03/05/2021, tiene 10 clases y una cursada los lunes(2), miercoles(4) y viernes(6)


        List<LocalDate>fechas = new ArrayList<>();
        fechas.add(fechaInicio);            //fecha+0  vuelta 1 (cantidad-1)/3
        int i=1;
        while (i< cantidad ){
            fechas.add(fechaInicio.plusDays(2));
            fechas.add(fechaInicio.plusDays(4));
            fechas.add(fechaInicio.plusDays(7));
            fechaInicio =fechaInicio.plusDays(7);
            i=i+3;
        }

        System.out.println("Calendario de fechas de cursada.");
        Integer dia = 0;
        while(dia<cantidad){
            System.out.println("Clase nro."+(dia+1)+": "+fechas.get(dia));
            dia++;
        }


        for (i= 0; i<asistencias.size(); i++){
            if(asistencias.get(i).getIdCurso() == idCurso){
                Asistencia asistencia = asistencias.get(i);
                mostrarAsistenciasAlumna(asistencia, fechas, cantidad);
            }
        }
    }

    private static void mostrarAsistenciasAlumna(Asistencia asistencia, List<LocalDate> fechas, Integer cantidad ) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        List<Curso> cursos = (List<Curso>) session.createQuery("FROM Curso").list();
        List<Alumna> alumnas = (List<Alumna>) session.createQuery("FROM Alumna").list();

        String nombreAlumna ="";
        String legajo= "";
        String nombreCurso="";
        for (int i = 0; i < alumnas.size(); i++) {
            if (asistencia.getIdAlumna() == alumnas.get(i).getIdAlumna()) {
                nombreAlumna = alumnas.get(i).getNombreAlumna();
                legajo = alumnas.get(i).getLegajo();
                break;
            }
        }
        for (int i = 0; i < cursos.size(); i++) {
            if (asistencia.getIdCurso() == cursos.get(i).getIdCurso()) {
                nombreCurso = cursos.get(i).getNombreCurso();
                break;
            }
        }
        String digito;
        System.out.println("Curso: "+nombreCurso);
        System.out.println("Alumna: "+nombreAlumna+" , legajo Nro.: "+legajo);
        String registroDeAsistencias = asistencia.getRegistroDeAsistencias();

        for (int i = 0; i < cantidad; i++) {
            digito = registroDeAsistencias.substring(i, i + 1);
            if(digito.equals("0")) {
                System.out.println("Clase Nro.: " + (i + 1) + ", " + fechas.get(i) + " : AUSENTE");
            } else {
                System.out.println("Clase Nro.:" + (i + 1) + ", " + fechas.get(i) + " : PRESENTE");
            }

        }


    }



}
