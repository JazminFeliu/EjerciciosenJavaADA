package com.company;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public abstract class Vehiculo {

    protected Integer idRegistroSeccional;
    protected String patente;
    protected List<Vehiculo> vehiculos;
    protected String uso; //uso particular o profesional
    protected Persona propietario;
    protected List<Persona>autorizados;
    protected LocalDate fechaDeAlta;
    protected LocalDate fechaCambioPropietario;


    protected Vehiculo(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente) {
        this.idRegistroSeccional = idRegistroSeccional;
        this.fechaDeAlta = fechaDeAlta;
        this.patente = patente;

    }

    protected void setIdRegistroSeccional(Integer idRegistroSeccional) {
        this.idRegistroSeccional = idRegistroSeccional;
    }

    protected Integer getIdRegistroSeccional() {
        return this.idRegistroSeccional;
    }

}



