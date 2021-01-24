package com.company;

import java.util.List;

public class Reptil extends Animal {

    private Integer edadEstimada;

    public Reptil(String nombre, Integer numeroId, List<Integer> horarioDeComidas, Integer edadEstimada) {
        super(nombre, numeroId, horarioDeComidas);
        this.edadEstimada = edadEstimada;
    }

    @Override
    public String toString() {
        return "Reptil{" +
                "nombre='" + nombre + '\'' +
                ", numeroCollar=" + numeroCollar +
                ", horarioDeComidas='" + horario + '\'' +
                ", edadEstimada=" + edadEstimada +
                '}';
    }
}

