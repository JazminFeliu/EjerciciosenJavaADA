package com.company;

import java.time.LocalDate;
import java.util.List;

public class AutoElectrico extends Vehiculo implements VehiculoElectrico {


    protected AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario, autorizados);
    }

    protected AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario);
    }
}
