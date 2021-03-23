package com.company;

public enum Uso {


    Particular("El vehículo tiene uso particular."),
    Profesional("El vehículo permite transporte de pasajeros y/o cargas");

    private final String descripcion;

    Uso(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
