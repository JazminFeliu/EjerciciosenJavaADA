package com.company;

import java.time.LocalDate;
import java.util.List;

public class Camion extends Vehiculo implements IVehiculoACombustion {

    public Camion(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados);
    }

    public Camion(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario);
    }

    @Override
    public void solicitarPotencia() {
        System.out.println("Se carga en la categoria camiones pesados de hasta 8 perons de entre 7,5 y 9 t con motores a gasolina. ");

    }
}
