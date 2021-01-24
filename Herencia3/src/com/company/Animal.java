package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Animal {

    protected String nombre;
    protected Integer numeroCollar;
    protected List<Integer> horario;


    public Animal(String nombre, Integer numeroId, List<Integer> horarioDeComidas) {
        this.nombre = nombre;
        this.numeroCollar = numeroId;
        this.horario = horarioDeComidas;
    }
}

