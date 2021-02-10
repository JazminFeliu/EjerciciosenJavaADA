package com.company;

public abstract class Mamifero implements Animal {
    protected String nombre;

    public abstract void dormir();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
