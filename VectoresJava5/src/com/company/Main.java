package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    /* Se requiere generar un listado de frutas y verduras en un local.
	    El listado debe poder mostrar nombre y cantidad de cada articulo.
	    Se debe permitir actualizar la cantidad.

	    Main:
	    1.cargar 3 frutas, 2 verduras
	    2.mostrar listado
	    3.duplicar la cantidad de la fruta 2 y la verdura 1.
	    4.eliminar la fruta 1
	    5.reemplazar la verdura 2
	    6.mostrar listado
	     */

        List<Articulo> articulos = new ArrayList<>();

        //1.cargar 3 frutas, 2 verduras
        articulos.add(new Articulo("F", "Kiwi", 20));
        articulos.add(new Articulo("F", "Frutilla", 12));
        articulos.add(new Articulo("F", "Pomelo", 30));
        articulos.add(new Articulo("V", "Acelga", 7));
        articulos.add(new Articulo("V", "Radicheta", 2));

        //2. mostrar listado. Una forma de listar, utiliza el metodo ToString
        System.out.println(articulos);

        //Otra forma de listar, a mano
        for (int i = 0; i < articulos.size(); i++) {
            System.out.println("articulo " + i + ": " + articulos.get(i).getTipo() + ", " + articulos.get(i).getNombre() + " ," + articulos.get(i).getCantidad());
        };

        //Otra forma de listar (lambda)
        articulos.forEach((articulo) -> {
            System.out.println(articulo);
        });

        //3. duplicar la cantidad de la fruta 2 y la verdura 1. Muestro el listado actualizado
        Articulo fruta = obtenerArticulo("F", 2, articulos);
        fruta.setCantidad(fruta.getCantidad() * 2);


        Articulo verdura = obtenerArticulo("V", 1, articulos);
        verdura.setCantidad(verdura.getCantidad() * 2);

        System.out.println("Listado de articulos con el doble de la fruta 2 y la verdura 1:");
        articulos.forEach((articulo) -> {
            System.out.println(articulo);
        });

        //4. eliminar la fruta 1. Muestro el listado actualizado
        Articulo fruta1 = obtenerArticulo("F", 1, articulos);
        articulos.remove(fruta1);

        System.out.println("Listado sin la fruta 1:");
        articulos.forEach((articulo) -> {
            System.out.println(articulo);
        });

        //5.reemplazar la verdura 2. Muestro el listado actualizado
        Articulo verdura2 = obtenerArticulo("V",2,articulos);

        verdura2.setNombre("Remolacha");
        verdura2.setCantidad(23);

        System.out.println("Listado con la verdura 2 reemplazada: ");

        articulos.forEach((articulo) -> {
            System.out.println(articulo);
        });

    }

    public static Articulo obtenerArticulo(String tipo, Integer posicion, List<Articulo> articulos) {
        int contadorArticulos = 0;
        for (int i = 0; i < articulos.size(); i++) {

            Articulo art = articulos.get(i);
            if (art.getTipo() == tipo) {
                contadorArticulos++;
                if (contadorArticulos == posicion) {
                    return art;
                }
            }
        }
        return null;
    }
}
