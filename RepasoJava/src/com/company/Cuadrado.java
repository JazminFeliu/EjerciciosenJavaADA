package com.company;

public class Cuadrado extends Figura {

    private Double lado;

    public Cuadrado(Double lado, String color) {
        this.lado = lado;
        this.color = color;
    }


    @Override
    public Double getPerimetro() {
        return lado*4;
    }

    @Override
    public Double getArea() {
        return lado*lado;
    }
}
