package com.company;

import java.time.LocalDate;
import java.util.List;

public class Colectivo extends Vehiculo implements IVehiculoACombustion {

    public Colectivo(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados, fechaCambioPropietario);
    }

    public Colectivo(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, fechaCambioPropietario);
    }

    @Override
    public void solicitarPotencia() {
        System.out.println("El 1114 y similares registran una potencia de 145 HP");

    }
}
