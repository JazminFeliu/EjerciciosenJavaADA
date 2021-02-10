package com.company;

public class Perro extends Mamifero implements Animal {
    @Override
    public void caminar() {
        System.out.println("Camino como un perro");
    }

    @Override
    public void dormir() {
        System.out.println("Duermo como perro");

    }
}
