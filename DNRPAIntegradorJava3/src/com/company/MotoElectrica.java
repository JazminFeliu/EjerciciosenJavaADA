package com.company;

import java.time.LocalDate;
import java.util.List;

public class MotoElectrica extends Vehiculo implements IVehiculoElectrico {

    public MotoElectrica(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, List<Persona> autorizados, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, autorizados, fechaCambioPropietario);
    }

    public MotoElectrica(Integer idRegistroSeccional, LocalDate fechaDeAlta, String patente, Uso uso, Persona propietario, LocalDate fechaCambioPropietario) {
        super(idRegistroSeccional, fechaDeAlta, patente, uso, propietario, fechaCambioPropietario);
    }

    @Override
    public void solicitarVoltaje() {
        System.out.println("Potencia maxima: 2,5 kW alcanza una velocidad de 55 km/h");
    }
}
