package com.company;

public class Articulo {

    private String tipo;
    private String nombre;
    private Integer cantidad;

    public Articulo (String tipo, String nombre, Integer cantidad){
        this.tipo = tipo;
        this.nombre = nombre;
        this.cantidad = cantidad;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Integer getCantidad(){
        return cantidad;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}

