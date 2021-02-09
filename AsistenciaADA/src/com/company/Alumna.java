package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Alumna {

    List<Asistencia> asistencias;

    public Alumna(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public boolean asistioAClase(LocalDateTime fecha) {
        for(Asistencia asistencia: asistencias){
            if(asistencia.getFechaClase().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    public boolean asistioAClaseEnVivo(LocalDate fecha) {
        for(Asistencia asistencia: asistencias){
            if(asistencia.getFechaClase().equals(fecha) && asistencia.isEnVivo()) {
                return true;
            }
        }
        return false;
    }
}
