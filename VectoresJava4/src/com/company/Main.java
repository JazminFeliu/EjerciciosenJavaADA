package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    // Crear un sistema que permita almacenar el inventario de autos en una concesionaria.
        //De cada auto, necesito conocer la marca, año, modelo, precio.
        //Mostrar cantidad total de auto y el precio de cada uno.


        List<Auto> autos = new ArrayList<Auto>();
        Auto auto = new Auto("WV",2004,"Gol",1650.00);
        Auto otroAuto = new Auto("Ford", 2005, "Focus", 850.00);
        autos.add(auto);
        autos.add(otroAuto);
        autos.add(new Auto("Audi",2020,"A3",582.2));

        System.out.println("La cantidad de autos que tiene el inventario es: "+ autos.size());

        for(int cont = 0; cont < autos.size(); cont++){
            System.out.println("El precio del auto "+cont+" es: $ "+autos.get(cont).getPrecio());
        }

        System.out.println(otroAuto.fichaTecnica());
        System.out.println(autos);

        for(int cont = 0; cont < autos.size(); cont++){
            System.out.println(autos.get(cont).fichaTecnica());
        }
    }
}
