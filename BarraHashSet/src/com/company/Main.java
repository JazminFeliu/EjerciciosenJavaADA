package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        //HashSet<String> asistentes = new HashSet<>();
        TreeSet<String> asistentes = new TreeSet<>();

        Scanner sc = new Scanner((System.in));
        String siguiente;
        do{
            System.out.println("Siguiente: ");
            siguiente =sc.nextLine();
            asistentes.add(siguiente);
        }while (!siguiente.equals(""));

        asistentes.add("Pablo");
        asistentes.add("Juli");
        asistentes.add("Sebastian");
        asistentes.add("Juli");
        asistentes.add("Jazmin");
        asistentes.add("Juli");
        asistentes.add("Caro");
        asistentes.add("Pablo");

        System.out.println("Cantidad "+asistentes.size());
        System.out.println("Fue Pablo? "+asistentes.contains("Pablo"));

        for(String asistente : asistentes){
            System.out.println("Asistente: "+asistente);
        }
        System.out.println("Asistentes: "+asistentes);
    }
}
