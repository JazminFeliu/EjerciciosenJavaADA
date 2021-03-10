package com.company;

public class Reptil extends Animal implements IAnimal {

    private int edadEstimada;

    public Reptil(String nombre, int id, int edadEstimada) {
        super(nombre, id);
        this.edadEstimada = edadEstimada;
    }

    public int getEdadEstimada() {
        return edadEstimada;
    }

    public void setEdadEstimada(int edadEstimada) {
        this.edadEstimada = edadEstimada;
    }

    @Override
    public String verDatos() {
        return id + " - edad estimada : " + edadEstimada;
    }
}


