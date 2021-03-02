package com.company;

public class Servicio extends Elemento implements Item{
    //Cada servicio tiene un costo por hora y una cantidad de horas. Además del nombre del servicio, el nombre de la
    //persona que lo ejecuta y una descripcion.

    private Double precio;
    private Integer cantidad;
    private String profesional;
    private Double total;


    public Servicio(String nombre, String descripcion, Double precio, Integer cantidad, String profesional){
        super(nombre, descripcion);
        this.precio = precio;
        this.cantidad = cantidad;
        this.profesional = profesional;
    }

    public Servicio(String nombre, String descripcion, Double precio, String profesional){
        super(nombre, descripcion);
        this.precio = precio;
        this.profesional = profesional;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
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

    public Integer getCantidad() {
    return cantidad;
    }

    @Override
    public Double calcularTotal() {
        return precio*cantidad;
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
}
