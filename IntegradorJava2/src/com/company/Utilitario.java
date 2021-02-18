package com.company;

import java.time.LocalDate;

public class Utilitario extends Vehiculo implements VehiculoACombustion {

    protected Utilitario(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente) {
        super(idRegistroSeccional, fechaDeAlta, patente);
    }
}
