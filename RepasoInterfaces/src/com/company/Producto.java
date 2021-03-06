package com.company;

public class Producto {
    //Cada producto tiene una cantidad, un precio unitario, un nombre y una descripcion.
        private Integer cantidad;// aca lo carga el usuario cuando cargamos el item, repasar como utilizar una interfaz nueva Item
        private Double precioUnitario;
        private String nombre;
        private String descripcion;

    public Producto(Integer cantidad, Double precioUnitario, String nombre, String descripcion) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
