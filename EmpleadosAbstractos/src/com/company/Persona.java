package com.company;

import java.util.ArrayList;
import java.util.List;

public abstract class Persona {

    protected String nombre;
    protected String dni;
    protected String domicilio;

    public Persona(String nombre, String dni, String domicilio) {
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    public abstract Integer calcularSalario();
}

