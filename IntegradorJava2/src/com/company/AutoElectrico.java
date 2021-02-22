package com.company;

import java.time.LocalDate;
import java.util.List;

public class AutoElectrico extends Vehiculo implements VehiculoElectrico {


    private Integer voltaje;
    protected AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, String uso, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados);

    }

    protected AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, String uso, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario);
    }

    @Override
    public void solicitarVoltaje() {
        this.voltaje = 220;
    }
}
