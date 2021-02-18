package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int aleatorio = (int) Math.floor((Math.random() * 100));
        System.out.println("Aleatorio: " + aleatorio);

        long ahora = System.currentTimeMillis(); // genera un numero aleatorio basado en los milisegundos de la compu
        System.out.println("Ahora: " + ahora);

        /* Crear un sistema que reparta las 52 cartas del mazo en pantalla.

         */

        List<Integer>cartas = new ArrayList<>();
        for(int i=1; i < 5; i++)
            cartas.add(i);
        Random objetoAleatorio = new Random();

        while (cartas.size()>0){
            int cartaElegida = objetoAleatorio.nextInt(cartas.size());
            System.out.println("Carta elegida: "+cartas.remove((cartaElegida)));
        }

    }
}
