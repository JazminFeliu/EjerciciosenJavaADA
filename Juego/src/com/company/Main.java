package com.company;

public class Main {

    /*
    Crear un sistema que permita iniciar un juego con cuatro personajes y la dificultad de la partida.
    Cada personaje debe tener un nombre y elegir el color de su equipo.
    Los equipos son: ROJO, AZUL, AMARILLO Y NEGRO.

    Cuando comienza el juego, los equipos rojo y azul están en la posicion 100 y los equipos amarillo
    y negro estan en la posicion cero.

    La meta de los equipos rojo y azul es llegar a la casa de los equipos amaraillo y negro.

    La meta de los equipos amarillo y negro es llegar a la casa de los equipos rojo y azul.

    Cada equipo avanza 1 vez por turno a un paso aleatorio entre 1 y 5.
    Se debe llevar la cuenta a cuantos movimientos hace cada equipo.
    El juego finaliza cuando un equipo alcanza su meta.
    Se debe informar el paso a paso y al finalizar, una tabla de posiciones, ordenada por cantidad de pasos.
     */
    public static void main(String[] args) {

        Juego juego = new Juego(Dificultad.ALTA);
        juego.iniciar();
        while (juego.isActivo()){
            juego.jugarTurno();

        }
        juego.mostrarResultados();
    }
}
