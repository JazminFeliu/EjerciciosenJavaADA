package com.company;

import java.time.LocalDate;

public class Moto extends Vehiculo implements VehiculoACombustion {
    protected Moto(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente) {
        super(idRegistroSeccional, fechaDeAlta, patente);
    }
}
