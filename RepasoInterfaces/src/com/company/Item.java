package com.company;

import java.util.LinkedList;
import java.util.List;

public class Item {

    public String tipoItem;
    public Integer cantidadItem;
    public String nombre;
    public Double precio;
    public String descripcion;
    public String nombreProfesional;

    public Item(){

    }
    public Item(Producto producto, Integer cantidadItem ) {
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.precio = producto.getPrecioUnitario();
        this.tipoItem = "p";
        this.cantidadItem = cantidadItem;
    }

    public Item(Servicio servicio, Integer cantidadItem) {
        this.nombre = servicio.getNombreServicio();
        this.descripcion = servicio.getDescripcion();
        this.nombreProfesional = servicio.getNombreProfesional();
        this.precio = servicio.getCostoPorHora();
        this.cantidadItem = cantidadItem;
        this.tipoItem = "s";
    }

}
