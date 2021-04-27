package com.company;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asistencias")
public class Asistencia {

    @Id private int id;
    private String nombre;
    private Estado presente;

    public Asistencia() {
    }

    public Asistencia(String nombre, Estado presente) {
        this.nombre = nombre;
        this.presente = presente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
