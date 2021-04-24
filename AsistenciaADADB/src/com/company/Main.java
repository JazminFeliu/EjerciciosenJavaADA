package com.company;

public class Main {

    public static void main(String[] args) {
	/*Armar un sistema que permita registrar las asistencias a un curso.
	Dentro de la base de datos, se deben registrar las alumnas del curso.
	Al comienzo del sistema se debe preguntar si el usuario es el docente.
	Si es el docente, se le mostrarán 1 a 1 las alumnas y el docente indicará si está presente en la clase.
	Si el usuario no es docente, se debe preguntar el legajo de la alumna para que pueda indicar que está presente.
	1) Mantener un registro del total de presentes de cada alumna.
	2) El curso tiene un total de 100 clases.
	Se debe mantener un registro de clases dictadas y mostrar un porcentaje de presentismo para cada alumna.
	3) Mostrar alumnas con menos el 75% de asistencia.
	 */

        Academia ada = new Academia();
        ada.iniciarMenu();

    }
}
