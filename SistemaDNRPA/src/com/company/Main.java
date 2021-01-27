package com.company;

import java.util.*;

import static java.util.Collections.*;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona(1, "maria", "2585470", "xxx 145");
        Persona p2 = new Persona(1, "martin", "30145258", "www 897");
        Persona p3 = new Persona(2, "sabrina", "35241541", "xxx 784");
        Persona p4 = new Persona(2, "roberto", "22587412", "yyy 935");
        Persona p5 = new Persona(2, "tamara", "36452145", "ppp 19");
        Persona p6 = new Persona(3, "sergio", "24587452", "lll 712");
        Persona p7 = new Persona(3, "no tiene", "", "");
        Persona p8 = new Persona(1, "rosa", "5274152", "tyg 145");
        Persona p9 = new Persona(1, "claudio", "30145258", "pol 897");
        Persona p10 = new Persona(2, "brina", "35241541", "tyg 254");
        Persona p11 = new Persona(2, "mario", "22587412", "edr 145");
        Persona p12 = new Persona(2, "carla", "36452145", "wsx 781");
        Persona p13 = new Persona(3, "angela", "24587452", "tyg 124");

        List<Persona> autorizadosP1 = new ArrayList<>();
        autorizadosP1.add(p2);

        List<Persona> autorizadosP3 = new ArrayList<>();
        autorizadosP3.add(p4);
        autorizadosP3.add(p5);

        List<Persona> autorizadosP6 = new ArrayList<>();
        autorizadosP6.add(p7);

        List<Persona> autorizadosP8 = new ArrayList<>();
        autorizadosP8.add(p9);

        List<Persona> autorizadosP10 = new ArrayList<>();
        autorizadosP10.add(p11);
        autorizadosP10.add(p12);

        List<Persona> autorizadosP13 = new ArrayList<>();
        autorizadosP13.add(p7);

        Vehiculo v1 = new Vehiculo(1, "particular", "auto", "combustion", p1, autorizadosP1);
        Vehiculo v2 = new Vehiculo(2, "profesional", "auto", "electrico", p3, autorizadosP3);
        Vehiculo v3 = new Vehiculo(3, "profesional", "camion", "combustion", p6, autorizadosP6);
        Vehiculo v4 = new Vehiculo(1, "particular", "camion", "combustion", p8, autorizadosP8);
        Vehiculo v5 = new Vehiculo(2, "profesional", "auto", "electrico", p10, autorizadosP10);
        Vehiculo v6 = new Vehiculo(3, "profesional", "camion", "combustion", p13, autorizadosP13);

        List<Vehiculo> autos = new ArrayList<>();
        List<Vehiculo> camiones = new ArrayList<>();

        List<Vehiculo> vehiculosR1 = new ArrayList<>();
        vehiculosR1.add(v1);
        vehiculosR1.add(v4);

        vehiculosR1.forEach(vehiculo -> {
            if (vehiculo.getTipoDeVehiculo() == "auto") {
                autos.add(vehiculo);
            } else if (vehiculo.getTipoDeVehiculo() == "camion") {
                camiones.add(vehiculo);
            }
        });

        List<Vehiculo> vehiculosR2 = new ArrayList<>();
        vehiculosR2.add(v2);
        vehiculosR2.add(v5);

        vehiculosR2.forEach(vehiculo -> {
            if (vehiculo.getTipoDeVehiculo() == "auto") {
                autos.add(vehiculo);
            } else if (vehiculo.getTipoDeVehiculo() == "camion") {
                camiones.add(vehiculo);
            }
        });

        List<Vehiculo> vehiculosR3 = new ArrayList<>();
        vehiculosR3.add(v3);
        vehiculosR3.add(v6);

        vehiculosR3.forEach(vehiculo -> {
            if (vehiculo.getTipoDeVehiculo() == "auto") {
                autos.add(vehiculo);
            } else if (vehiculo.getTipoDeVehiculo() == "camion") {
                camiones.add(vehiculo);
            }
        });

        //Listar todos los autos de todos los registros seccionales

        System.out.println("-------Bienvenido al SISTEMA DNRPA--------");
        System.out.println();
        System.out.println("Lista de autos en cada Registro Seccional");

        Iterator ite = autos.iterator();
        while (ite.hasNext()) {
            Vehiculo auto = (Vehiculo) ite.next();
            System.out.println("Registro Nro.: " + auto.getIdRegistro());
            System.out.println((auto.getUso()));
            System.out.println(auto.getTipoDeVehiculo());
            System.out.println(auto.getTipoDeMotor());
            System.out.println("Propietario: " + auto.getPropietario().getNombre());
            System.out.println("Autorizados:");
            auto.getAutorizados().forEach(persona -> System.out.println(persona.getNombre()));
            System.out.println();
        }

        //listar todos los propietarios(en orden alfabetico) de camiones.

        Collections.sort(camiones, new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo o1, Vehiculo o2) {
                return o1.getPropietario().getNombre().compareTo(o2.getPropietario().getNombre());
            }
        });

        System.out.println("Lista de propietarios de camiones por orden alfabetico");

        Iterator ite2 = camiones.iterator();
        while (ite2.hasNext()){
            Vehiculo camion = (Vehiculo) ite2.next();
            System.out.println("Propietario: "+camion.getPropietario().getNombre());
            System.out.println("Regisro Nro.: "+camion.getIdRegistro());
            System.out.println(camion.getTipoDeVehiculo());
            System.out.println(camion.getTipoDeMotor());
            System.out.println(camion.getUso());
            System.out.println("Autorizados");
            camion.getAutorizados().forEach(persona -> System.out.println(persona.getNombre()));
            System.out.println();
        }
    }
}
