package com.company;

import java.time.LocalDate;

public class Curso {

    private Integer idCurso;
    private String nombre;
    private LocalDate fechaInicio;
    private String diasDeCursada;
    private Integer cantiadDeClases;
    private Integer docente;

    public Curso(Integer idCurso, String nombre, LocalDate fechaInicio, String diasDeCursada, Integer cantiadDeClases, Integer docente) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.diasDeCursada = diasDeCursada;
        this.cantiadDeClases = cantiadDeClases;
        this.docente = docente;
    }

    public Curso(){

    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDiasDeCursada() {
        return diasDeCursada;
    }

    public void setDiasDeCursada(String diasDeCursada) {
        this.diasDeCursada = diasDeCursada;
    }

    public Integer getCantiadDeClases() {
        return cantiadDeClases;
    }

    public void setCantiadDeClases(Integer cantiadDeClases) {
        this.cantiadDeClases = cantiadDeClases;
    }

    public Integer getDocente() {
        return docente;
    }

    public void setDocente(Integer docente) {
        this.docente = docente;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", diasDeCursada='" + diasDeCursada + '\'' +
                ", cantiadDeClases=" + cantiadDeClases +
                ", docente=" + docente +
                '}';
    }
}
