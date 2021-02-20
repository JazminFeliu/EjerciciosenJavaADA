package com.company;

public class Persona {

    private String nombre;
    private String dni;
    private String direccion;

    public Persona(String nombre){
        this.nombre = nombre;
        //this.dni = dni;
        //this.direccion = direccion;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

}
