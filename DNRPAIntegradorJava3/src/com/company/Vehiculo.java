package com.company;

import java.time.LocalDate;
import java.util.List;

public abstract class Vehiculo {

    protected Integer idRegistroSeccional;
    protected String patente;
    protected Uso uso;
    protected Persona propietario;
    protected List<Persona> autorizados;
    protected LocalDate fechaDeAlta;
    protected LocalDate fechaCambioPropietario;

    protected Vehiculo (Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados, LocalDate fechaCambioPropietario) {
        this.idRegistroSeccional = idRegistroSeccional;
        this.fechaDeAlta = fechaDeAlta;
        this.patente = patente;
        this.uso = uso;
        this.propietario = propietario;
        this.autorizados = autorizados;
        this.fechaCambioPropietario = fechaCambioPropietario;
    }

    protected Vehiculo (Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, LocalDate fechaCambioPropietario) {
        this.idRegistroSeccional = idRegistroSeccional;
        this.fechaDeAlta = fechaDeAlta;
        this.patente = patente;
        this.uso = uso;
        this.propietario = propietario;
        this.fechaCambioPropietario = fechaCambioPropietario;
    }

    protected Integer getIdRegistroSeccional(){
        return this.idRegistroSeccional;
    }

}
