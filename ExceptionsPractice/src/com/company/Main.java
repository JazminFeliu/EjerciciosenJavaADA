package com.company;

public class Main {

    public static void main(String[] args) {
	/* Crear un sistema que permita la creacion de jugadores por DNI y nombre, validando que el DNI tenga 8 digitos
	y el nombre no esté vacío.
	No permitir la creación de jugadores sin los datos validados. Permitir crear tantos jugadores como se desee.
	Al finalizar, mostrar la lista de jugadores creados.
	 */

        Juego juego = new Juego();

        juego.iniciarJuego();

        for(Jugador jugador : juego.getJugadores()){
            System.out.println(jugador.toString());
        }

    }
}
