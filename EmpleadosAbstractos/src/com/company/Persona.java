package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {

    private String nombre;
    private String dni;
    private String domicilio;
    private List<Tarea>tareasPendientes;

    public Persona(String nombre, String dni, String domicilio) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.tareasPendientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Tarea getProximaTareaPendiente(){
        return(tareasPendientes.size() > 0) ? tareasPendientes.get(0):null;
    }

    public void agregarTareaPendiente (Tarea t){
        tareasPendientes.add(t);
    }

    protected void eliminarTareaPendiente(Tarea t){
        tareasPendientes.remove(t);
    }


    public abstract Integer calcularSalario();
}

