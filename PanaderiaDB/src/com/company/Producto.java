package com.company;


public class Producto {

    private Integer idProducto;
    private String nombre;
    private Integer precio;
    private Integer stock;

    public Producto(Integer idProducto, String nombre, Integer precio, Integer stock){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(){

    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Integer getStock(){
        return stock;
    }

    public Integer getPrecio(){
        return this.precio;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setPrecio(Integer precio){
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
