package com.company;

public interface LowCost {

    default void informarPrecio(){
        System.out.println("Soy caro pero puedo bajar");
    }
}
