package com.company;

import java.time.LocalDate;
import java.util.List;

public class Utilitario extends Vehiculo implements VehiculoACombustion {


    protected Utilitario(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, String uso, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados);
    }
    protected Utilitario(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, String uso, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario);
    }

}
