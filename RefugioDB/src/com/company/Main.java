package com.company;

public class Main {

    public static void main(String[] args) {
	/* Crear un sistema para un refugio donde se registra cada nuevo animal que llega.
	De cada animal se guarda su nombre, especie y edad estimada.
	Una vez que se examinan los animales que llegan, se puede establecer una edad con mayor certeza
	y se actualiza la base de datos.
	Permitir listar a todos los animales y buscar animales segun su especie.
	Las especies permitidas son: perro, gato, tortuga, caballo, ballena.
	 */

        Refugio refugio = new Refugio();
        refugio.iniciarMenu();

    }
}
