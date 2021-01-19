package com.company;

public class Automovil {

    private Integer velocidad;

    public Automovil(int velocidad){

        this.velocidad = velocidad;
    }

    public void frenar(){

        velocidad--;
    }

    public void acelerar(){

        velocidad++;
    }

    public int getVelocidad(){

        return velocidad;
    }
}
