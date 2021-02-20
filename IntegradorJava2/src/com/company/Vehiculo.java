package com.company;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public abstract class Vehiculo {

    protected Integer idRegistroSeccional;
    protected String patente;
    protected String uso; //uso particular o profesional
    protected Persona propietario;
    protected List<Persona>autorizados;
    protected LocalDate fechaDeAlta;
    protected LocalDate fechaCambioPropietario;


    protected Vehiculo(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario, List<Persona>autorizados) {
        this.idRegistroSeccional = idRegistroSeccional;
        this.fechaDeAlta = fechaDeAlta;
        this.patente = patente;
        this.propietario = propietario;
        this.autorizados = autorizados;
    }
    protected Vehiculo(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario){
        this.idRegistroSeccional = idRegistroSeccional;
        this.fechaDeAlta = fechaDeAlta;
        this.patente = patente;
        this.propietario = propietario;

    }

    protected void setIdRegistroSeccional(Integer idRegistroSeccional) {
        this.idRegistroSeccional = idRegistroSeccional;
    }

    protected Integer getIdRegistroSeccional() {
        return this.idRegistroSeccional;
    }

}



