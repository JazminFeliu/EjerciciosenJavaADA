package com.company;

import java.time.LocalDate;
import java.util.List;

public abstract class Vehiculo {

    protected Integer idRegistroSeccional;
    protected String patente;
    protected String uso;
    protected Persona propietario;
    protected List<Persona> autorizados;
    protected LocalDate fechaDeAlta;
    protected LocalDate fechaCambioPropietario;

    protected Vehiculo (Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, String uso, Persona propietario, List<Persona> autorizados) {
        this.idRegistroSeccional = idRegistroSeccional;
        this.fechaDeAlta = fechaDeAlta;
        this.patente = patente;
        this.uso = uso;
        this.propietario = propietario;
        this.autorizados = autorizados;
    }

    protected Vehiculo (Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, String uso, Persona propietario) {
        this.idRegistroSeccional = idRegistroSeccional;
        this.fechaDeAlta = fechaDeAlta;
        this.patente = patente;
        this.uso = uso;
        this.propietario = propietario;
    }

    protected Integer getIdRegistroSeccional(){
        return this.idRegistroSeccional;
    }

}
