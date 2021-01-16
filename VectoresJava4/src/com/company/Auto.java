package com.company;

public class Auto {

    private String marca;
    private Integer anio;
    private String modelo;
    private Double precio;

    public Auto(String marca, Integer anio, String modelo, Double precio){
        this.marca = marca;
        this.anio = anio;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMarca(){
        return marca;
    }

    public Integer getAnio(){
        return anio;
    }
    public String getModelo(){
        return modelo;
    }
    public Double getPrecio(){
        return precio;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public String fichaTecnica(){
        return marca+", "+modelo+", "+anio+", "+precio;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + marca + '\'' +
                ", anio=" + anio +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                '}';
    }
}


