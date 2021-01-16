package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	String[] nombres = new String[5];

	int posiciones = nombres.length;

        System.out.println("Mi array nombres tiene " + posiciones + " posiciones");

        nombres[0] = "Pablo";
        nombres[1] = "Eve";
        nombres[2] = "Sabri";
        nombres[3] = "Jazmin";
        nombres[4] = "Caro";

        for(int i = 0; i < 5; i++){
            System.out.println(nombres[i]);
        }

        /*
        Realizar un código que permita cargar 6 notas (enteras)
        y luego mostrarlas en pantalla
         */

        Integer[] notas = new Integer[6];

        notas[0] = 10;
        notas[1] = 9;
        notas[2] = 4;
        notas[3] = 8;
        notas[4] = 10;
        notas[5] = 6;

        for(int i = 0; i < notas.length; i++){
            System.out.println("Nota "+(i+1)+": "+notas[i]);
        }

        // ArrayList<>

        ArrayList<String> apellidos = new ArrayList<>();

        apellidos.add("Acevedo");
        apellidos.add("Contreras");
        System.out.println("Tengo "+apellidos.size()+" apellidos");

        apellidos.add("Feliu");
        apellidos.add("Portillo");
        apellidos.add("Meli");

        apellidos.add("Guitian");
        apellidos.add("Rinaldi");

        System.out.println("Tengo "+apellidos.size()+" apellidos");

        System.out.println(apellidos.get(2));
        //borrar todos los elementos: apellidos.clear()
        //saber si esta vacio: apellidos.isEmpty()

        //elimino el apellido en la posicion 0
        apellidos.remove(0);

        //recorro el array y lo muestro

        for (int i = 0; i<apellidos.size(); i++){
            System.out.println(i+": "+ apellidos.get(i));
        }

        //elimino el apellido en la posicion 2
        apellidos.remove(2);

        //recorro el array y lo muestro

        for (int i = 0; i<apellidos.size(); i++){
            System.out.println(i+": "+ apellidos.get(i));
        }
        Collections.sort(apellidos);
        System.out.println("Vuelvo a mostrar..ora vez");

        for (int i = 0; i<apellidos.size(); i++){
            System.out.println(i+": "+ apellidos.get(i));}

        //OTRO EJEMPLO con numeros:

        List<Integer> numerosDesordenados = new ArrayList<>();
        numerosDesordenados.add(5);
        numerosDesordenados.add(8);
        numerosDesordenados.add(73);
        numerosDesordenados.add(15);
        numerosDesordenados.add(57);
        numerosDesordenados.add(59);
        numerosDesordenados.add(9);

        System.out.println("Numeros desordenados: ");
        System.out.println(numerosDesordenados);

        Collections.sort(numerosDesordenados);
        System.out.println("Numeros ordenados:");
        System.out.println(numerosDesordenados);

        for (int i = 0; i < numerosDesordenados.size(); i++){
            System.out.println(numerosDesordenados.get(i));
        }

        System.out.println();

    }
}
