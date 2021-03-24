package com.company;

import java.time.LocalDate;
import java.util.List;

public class Auto extends Vehiculo implements IVehiculoACombustion{

    public Auto(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados, fechaCambioPropietario);
    }

    public Auto(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, fechaCambioPropietario);
    }

    @Override
    public void solicitarPotencia() {
        System.out.println("La potencia de la categoria AUTO es de hasta 360 HP, deportivos tiene su propia categoria");
    }
}
