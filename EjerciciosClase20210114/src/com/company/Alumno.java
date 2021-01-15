package com.company;

public class Alumno {


    private Double promedio;
    private Double [] notas;

    public Alumno(){

        notas = new Double[3];
    }

    public Double getPromedio() {

        return promedio;
    }

    public Double[] getNotas(){
        return notas;
    }

    public void setNotas(Double[] notas ){
        this.notas = notas;
    }

    public void guardarNota(Double nota, int posicion){
        notas[posicion] = nota;
    }

}
