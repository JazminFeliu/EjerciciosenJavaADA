package com.company;

import java.util.ArrayList;
import java.util.List;

public class Alumna {
    private List<Integer> notas;
    private String nombre;
    private Integer promedio;

    public Alumna(String nombre, ArrayList<Integer> notas){
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre(){
        return nombre;
    }

    public Integer getPromedio(){
        int suma = 0;
        for(int i = 0; i < notas.size(); i++){
            suma += notas.get(i);
        }
        promedio = suma /notas.size();
        return promedio;
    }
}
