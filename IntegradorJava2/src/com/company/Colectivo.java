package com.company;

import java.time.LocalDate;
import java.util.List;

public class Colectivo extends Vehiculo implements VehiculoACombustion {


    protected Colectivo(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario, autorizados);
    }

    protected Colectivo(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, propietario);
    }
}


