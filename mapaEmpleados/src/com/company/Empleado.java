package com.company;

public class Empleado {

    private String nombre;
    private Integer nroEmpleado;
    private String dni;
    private Integer edad;
    private String direccion;
    private String puesto;

    public Empleado(){

    }
    public Empleado(String nombre, Integer nroEmpleado) {
        this.nombre = nombre;
        this.nroEmpleado = nroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNroEmpleado() {
        return nroEmpleado;
    }

    public void setNroEmpleado(Integer nroEmpleado) {
        this.nroEmpleado = nroEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", nroEmpleado=" + nroEmpleado +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }
}

