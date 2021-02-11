package com.company;


public class Gato extends Mamifero implements Animal{

    public boolean hambre = false;

    @Override
    public void caminar() {
        System.out.println("Camino como un gato");


    }

    @Override
    public boolean tieneHambre() {
        System.out.println("Soy un gato y a veces tengo hambre");
        return hambre;
    }

    @Override
    public void dormir() {
        System.out.println("Duermo como gato");

    }
}
