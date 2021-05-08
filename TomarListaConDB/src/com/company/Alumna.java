package com.company;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="alumnas")
public class Alumna {

    @Id
    private Integer idAlumna;
    private String nombreAlumna;
    private String legajo;

    public Alumna() {
    }

    public Integer getIdAlumna() {
        return idAlumna;
    }

    public void setIdAlumna(Integer idAlumna) {
        this.idAlumna = idAlumna;
    }

    public String getNombreAlumna() {
        return nombreAlumna;
    }

    public void setNombreAlumna(String nombreAlumna) {
        this.nombreAlumna = nombreAlumna;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Alumna{" +
                "idAlumna=" + idAlumna +
                ", nombreAlumna='" + nombreAlumna + '\'' +
                ", legajo='" + legajo + '\'' +
                '}';
    }
}
