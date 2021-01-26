package com.company;

public abstract class Figura {

    protected Double perimetro;
    protected Double area;
    protected Cuadrado cuadrado;
    protected Circulo circulo;
    protected Triangulo triangulo;
    protected String color;

    public Figura() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPerimetro(Double perimetro) {
        this.perimetro = perimetro;
    }

    public  Double getPerimetro() {
        return perimetro;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public  Double getArea() {
        return area;
    }
}
