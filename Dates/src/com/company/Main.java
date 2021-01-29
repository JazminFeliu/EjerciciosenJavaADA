package com.company;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //pedirle al usuario dia y mes de su cumpleaños e informarle que dia del año cumple

        /*Integer dia1;
        Integer mes1;
        System.out.print("Ingrese el dia de su cumpleaños: ");
        Scanner sc = new Scanner(System.in);
        dia1 = sc.nextInt();
        System.out.print("Ingrese el mes de su cumpleaños: ");
        mes1 = sc.nextInt();
        System.out.println("Cumplis el dia nro. "+LocalDate.of(2021, mes1, dia1).getDayOfYear()+" del año 2021");
        System.out.printf("Cumplis el dia %d de este año",LocalDate.of(2021, mes1, dia1).getDayOfYear());*/

        LocalTime hora = LocalTime.now();
        System.out.println("Hora: "+hora);

        LocalDate fecha = LocalDate.now();
        System.out.println("Hoy: "+fecha);
        /*
        dd = dia
        MM = mes
        yyyy = año
        HH = hora
        mm = minuto
        ss = segundos
         */

        String fechaConFormato = fecha.format(DateTimeFormatter.ofPattern("dd MMMM yyyy "));
        System.out.println("Fecha con formato: "+fechaConFormato);
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Ahora: " +ahora);

        int anio = 2020;
        int mes = 06;
        int dia = 25;
        LocalDate unaFecha = LocalDate.of(anio, mes, dia);
        System.out.println("La fecha es: "+unaFecha);

        LocalDate unaFecha2 = LocalDate.ofYearDay(2020, 250);
        System.out.println("El dia del año pasado: "+unaFecha2);

        fecha.plusMonths(3);
        System.out.println("Dentro de 3 meses:" + fecha.plusMonths(3));

        // before = antes y after = despues

        LocalDateTime laNavidad = LocalDateTime.of(2021,12,24,23,59);
        LocalDateTime maniana = LocalDateTime.now().plusDays(1);


        if(maniana.isAfter(laNavidad)){  // pregunto si mañana es despues de navidad
            System.out.println("Ya paso navidad :-(");
        }else{
            int diasParaNavidad = laNavidad.getDayOfYear() -maniana.getDayOfYear(); //calculo restando los dias
            long diasQueFaltan = Duration.between(maniana,laNavidad).toDays(); // calculo con Duration

            System.out.println("Todavia faltan "+diasParaNavidad+" dias para navidad! :-(");
            System.out.println("Faltan " + diasQueFaltan);
        }
    }
}
