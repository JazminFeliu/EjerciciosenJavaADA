package com.company;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private List<Alumna> alumnas;

    public Materia(){
        alumnas = new ArrayList<>();

        ArrayList<Integer> notas = new ArrayList<>();
        notas.add(8);
        notas.add(6);
        notas.add(10);
        Alumna alumna1 = new Alumna("Jazmin", notas);
        alumnas.add(alumna1);

        notas.set(0,10);
        notas.set(1,9);
        notas.set(2,10);
        Alumna alumna2 = new Alumna("Caro",notas);
        alumnas.add(alumna2);
    }


    public List<Alumna> getAlumnas() {
        return alumnas;
    }
}
