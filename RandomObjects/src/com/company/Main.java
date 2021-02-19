package com.company;

import javax.security.sasl.SaslClient;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int aleatorio = (int) Math.floor((Math.random() * 100));
        System.out.println("Aleatorio: " + aleatorio);

        long ahora = System.currentTimeMillis(); // genera un numero aleatorio basado en los milisegundos de la compu
        System.out.println("Ahora: " + ahora);

        /* Crear un sistema que reparta las 52 cartas del mazo en pantalla.
         Reglas de pokerPablo:
        Cantidad de jugadores: 2-5. (preguntar al inicio)
        Cantidad de cartas por jugador: 5.

        Al inicio, repartir las cartes y mostrarlas en pantalla.
        Nota: se deben guardar las cartas de cada jugador (no sólo mostrarlas en pantalla).
         */

        List<Integer>cartas = new ArrayList<>();
        for(int i=1; i < 53; i++)
            cartas.add(i);
        Random objetoAleatorio = new Random();
        Integer jugadores;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Ingrese el numero de jugadores (2-5): ");
            jugadores = sc.nextInt();
            System.out.println("");
        }while (jugadores < 2 || jugadores>5);

        List<int[]>cartasJugadores = new ArrayList<>();
        int cartaElegida;
        for(int i=0; i<jugadores;i++){
            int[]cartasJugador= new int[5];
            for(int j = 0; j<5; j++){
                cartaElegida = objetoAleatorio.nextInt(cartas.size());
                cartasJugador[j]= cartas.remove(cartaElegida);
            }
            cartasJugadores.add(cartasJugador);
            }
        int contador = 0;
        for(int[]lasCartas: cartasJugadores) {
            contador++;
            System.out.println("");
            System.out.println("Jugador: " + contador);
            for (int i = 0; i < 5; i++) {
                System.out.println("Cartas: " + lasCartas[i]);
            }
        }

    }
}
