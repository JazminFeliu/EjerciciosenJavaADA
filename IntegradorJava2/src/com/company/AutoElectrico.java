package com.company;

import java.time.LocalDate;

public class AutoElectrico extends Vehiculo implements VehiculoElectrico {


    protected AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente) {
        super(idRegistroSeccional, fechaDeAlta, patente);
    }
}
