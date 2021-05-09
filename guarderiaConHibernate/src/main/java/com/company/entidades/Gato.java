package com.company.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Gato extends Animal{

    private String color;
    private Integer cantidadDeVidas;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCantidadDeVidas() {
        return cantidadDeVidas;
    }

    public void setCantidadDeVidas(Integer cantidadDeVidas) {
        this.cantidadDeVidas = cantidadDeVidas;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "color='" + color + '\'' +
                ", cantidadDeVidas=" + cantidadDeVidas +
                '}';
    }
}
