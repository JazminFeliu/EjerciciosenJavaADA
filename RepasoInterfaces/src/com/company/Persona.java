package com.company;

public abstract class Persona  {
    private String nombre;

    public Persona(){

    }
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
