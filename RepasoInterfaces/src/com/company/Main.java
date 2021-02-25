package com.company;

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
	 */


        Usuario roberta = new Usuario("Roberta");

        Profesional julia = new Profesional("Julia");
        Producto cuadernoA4R = new Producto(    10,
                                                150.00,
                                                "CuadernoA4R",
                                                "Cuaderno A4 Rallado ");
        Servicio apoyoEscolarCompu = new Servicio(10,
                                                  200.00,
                                                  "Clases particulares de Computacion",
                                                  julia,
                                                  "Apoyo escolar");

        Item item = new Item(cuadernoA4R,10);
        roberta.agregarItem(item);
        Item item1 = new Item(apoyoEscolarCompu,2);
        roberta.agregarItem(item1);
        roberta.mostrarDetallePresupuesto();

        Presupuesto presu = new Presupuesto();

        presu.elegirOpcion();


    }
}
