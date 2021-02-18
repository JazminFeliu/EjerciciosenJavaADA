package com.company;

import java.time.LocalDate;

public class Auto extends Vehiculo implements VehiculoACombustion {
    public Auto(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente) {
        super(idRegistroSeccional, fechaDeAlta, patente);
    }
}

