package com.company.entidades;

import javax.persistence.Entity;

@Entity
public class Ave extends Animal {
    private int cantidadPlumas;
    private Integer cantidadAlas;

    public int getCantidadPlumas() {
        return cantidadPlumas;
    }

    public void setCantidadPlumas(int cantidadPlumas) {
        this.cantidadPlumas = cantidadPlumas;
    }

    public Integer getCantidadAlas() {
        return cantidadAlas;
    }

    public void setCantidadAlas(Integer cantidadAlas) {
        this.cantidadAlas = cantidadAlas;
    }

    @Override
    public String toString() {
        return "Ave{" +
                "cantidadPlumas=" + cantidadPlumas +
                ", cantidadAlas=" + cantidadAlas +
                '}';
    }
}

