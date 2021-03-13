package com.company;

import java.util.Scanner;

public class Jugador {

    private String nombre;
    private Integer dni;



    public Jugador(String nombre, Integer dni) throws validacionDNIException {

        this.nombre = nombre;
        setDni(dni);
    }

    private void setDni(Integer dni) throws validacionDNIException {
        if(String.valueOf(dni).length()!=8){
            throw new validacionDNIException("El DNI debe tener 8 digitos.");
        } else {
            this.dni = dni;
        }
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }
}
