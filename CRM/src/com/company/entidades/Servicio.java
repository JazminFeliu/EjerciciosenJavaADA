package com.company.entidades;

import com.company.entidades.Elemento;
import com.company.entidades.Item;

import javax.persistence.*;

@Entity
@Table (name = "servicios")
public class Servicio extends Elemento implements Item {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idServicio;
    private String nombreServicio;
    private Double precio;
    private Integer cantidad;
    private String profesional;
    private Double total;


    public Servicio(Integer idServicio, String nombre, String descripcion, Double precio, Integer cantidad, String profesional){
        this.nombreServicio=nombre;
        this.descripcion=descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.profesional = profesional;
    }

    public Servicio(String nombre, String descripcion, Double precio, String profesional){
        this.nombreServicio =nombre;
        this.descripcion =descripcion;
        this.precio = precio;
        this.profesional = profesional;
    }

    public Servicio() {
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public Double calcularTotal() {
        return precio * cantidad;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalle del servicio: "+nombre);
        System.out.println("Descripción: "+descripcion);
        System.out.println("Profesional a cargo: "+profesional);
        System.out.println("Costo por hora: "+precio);
        System.out.println("Cantidad: "+cantidad);
        total = calcularTotal();
        System.out.println("Total del servicio solicitado: "+total);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", nombreServicio='" + nombreServicio + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", profesional='" + profesional + '\'' +
                ", total=" + total +
                '}';
    }
}
