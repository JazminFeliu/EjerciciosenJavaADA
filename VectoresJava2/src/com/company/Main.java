package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Materia java = new Materia();

        List<Alumna> alumnasJava = java.getAlumnas();

        System.out.println("Cantidad de alumnas en java: "+alumnasJava.size());

        System.out.println("El promedio de la alumna 1 es: ");
        Alumna alba = alumnasJava.get(0);
        System.out.println("El promedio de "+alba.getNombre()+" es "+alba.getPromedio());

        for(int i = 0; i < alumnasJava.size(); i++){
            Alumna alumna = alumnasJava.get(i);
            System.out.println("El promedio de "+alumna.getNombre()+" es "+alumna.getPromedio());
        }
    }
}
