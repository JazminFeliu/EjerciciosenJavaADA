package com.company;

import java.time.LocalDate;

public class MotoElectrica extends Vehiculo implements VehiculoElectrico {
    protected MotoElectrica(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente) {
        super(idRegistroSeccional, fechaDeAlta, patente);
    }
}

