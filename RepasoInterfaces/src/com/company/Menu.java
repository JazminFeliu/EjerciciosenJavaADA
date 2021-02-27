package com.company;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	/*
	Crear un sistema que tenga una interfa
	1) si quiere agregar elementos al pres
	2) si quiere modificar un elemento
	3) si quiere eliminiar un elemento.   */

    public String elegirOpcionMenu(Integer opcion) {
        Map<Integer, String> menu = new HashMap<>();
        String opcion1 = "1 - Agregar un item al presupuesto.";
        String opcion2 = "2 - Modificar un item.";
        String opcion3 = "3 - Eliminar un item.";
        String opcion4 = "4- Mostrar detalle del presupuesto";
        String opcion5 = "5 - Finalizar.";
        String opcion6 = "6 - Salir";

        agregarOpcionMenu(menu, 1, opcion1);
        agregarOpcionMenu(menu, 2, opcion2);
        agregarOpcionMenu(menu, 3, opcion3);
        agregarOpcionMenu(menu, 4, opcion4);
        agregarOpcionMenu(menu, 5, opcion5);
        agregarOpcionMenu(menu, 6, opcion6);

        return menu.get(opcion);
    }




    public static void agregarOpcionMenu(Map<Integer, String>menu, Integer nro, String opcion){
        menu.put(nro, opcion);
    }
}
