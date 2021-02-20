package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<Producto, Double> precios = new HashMap<Producto, Double>();

        // el HashMap es util, siempre que use una clave sensilla, porque sino es muy dificil compararlas
        //y hacer cosas como ordenar, traer, ingresar con claves dificiles
        //ya que debemos decirle al programa de que forma comparar, por ejemplo, si es entre dos productos

        Producto teclado = new Producto("teclado","inhalambrico");
        precios.put(teclado, 50.00 );
        Producto mouse = new Producto("mouse","optico");
        precios.put(mouse, 150.00);
        Producto auris = new Producto("auriculares cool", "zeus red dragon");
        precios.put(auris, 8500.00);

       teclado.setDescripcion("ahora tengo una mejor version");

        precios.forEach((p,v) ->
                System.out.println("$"+v+" - "+p));
    }
}
