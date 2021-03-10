package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    protected String nombre;
    protected int id;
    protected List<Integer> horarios = new ArrayList<>();

    public Animal(String nombre, Integer id) {
        this.id = id;
        this.nombre = nombre;
    }

    public Animal(){

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Integer> horarios) {
        this.horarios = horarios;
    }
}
