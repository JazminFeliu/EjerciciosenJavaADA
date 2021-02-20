package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //sistema para anotar todos los vehiculos registrados del pais.

        DNRPA registroNacional = new DNRPA();
        RegistroSeccional seccional;
        seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);
        seccional.darAltaPropietario(new Persona("Seba"));
        List<Persona> autorizados1 = new ArrayList<>(Arrays.asList(
                new Persona("Juan"),
                new Persona("Jazmin"),
                new Persona("Lucia")
        ));
        seccional.darAltaAutorizados(autorizados1);

        Auto auto1;

        auto1 = new Auto (
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(auto1);

        seccional.darAltaPropietario(new Persona("Vivian"));
        List<Persona> autorizados12 = new ArrayList<>(Arrays.asList(
                new Persona("Nora"),
                new Persona("Pedro")
        ));
        seccional.darAltaAutorizados(autorizados12);
        Auto auto2;
        auto2 = new Auto (
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(auto2);

        /*seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);

        seccional.darAltaPropietario(new Persona("Maria"));
        List<Persona> autorizados2 = new ArrayList<>(Arrays.asList(
                new Persona("Rosa"),
                new Persona("Vilma"),
                new Persona("Roberto")
        ));
        seccional.darAltaAutorizados(autorizados2);

        Camion camion1;
        camion1 = new Camion(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(camion1);

        seccional.darAltaPropietario(new Persona("Anastasia"));

        Moto moto1;
        moto1 = new Moto(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(moto1);

        seccional.darAltaPropietario(new Persona("Tomas"));

        AutoElectrico autoElectrico1;
        autoElectrico1 = new AutoElectrico(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(autoElectrico1);

        seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);

        seccional.darAltaPropietario(new Persona ("Wilfredo"));
        List<Persona> autorizados3 = new ArrayList<>(Arrays.asList(
                new Persona("Tito"),
                new Persona("Ana")
        ));
        seccional.darAltaAutorizados(autorizados3);

        Camion camion2;
        camion2 = new Camion(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getPropietario(),
                seccional.getAutorizados());
        seccional.darAltaVehiculo(camion2);

        AutoElectrico autoElectrico2;
        autoElectrico2 = new AutoElectrico(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(autoElectrico2);

        seccional.darAltaPropietario(new Persona("Silvio"));

        Utilitario utilitario;
        utilitario = new Utilitario(
                seccional.getIdRegistroSeccional(),
                seccional.getFechaDeAlta(),
                seccional.getPatente(),
                seccional.getPropietario());
        seccional.darAltaVehiculo(utilitario);*/

        System.out.println("Cantidad de registros: "+registroNacional.obtenerCantidadRegistrosSeccionales());

        for (RegistroSeccional r: registroNacional.getRegistrosSeccionales()){
            System.out.println("Registro Nro.: "+r.getIdRegistroSeccional());
            for (Vehiculo v: r.getVehiculos()) {
                 System.out.println(v.patente);
            }
        }

        //Listar todos los autos registrados en todas las seccionales
        List<Vehiculo>todosLosAutos = new LinkedList<>();
        HashSet<Vehiculo> todosLosCamiones = new HashSet<>();

        for(RegistroSeccional rs: registroNacional.getRegistrosSeccionales()){
            for(Vehiculo v : rs.getVehiculos()) {
                if (v instanceof Auto || v instanceof AutoElectrico) {
                    todosLosAutos.add(v);
                }else if(v instanceof Camion)
                    todosLosCamiones.add(v);
            }
        }
        System.out.println("Listado de autos de todos los Registros Seccionales:");
        System.out.println("Cantidad de autos: "+todosLosAutos.size() );
        System.out.println();

        for(Vehiculo auto : todosLosAutos){
            System.out.println("Registro Seccional Nro.: "+auto.idRegistroSeccional);
            System.out.println("Patente: "+auto.patente);
            System.out.println("Tipo de auto: "+auto.getClass().getSimpleName());
            //System.out.println("Uso: "+auto.uso);
            System.out.println("Fecha de alta en el Registro: "+auto.fechaDeAlta);
            System.out.println("Propietario: "+auto.propietario.getNombre());
            System.out.print("Autorizados a manejar el vehiculo: ");
            for (Persona p: seccional.getAutorizados()){
                System.out.print(p.getNombre()+" /");
            }
            System.out.println();
            //System.out.println("Fecha de transferencia a otro propietario: "+auto.fechaCambioPropietario);
            System.out.println();
        }

        //Listar todos los propietarios de camiones en orden alfabetico.

        System.out.println("Listado de propietarios de camiones de todos los Registros Seccionales:");
        System.out.println("Cantidad de camiones: "+todosLosCamiones.size());
        System.out.println();
        for (Vehiculo camion: todosLosCamiones){
            System.out.println();
            System.out.println("Propietario: "+camion.propietario.getNombre());
            System.out.println("Patente: "+camion.patente);
            System.out.println("Registro Seccional Nro.: "+camion.getIdRegistroSeccional());
            System.out.print("Autorizados a manejar el camion: ");
            for (Persona p: seccional.getAutorizados()){
                System.out.print(p.getNombre()+" /");
            }
            System.out.println();
            System.out.println("Tipo de Vehiculo: "+camion.getClass().getSimpleName());
            //System.out.println("Uso: "+camion.uso);
            System.out.println("Fecha de alta en el Registro: "+camion.fechaDeAlta);
            //System.out.println("Fecha de transferencia a otro propietario: "+camion.fechaCambioPropietario);
            System.out.println();
        }
    }
}
