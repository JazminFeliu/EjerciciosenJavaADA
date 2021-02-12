package com.company;

import java.util.ArrayList;
import java.util.List;

public class Episodio implements Medio {

    private double duracion;
    private double progreso;
    private List<Subtitulo> subtitulos = new ArrayList<>();

    @Override
    public void reproducir() {
        this.progreso += 5.0;

    }
}
