package com.company;

import java.util.List;

public class Reptil extends Animal {

    public Reptil(String nombre, Integer numeroId, String horarioDeComidas) {
        super(nombre, numeroId, horarioDeComidas);
    }

    public Reptil(String nombre, Integer numeroId, String horarioDeComidas, Integer edadEstimada) {
        super(nombre, numeroId, horarioDeComidas, edadEstimada);
    }

    @Override
    public String toString() {
        return "Reptil{" +
                "nombre='" + nombre + '\'' +
                ", numeroCollar=" + numeroCollar +
                ", horarioDeComidas='" + horarioDeComidas + '\'' +
                ", edadEstimada=" + edadEstimada +
                '}';
    }
}

