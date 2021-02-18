package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	//sistema para anotar todos los vehiculos registrados del pais.

        DNRPA registroNacional = new DNRPA();
        RegistroSeccional seccional;
        seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);
        seccional.darAltaVehiculo(new Auto(seccional.getIdRegistroSeccional(),seccional.getFechaDeAlta(), seccional.getPatente()));
        seccional.darAltaVehiculo(new Auto (seccional.getIdRegistroSeccional(),seccional.getFechaDeAlta(),seccional.getPatente()));

        seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);
        seccional.darAltaVehiculo(new Camion(seccional.getIdRegistroSeccional(),seccional.getFechaDeAlta(),seccional.getPatente()));
        seccional.darAltaVehiculo(new Moto( seccional.getIdRegistroSeccional(),seccional.getFechaDeAlta(),seccional.getPatente()));
        seccional.darAltaVehiculo(new AutoElectrico(seccional.getIdRegistroSeccional(),seccional.getFechaDeAlta(),seccional.getPatente()));

        seccional = registroNacional.crearNuevoRegistroSeccional();
        registroNacional.agregarRegistroSeccional(seccional);
        seccional.darAltaVehiculo(new Camion(seccional.getIdRegistroSeccional(),seccional.getFechaDeAlta(),seccional.getPatente()));
        seccional.darAltaVehiculo(new AutoElectrico( seccional.getIdRegistroSeccional(),seccional.getFechaDeAlta(),seccional.getPatente()));
        seccional.darAltaVehiculo(new Utilitario( seccional.getIdRegistroSeccional(),seccional.getFechaDeAlta(),seccional.getPatente()));

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
            //System.out.println("Propietario: "+auto.propietario.getNombre());
            //System.out.println("Autorizados a manejar el vehiculo: "+ auto.autorizados );
            //System.out.println("Fecha de transferencia a otro propietario: "+auto.fechaCambioPropietario);
            System.out.println();
        }

        //Listar todos los propietarios de camiones en orden alfabetico.

        System.out.println("Listado de propietarios de camiones de todos los Registros Seccionales:");
        System.out.println("Cantidad de camiones: "+todosLosCamiones.size());
        System.out.println();
        for (Vehiculo camion: todosLosCamiones){
            System.out.println();
            //System.out.println("Propietario: "+camion.propietario.getNombre());
            System.out.println("Patente: "+camion.patente);
            System.out.println("Registro Seccional Nro.: "+camion.getIdRegistroSeccional());
            //System.out.println("Autorizados a manejar el camion: "+camion.autorizados);
            System.out.println("Tipo de camion: "+camion.getClass().getSimpleName());
            //System.out.println("Uso: "+camion.uso);
            System.out.println("Fecha de alta en el Registro: "+camion.fechaDeAlta);
            //System.out.println("Fecha de transferencia a otro propietario: "+camion.fechaCambioPropietario);
            System.out.println();
        }
    }
}
