package com.company;

public class Automovil {

    private Integer velocidad;

    public Automovil(){
        velocidad = 0;
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
