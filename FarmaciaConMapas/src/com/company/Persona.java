package com.company;

public class Persona {

    private Integer numero;
    private String nombre;

    public Persona(Integer numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
