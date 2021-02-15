package com.company;

public abstract class Transporte {
    protected String nombre;
    protected Double precio = 0.0;

    public Transporte(String nombre){
        this.nombre = nombre;

    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }



}
