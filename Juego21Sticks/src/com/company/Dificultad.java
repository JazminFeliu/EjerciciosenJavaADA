package com.company;

public enum Dificultad {
    FACIL(3),
    MEDIO(5),
    DIFICIL(8);

    private int nivel;

    Dificultad(int n){
        nivel = n;
    }

    public void setNivel(int n){
        this.nivel = n;
    }

    public int getNivel(){
        return this.nivel;
    }
}

