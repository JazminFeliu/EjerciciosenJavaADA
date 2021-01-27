package com.company;

public class Persona {

    private Integer idRegistro;
    private String nombre;
    private String dni;
    private String direccion;

    public Persona(Integer idRegistro, String nombre, String dni, String direccion){
        this.idRegistro = idRegistro;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    public String getNombre(){
        return nombre;
    }
}

