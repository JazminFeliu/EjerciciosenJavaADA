package com.company;

import java.time.LocalDate;
import java.util.List;

public class Moto extends Vehiculo implements VehiculoACombustion {


    protected Moto(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario, autorizados);
    }

    protected Moto(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario);
    }
}
