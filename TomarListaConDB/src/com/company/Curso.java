package com.company;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table (name = "cursos")
public class Curso {

    @Id
    private Integer idCurso;
    private String nombreCurso;
    private LocalDate fechaInicio;
    private String diasDeCursada;
    private Integer cantidadDeClases;
    private Integer idDocente;

    public Curso() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
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

    public Integer getCantidadDeClases() {
        return cantidadDeClases;
    }

    public void setCantidadDeClases(Integer cantidadDeClases) {
        this.cantidadDeClases = cantidadDeClases;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nombreCurso='" + nombreCurso + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", diasDeCursada='" + diasDeCursada + '\'' +
                ", cantidadDeClases=" + cantidadDeClases +
                ", idDocente=" + idDocente +
                '}';
    }
}
