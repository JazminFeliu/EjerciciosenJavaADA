package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
/*
El sistema de viajes Aterrizar.com tiene transportes y hospedajes que ofrece a sus usuarios.
Hay aviones, trenes y colectivos como transportes que ofrecen venta de pasajes.
Los autos pueden alquilarse o reservarse.
También tienen hoteles, casas y departamentos como hospedaje.
Y excursiones que se pueden reservar.
Los aviones, hoteles y colectivos lowcost se los puede regatear y baja un 20% el precio.
 */



    public static void main(String[] args) {

        List<Transporte> transportes = new LinkedList<>();
        List<Hospedaje> hospedajes = new LinkedList<>();
        List<Excursion> excursiones = new ArrayList<>();

        transportes.add(new Avion("avion"));
        transportes.add(new TransportePrivado("auto"));
        transportes.add(new Avion("avion2"));
        transportes.add(new Colectivo("colectivo"));
        transportes.add(new Tren("tren"));

        hospedajes.add(new Casa());
        hospedajes.add(new Hotel());
        hospedajes.add(new Departamento());

        TransportePrivado auto = new TransportePrivado("mi auto");
        Hotel hotel = new Hotel();
        Avion avion = new Avion("comercial");

        auto.reservar();
        System.out.println("Precio del auto: ");
        auto.informarPrecio();
        System.out.println("Precio del hotel: ");
        hotel.informarPrecio();
        hotel.reservar();
        hotel.bajarPrecio();
        avion.bajarPrecio();
        Usuario usuario = new Usuario();
        usuario.regatear(hotel);

    }
}
