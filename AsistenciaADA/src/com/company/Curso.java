package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    List<Alumna> alumnas;
    Profesor profesor;
    Integer cantidadDeClases;

    public List<Alumna> getAlumnas() {
        return alumnas;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Alumna> listarAsistentesEnVivoALaClase(LocalDate fecha){
        List<Alumna>asistentes = new ArrayList<>();
        for(Alumna a:alumnas){
            if(a.asistioAClaseEnVivo(fecha)){
                asistentes.add(a);
            }
        }
        return asistentes;
    }
    public List<Alumna> listarAsistentesALaClase(LocalDateTime fecha){
        List<Alumna>asistentes = new ArrayList<>();
        for(Alumna a:alumnas){
            if(a.asistioAClase(fecha)){
                asistentes.add(a);
            }
        }
        return asistentes;
    }

}
