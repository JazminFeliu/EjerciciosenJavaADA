package com.company;

public class Main {
/*
El sistema de viajes Aterrizar.com tiene transportes y hospedajes que ofrece a sus usuarios.
Hay aviones, trenes y colectivos como transportes que ofrecen venta de pasajes.
Los autos pueden alquilarse o reservarse.
También tienen hoteles, casas y departamentos como hospedaje.
Y excursiones que se pueden reservar.
Los aviones, hoteles y colectivos lowcost se los puede regatear y baja un 20% el precio.
 */

    /*

    clases abstractas:
    Transporte --> metodos abstractos ( reservar, alquilar).
    Hospedaje -->  metodos abstractos (reservar, alquilar)

    clases:
    Clase Avion, Tren, Colectivo, Auto extends Transporte
    Clase Hotel, Casa, Departamento extends Hospedaje



Clase Abstracta Paquete
    metodos elegirTransporte, elegirHospedaje, regatear, reservarExcursion
Interface Reservable
    metodos reservar, alquilar, vender

    Clase Usuario extends Paquete implements Reservable

     */
    public static void main(String[] args) {


    }
}
