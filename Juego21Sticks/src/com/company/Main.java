package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/* Juego de 21 sticks: Vos vs PC
	¿Queres jugar primero (S/N)?: S (hay que validar lo que me dice el usuario)
	sino juega primero la maquina
	Tu turno: ¿cuantos palitos queres sacar?(1 o 2): 1
	Quedan 20
	Turno pc: 2 palitos (pierde el que saca el último)
	Pierde el que se queda con un palito
	 */


        Juego j = new Juego();
        j.iniciarJuego();
    }

}
