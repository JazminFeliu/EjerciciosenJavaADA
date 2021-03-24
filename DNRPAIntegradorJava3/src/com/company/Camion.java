package com.company;

import java.time.LocalDate;
import java.util.List;

public class Camion extends Vehiculo implements IVehiculoACombustion {

    public Camion(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados, fechaCambioPropietario);
    }

    public Camion(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, fechaCambioPropietario);
    }

    @Override
    public void solicitarPotencia() {
        System.out.println("Se carga en la categoria camiones pesados de hasta 8 pernos de entre 7,5 y 9 ton, con motores a gasolina. ");

    }
}
