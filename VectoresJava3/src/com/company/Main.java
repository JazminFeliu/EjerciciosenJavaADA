package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //crear una lista de nombres para guardar
        // la asistencia a un curso de 30 alumnas

        List<String> alumnas = new ArrayList<>();

        //consultar tamaño del array
        alumnas.size();

        //agregar elementos
        alumnas.add("Agustina");
        alumnas.add("Alba");
        alumnas.add("Jazmin");
        alumnas.add("Natalia");
        alumnas.add("Caro");
        //agrega un valor en la posicion 3 y desplaza
        alumnas.add(3,"Sabri");
        //reemplaza el valor del objeto en la posicion 3
        alumnas.set(3,"Sabri");
        System.out.println("Tamaño: "+alumnas.size());
        System.out.println("En 3:" +alumnas.get(3));

        for(int i = 0; i<alumnas.size(); i++){
            System.out.print(i+": ");
            System.out.println(alumnas.get(i));
        }
    }
}
