package com.company;

public class Servicio {
    //Cada servicio tiene un costo por hora y una cantidad de horas. Además del nombre del servicio, el nombre de la
    //	persona que lo ejecuta y una descripcion.

    private Integer cantidad;
    private Double costoPorHora;
    private String nombreServicio;
    public String nombreProfesional;
    private String descripcion;


    public Servicio(Integer cantidad, Double costoPorHora, String nombreServicio, Profesional profesional, String descripcion) {
        this.cantidad = cantidad;
        this.costoPorHora = costoPorHora;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.nombreProfesional = profesional.getNombre();
        this.descripcion = descripcion;
    }

    public String getNombreProfesional() {
        return nombreProfesional;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getCostoPorHora() {
        return costoPorHora;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

}


