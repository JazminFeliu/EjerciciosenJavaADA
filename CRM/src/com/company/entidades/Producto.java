package com.company.entidades;

import com.company.entidades.Elemento;
import com.company.entidades.Item;

import javax.persistence.*;

@Entity
@Table (name = "productos")
public class Producto extends Elemento implements Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private String nombreProducto;
    private Integer cantidad;
    private Double precio;
    private Double total;

    public Producto( Integer idProducto, String nombre, String descripcion, Double precio, int cantidad){
        this.idProducto =idProducto;
        this.nombre = nombre;
        this.descripcion= descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String nombre, String descripcion, Double precio){
        this.nombre = nombre;
        this.descripcion= descripcion;
        this.precio = precio;
    }

    public Producto(){
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public Double calcularTotal() {
        return cantidad * precio;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalle del producto: "+nombre);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Cantidad: "+cantidad);
        System.out.println("Precio:"+precio);
        total = calcularTotal();
        System.out.println("Total del producto: "+total);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", total=" + total +
                '}';
    }
}
