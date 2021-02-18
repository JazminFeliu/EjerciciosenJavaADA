package com.company;

import java.time.LocalDate;

public class Colectivo extends Vehiculo implements VehiculoACombustion {
    protected Colectivo(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente) {
        super(idRegistroSeccional, fechaDeAlta, patente);
    }
}


