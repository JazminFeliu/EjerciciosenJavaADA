package com.company;

import java.time.LocalDate;
import java.util.List;

public class AutoElectrico extends Vehiculo implements IVehiculoElectrico {

    public AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados);
    }

    public AutoElectrico(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario);
    }

    @Override
    public void solicitarVoltaje() {
        System.out.println("bateria: 100 kWh, autonomía 555 km.");
    }
}
