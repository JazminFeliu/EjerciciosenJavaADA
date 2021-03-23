package com.company;

import java.time.LocalDate;
import java.util.List;

public class Utilitario extends Vehiculo implements IVehiculoACombustion {

    public Utilitario(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados);
    }

    public Utilitario(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario);
    }

    @Override
    public void solicitarPotencia() {
        System.out.println("Potencia de los utilitarios de la categoria: hasta 250 HP");

    }
}
