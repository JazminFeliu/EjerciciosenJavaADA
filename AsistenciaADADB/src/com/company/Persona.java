package com.company;

public abstract class Persona {

    private Integer id;
    private String nombre;
    private String legajo;

    public Persona(Integer id, String nombre, String legajo) {
        this.id = id;
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", legajo='" + legajo + '\'' +
                '}';
    }
}
