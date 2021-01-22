package com.company;

import java.util.List;

public class Animal {

    protected String nombre;
    protected Integer numeroCollar;
    protected String horarioDeComidas;
    protected Boolean vacunado;
    protected Integer edadEstimada;

    public Animal(String nombre, Integer numeroId, String horarioDeComidas) {
        this.nombre = nombre;
        this.numeroCollar = numeroId;
        this.horarioDeComidas = horarioDeComidas;
    }
    public Animal(String nombre, Integer numeroId, String horarioDeComidas,Boolean vacunado) {
        this.nombre = nombre;
        this.numeroCollar = numeroId;
        this.horarioDeComidas = horarioDeComidas;
        this.vacunado = vacunado;
    }
    public Animal(String nombre, Integer numeroId, String horarioDeComidas,Integer edadEstimada) {
        this.nombre = nombre;
        this.numeroCollar = numeroId;
        this.horarioDeComidas = horarioDeComidas;
        this.edadEstimada = edadEstimada;
    }
}

