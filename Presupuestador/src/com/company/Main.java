package com.company;

import java.util.LinkedList;
import java.util.List;
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

        List<Presupuesto> todosLosPresupuestos = new LinkedList<>();

        do {
            System.out.println("Ingrese el nombre de usuario: ");
            String nombre = sc.nextLine();

            Usuario usuario = new Usuario(nombre);

            usuario.armarPresupuesto(usuario);

            Presupuesto presupuesto = usuario.getPresupuesto();
            todosLosPresupuestos.add(presupuesto);

            System.out.println("Desea continuar? 1=SI, 0=NO");

            op = sc.nextInt();

            sc.nextLine();

        } while ((op != 0));


        mostrarTodosLosPresupuestos(todosLosPresupuestos);
    }

    private static void mostrarTodosLosPresupuestos(List<Presupuesto> todosLosPresupuestos) {

        Double total = 0.0;
        System.out.println("****** LISTA DE TODOS LOS PRESUPUESTOS REALIZADOS ******");
        for(Presupuesto p: todosLosPresupuestos){

            p.mostrarPresupuesto();

            total += p.getTotalPresupuesto();
        }
        System.out.println();
        System.out.println("Cantidad de presupuestos: "+todosLosPresupuestos.size());
        System.out.println("Importe total presupuestado: $ "+total);

    }
}

