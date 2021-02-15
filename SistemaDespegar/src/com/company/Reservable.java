package com.company;

public interface Reservable {

    default void reservar(){
        System.out.println("Reserva confirmada!");
    }

    default void informarPrecio(){
        System.out.println("Reservar Auto: soy caro pero lo valgo");
    }
}
