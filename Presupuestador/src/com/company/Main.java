package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		/*
	Crear un sistema que tenga una interfaz que permita al usuario indicar desde un menu lo siguiente:
	1) si quiere agregar elementos al presupuesto
	2) si quiere modificar un elemento
	3) si quiere eliminiar un elemento.
	Los elementos/items pueden ser productos o servicios.
	Cada producto tiene una cantidad, un precio unitario, un nombre y una descripcion.
	Cada servicio tiene un costo por hora y una cantidad de horas. Además del nombre del servicio, el nombre de la
	persona que lo ejecuta y una descripcion.
	Una vez que el presupuesto está listo (el usuario decide finalizar),
	mostrar el presupuesto total y el detalle de todos los ítems agregados.
	opcionales:
	Los usuarios hacen fila para pedir presupuestos y esos presupuestos al final del dia se muestran en el orden de llegada.
	 */
        Scanner sc = new Scanner(System.in);
        int op = 0;

        Queue<Presupuesto>todosLosPresupuestos = new LinkedList<>();

        do {
            System.out.println("Ingrese el nombre de usuario: ");
            String nombre = sc.nextLine();

            Usuario usuario = new Usuario(nombre);
            usuario.armarPresupuesto(usuario);

            todosLosPresupuestos.add(usuario.getPresupuesto());

            System.out.println("Desea continuar? 1=SI, 0=NO");

            op = sc.nextInt();
            nombre = sc.nextLine();
        } while ((op != 0));

        System.out.println("Cantidad de presus: "+todosLosPresupuestos.size());
        //armar impresion de presupuestos en un static void method
    }
}

