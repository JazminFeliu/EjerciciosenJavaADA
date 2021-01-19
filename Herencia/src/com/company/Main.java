package com.company;

public class Main {

    public static void main(String[] args) {

        Moto moto = new Moto(5);
        Bicicleta bici = new Bicicleta(10);

        moto.acelerar();
        moto.acelerar();
        moto.acelerar();

        bici.acelerar();
        bici.acelerar();
        bici.acelerar();
        bici.frenar();

        System.out.println("La velocidad de la moto: "+moto.getVelocidad());
        System.out.println("La velocidad de la bici: "+bici.getVelocidad());

    }
}
