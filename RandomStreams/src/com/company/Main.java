package com.company;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Random aleatorio = new Random(System.currentTimeMillis()); //semilla: hora actual de mi sistema

        //un nro enterio pseudoaleatorio entre 0 y 5 (el 6 no lo incluye)
        int enteroRandom = aleatorio.nextInt(6);
        System.out.println("Nro. random: "+enteroRandom);

        //Ejemplo random con Stream
        IntStream enterosAleatorios = aleatorio.ints(9,1,5);
        enterosAleatorios.forEach(numero -> System.out.println("Numero: "+numero));
    }
}
