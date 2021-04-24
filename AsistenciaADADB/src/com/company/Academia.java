package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Academia {

    /*Armar un sistema que permita registrar las asistencias a un curso.
	Dentro de la base de datos, se deben registrar las alumnas del curso.
	Al comienzo del sistema se debe preguntar si el usuario es el docente.
	Si es el docente, se le mostrarán 1 a 1 las alumnas y el docente indicará si está presente en la clase.
	Si el usuario no es docente, se debe preguntar el legajo de la alumna para que pueda indicar que está presente.
	1) Mantener un registro del total de presentes de cada alumna.
	2) El curso tiene un total de 100 clases.
	Se debe mantener un registro de clases dictadas y mostrar un porcentaje de presentismo para cada alumna.
	3) Mostrar alumnas con menos el 75% de asistencia.

     */

    private Scanner sc = new Scanner(System.in);
    private String dbName = "academia";
    private String dbUser = "root";
    private String dbPWD = "root";
    private boolean isMenu = true;
    private Docente docente;

    public void iniciarMenu() {

        while (isMenu) {
            int opcionDocente;

            System.out.printf("\n\n Sistema de Asistencias de la Academia \n\n");
            System.out.println("¿Es docente? (1 = SI / 2 = NO / 0 = Salir)");
            System.out.print("Ingrese una opcion: ");
            opcionDocente = Integer.parseInt(sc.nextLine());

            switch (opcionDocente) {
                case 1:
                    tomarLista();
                    break;
                case 2:
                    menuNoDocente();
                    break;
                case 0:
                    System.out.println("Gracias por utilizar el sistema");
                    isMenu = false;
                default:
                    System.out.println("Ingrese una opcion correcta");
            }
        }
    }

    public void tomarLista() {
        System.out.print("Ingrese el COD de DOCENTE (0 = SALIR): ");
        Integer idDocente = Integer.parseInt(sc.nextLine());
        mostrarDocente(idDocente);
        System.out.println("Para tomar lista debe ingresar al curso");
        System.out.println("1- Buscar por COD DEL CURSO / 2- Listar cursos vigentes / 0- Salir ");
        System.out.print("Ingrese su opción: ");
        Integer opcionCurso = Integer.parseInt(sc.nextLine());
        switch (opcionCurso) {
            case 1:
                System.out.print("Ingrese el COD DEL CURSO: ");
                Integer idCurso = Integer.parseInt(sc.nextLine());

                if(buscarYMostrarEnDBCursos("SELECT idCurso, nombre, fechaInicio, diasDeCursada, cantidadDeClases, idDocente FROM cursos WHERE idDocente = "+idDocente+" AND idCurso = "+idCurso+";")) {
                    tomarAsistencia(idCurso, idDocente);
                }else
                    System.out.println("el curso no se encuentra o usted no es su docente");
                break;
            case 2:
                listarCursos(idDocente);
                break;

            case 0:
                System.out.println("Gracias por utilizar el sistema");
                isMenu = false;
                break;

            default:
                System.out.println("Ingrese una opcion correcta");
                break;
        }
    }

    private void tomarAsistencia(Integer idCurso, Integer idDocente){
        System.out.println("tomar asistencia del curso "+idCurso);
    }

    private void menuNoDocente() {
    }


    public void listarCursos(Integer idDocente) {
        buscarYMostrarEnDBCursos("SELECT idCurso, nombre, fechaInicio, diasDeCursada, cantidadDeClases, idDocente FROM cursos WHERE idDocente = "+idDocente);
    }

    public boolean buscarYMostrarEnDBCursos(String sql) {
        Boolean isCurso = true;
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        ResultSet rs = conexionDB.consultar(sql);
        try {
            mostrarResultadosCurso(rs);
        } catch (SQLException e) {
            System.out.println("No se econtraron resultados");
            isCurso = false;
        } finally {
            conexionDB.cerrar();
        } return isCurso;
    }

    private void mostrarResultadosCurso(ResultSet rs) throws SQLException {
        if (rs != null)
            while (rs.next())
                System.out.println("COD de Curso: " + rs.getString("idCurso") +
                        " " + rs.getString("nombre")+
                        " " + rs.getString("fechaInicio") +
                        " " + rs.getString("diasDeCursada") +
                        " " + rs.getString("cantidadDeClases") +
                        " " + rs.getString("idDocente"));
    }

    private void mostrarDocente(Integer idDocente){
        String sql ="SELECT idDocente, nombre, legajo FROM docentes WHERE idDocente = "+idDocente+";";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        ResultSet rs = conexionDB.consultar(sql);
        try {
            if (rs != null)
            while (rs.next())
                System.out.println("COD de Docente: " + rs.getString("idDocente") +
                        ", Nombre:  " + rs.getString("nombre")+
                        ", Legajo Nro.: " + rs.getString("legajo")
                );
        }catch (SQLException e) {
            System.out.println("No se encontraron datos del docente");
        }finally {
            conexionDB.cerrar();
        }
    }
}


/*
    private void tomarListaXAlumna(Integer idCurso) {
        System.out.print("Ingrese el  COD de Alumna: (0 - si quiere listar todas ): ");
        Integer idAlumna = Integer.parseInt(sc.nextLine());
        mostrarPorAsistencia(idAlumna, idCurso);
    }

    private void mostrarPorCurso(Integer idCurso) {
        buscarYMostrarEnDBCursos("SELECT idCurso, nombre, fechaInicio, diasDeCursada, cantidadDeClases, docente FROM cursos WHERE idCurso = " + idCurso);
    }

    private void mostrarPorAsistencia(Integer idAlumna, Integer idCurso) {
        buscarYMostrarEnDBAsistencias("SELECT alumnas.idAlumna, alumnas.nombre, asistencias.curso, asistencias.registroDeAsistencias FROM alumnas INNER JOIN asistencias ON alumnas.idAlumna ="+idAlumna+" AND asistencias.alumna = "+idAlumna+" AND asistencias.curso ="+idCurso);
    }



    public void listarCursos(Integer idDocente) {
        buscarYMostrarEnDBCursos("SELECT idCurso, nombre, fechaInicio, diasDeCursada, cantidadDeClases, docente FROM cursos WHERE idDocente = "+idDocente);

    }

    public void buscarYMostrarEnDBCursos(String sql) {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        ResultSet rs = conexionDB.consultar(sql);
        try {
            mostrarResultadosCurso(rs);
        } catch (SQLException e) {
            System.out.println("No se econtraron resultados");
        } finally {
            conexionDB.cerrar();
        }
    }


    private void mostrarResultadosCurso(ResultSet rs) throws SQLException {
        if (rs != null)
            while (rs.next())
                System.out.println("COD de Curso: " + rs.getString("idCurso") +
                        " " + rs.getString("nombre")+
                        " " + rs.getString("fechaInicio") +
                        " " + rs.getString("diasDeCursada") +
                        " " + rs.getString("cantidadDeClases") +
                        " " + rs.getString("docente"));
    }

    public void buscarYMostrarEnDBAsistencias(String sql) {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        ResultSet rs = conexionDB.consultar(sql);
        try {
            mostrarResultadosAsistencia(rs);
        } catch (SQLException e) {
            System.out.println("No se econtraron resultados");
        } finally {
            conexionDB.cerrar();
        }
    }


    private void mostrarResultadosAsistencia(ResultSet rs) throws SQLException {
        if (rs != null)
            while (rs.next())
                System.out.println("idAlumna: " + rs.getString("idAlumna") +
                        " " + rs.getString("nombre") +
                        " " + rs.getString("curso") +
                        " " + rs.getString("registroDeAsistencias"));
    }
}
*/







