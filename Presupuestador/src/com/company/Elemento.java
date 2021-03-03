package com.company;

public abstract class Elemento {

    protected String nombre;
    protected String descripcion;

    public Elemento(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
