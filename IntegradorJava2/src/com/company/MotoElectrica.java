package com.company;

import java.time.LocalDate;
import java.util.List;

public class MotoElectrica extends Vehiculo implements VehiculoElectrico {


    protected MotoElectrica(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario, autorizados);
    }

    protected MotoElectrica(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario);
    }
}

