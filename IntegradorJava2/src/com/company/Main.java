package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //sistema DNRPA para anotar todos los vehiculos registrados del pais.

        DNRPA registroNacional = new DNRPA();
        RegistroSeccional seccional;
        seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);
        seccional.darAltaPropietario(new Persona("Seba"));
        List<Persona> autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Juan"),
                new Persona("Jazmin"),
                new Persona("Lucia")
        ));
        seccional.darAltaAutorizados(autorizados);

        Auto auto1;
        auto1 = new Auto (
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(auto1);

        seccional.darAltaPropietario(new Persona("Vivian"));
        autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Nora"),
                new Persona("Pedro")
        ));
        seccional.darAltaAutorizados(autorizados);

        Auto auto2;
        auto2 = new Auto (
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(auto2);

        seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);

        seccional.darAltaPropietario(new Persona("Wilfredo"));
        autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Rosa"),
                new Persona("Vilma"),
                new Persona("Roberto")
        ));
        seccional.darAltaAutorizados(autorizados);

        Camion camion1;
        camion1 = new Camion(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(camion1);

        seccional.darAltaPropietario(new Persona("Anastasia"));

        Moto moto1;
        moto1 = new Moto(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(moto1);

        seccional.darAltaPropietario(new Persona("Tomas"));

        AutoElectrico autoElectrico1;
        autoElectrico1 = new AutoElectrico(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(autoElectrico1);

        seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);

        seccional.darAltaPropietario(new Persona ("Maria"));
        autorizados = new ArrayList<>(Arrays.asList(
                new Persona("Tito"),
                new Persona("Ana")
        ));
        seccional.darAltaAutorizados(autorizados);

        Camion camion2;
        camion2 = new Camion(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(camion2);

        AutoElectrico autoElectrico2;
        autoElectrico2 = new AutoElectrico(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario(),
                seccional.getAutorizados());

        seccional.darAltaVehiculo(autoElectrico2);

        seccional.darAltaPropietario(new Persona("Silvio"));

        Utilitario utilitario;
        utilitario = new Utilitario(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getUso(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(utilitario);

        registroNacional.listarTodosLosVehiculosDelPais();
        System.out.println("-------------------------------------------------------------------------");
        for(RegistroSeccional rs: registroNacional.getRegistrosSeccionales()){
            for(Vehiculo v : rs.getVehiculos()) {
                if (v instanceof Auto || v instanceof AutoElectrico) {
                    registroNacional.agregarATodosLosAutos(v);
                }else if(v instanceof Camion)
                    registroNacional.agregarATodosLosCamiones(v);
            }
        }
        //Listar todos los autos registrados en todas las seccionales
        System.out.println("Listado de AUTOS de todos los Registros Seccionales:");
        registroNacional.listarTodosLosAutos();
        System.out.println("-------------------------------------------------------------------------");

         //Listar todos los propietarios de camiones en orden alfabetico.
        System.out.println("Listado de PROPIETARIOS de CAMIONES de todos los Registros Seccionales:");
        registroNacional.listarTodosLosCamiones();

        //cambio de propietario
        Persona nuevoPropietario = new Persona("Joe Satriani");
        registroNacional.cambiarPropietario(autoElectrico2, nuevoPropietario);
        registroNacional.cambiarPropietario(auto1, nuevoPropietario);

        Auto auto3 = new Auto(1,LocalDate.of(2020,2,10), "ARE435" ,"particular",nuevoPropietario);
        registroNacional.cambiarPropietario(auto3, seccional.getPropietario());


        //consulta de antiguedad de alta de vehiculos
        registroNacional.consultarAntiguedadAltaVehiculo(auto1);
        registroNacional.consultarAntiguedadAltaVehiculo(auto2);
        registroNacional.consultarAntiguedadAltaVehiculo(auto3);
        registroNacional.consultarAntiguedadAltaVehiculo(autoElectrico1);
        registroNacional.consultarAntiguedadAltaVehiculo(autoElectrico2);
        registroNacional.consultarAntiguedadAltaVehiculo(camion1);
        registroNacional.consultarAntiguedadAltaVehiculo(camion2);
        registroNacional.consultarAntiguedadAltaVehiculo(moto1);
        registroNacional.consultarAntiguedadAltaVehiculo(utilitario);

        //consulta de fechas de cambio de propietario
        registroNacional.consultarAntiguedadCambioPropietario(auto1);
        registroNacional.consultarAntiguedadCambioPropietario(auto2);
        registroNacional.consultarAntiguedadCambioPropietario(camion2);
        registroNacional.consultarAntiguedadCambioPropietario(auto3);
        registroNacional.consultarAntiguedadCambioPropietario(autoElectrico1);
        registroNacional.consultarAntiguedadCambioPropietario(utilitario);
        registroNacional.consultarAntiguedadCambioPropietario(autoElectrico2);
        registroNacional.consultarAntiguedadCambioPropietario(camion1);
        registroNacional.consultarAntiguedadCambioPropietario(moto1);

    }
}
