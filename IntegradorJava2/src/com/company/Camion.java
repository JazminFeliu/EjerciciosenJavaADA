package com.company;

import java.time.LocalDate;

public class Camion extends Vehiculo implements VehiculoACombustion {
    protected Camion(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente) {
        super(idRegistroSeccional, fechaDeAlta, patente);
    }
}
