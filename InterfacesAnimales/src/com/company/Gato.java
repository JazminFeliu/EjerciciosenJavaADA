package com.company;

public class Gato extends Mamifero implements Animal{
    @Override
    public void caminar() {
        System.out.println("Camino como un gato");


    }

    @Override
    public void dormir() {
        System.out.println("Duermo como gato");

    }
}
