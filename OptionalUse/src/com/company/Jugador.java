package com.company;

public class Jugador {

    private String dni;
    private String nombre;
    public Jugador(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
    }

    public void jugar() {
        System.out.printf("Soy el jugador 2 y estoy jugando");
    }
}
