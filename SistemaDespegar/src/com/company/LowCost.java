package com.company;

public interface LowCost {

    default void informarPrecio(){

        System.out.println("LowCost: Soy caro pero puedo bajar aun mas.");
    }

    default void bajarPrecio(){
        System.out.println("Ok, te lo bajo porque es sábado");
    }

}
