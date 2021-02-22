package com.company;

import java.time.LocalDate;
import java.util.List;

public class Moto extends Vehiculo implements VehiculoACombustion {


    protected Moto(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, String uso, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados);
    }

    protected Moto(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, String uso, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario);
    }
}
