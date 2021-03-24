package com.company;

import java.time.LocalDate;
import java.util.List;

public class AutoElectrico extends Vehiculo implements IVehiculoElectrico {

    public AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados, fechaCambioPropietario);
    }

    public AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, fechaCambioPropietario);
    }

    @Override
    public void solicitarVoltaje() {
        System.out.println("bateria: 100 kWh, autonomía 555 km.");
    }
}
