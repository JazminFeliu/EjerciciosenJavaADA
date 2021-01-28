package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

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

    }
}
