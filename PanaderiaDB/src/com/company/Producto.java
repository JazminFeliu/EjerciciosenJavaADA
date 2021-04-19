package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
