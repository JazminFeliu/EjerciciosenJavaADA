package com.company;

public class Asistencia {

    private Integer id;
    private String nombre;
    private Estado presente;

    public Asistencia(){

    }

    public Asistencia(Integer id, String nombre, Estado presente) {
        this.id = id;
        this.nombre = nombre;
        this.presente = presente;
    }

    public Asistencia(String nombre, Estado presente) {
        this.nombre = nombre;
        this.presente = presente;
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

    public Estado getPresente() {
        return presente;
    }

    public void setPresente(Estado presente) {
        this.presente = presente;
    }

    @Override
    public String toString() {
        return "Asistencia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", presente=" + presente +
                '}';
    }
}
