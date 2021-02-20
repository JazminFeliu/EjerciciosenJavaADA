package com.company;

import java.time.LocalDate;
import java.util.List;

public class Utilitario extends Vehiculo implements VehiculoACombustion {


    protected Utilitario(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario, autorizados);
    }
    protected Utilitario(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario);
    }

}
