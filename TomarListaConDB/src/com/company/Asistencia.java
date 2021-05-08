package com.company;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asistencias")

public class Asistencia {

    @Id
    private Integer idAsistencia;
    private Integer idAlumna;
    private Integer idCurso;
    private String registroDeAsistencias;

    public Asistencia() {
    }

    public Integer getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(Integer idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Integer getIdAlumna() {
        return idAlumna;
    }

    public void setIdAlumna(Integer idAlumna) {
        this.idAlumna = idAlumna;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getRegistroDeAsistencias() {
        return registroDeAsistencias;
    }

    public void setRegistroDeAsistencias(String registroDeAsistencias) {
        this.registroDeAsistencias = registroDeAsistencias;
    }

    @Override
    public String toString() {
        return "com.company.Asistencia{" +
                "idAsistencia=" + idAsistencia +
                ", idAlumna=" + idAlumna +
                ", idCurso=" + idCurso +
                ", registroDeAsistencias='" + registroDeAsistencias + '\'' +
                '}';
    }
}
