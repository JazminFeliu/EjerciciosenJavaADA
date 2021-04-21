package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Asistencia vane = new Asistencia("vane", Estado.AUSENTE);
        System.out.println("Nueva: "+vane );

        AsistenciaDAO.save(vane);

        List<Asistencia>lista = AsistenciaDAO.getPresentes();
        for(Asistencia a: lista)
            System.out.println(a);
    }
}
