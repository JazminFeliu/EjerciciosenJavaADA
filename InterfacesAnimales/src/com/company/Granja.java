package com.company;

public class Granja {

    public static void main(String[] args) {

        Perro buggie = new Perro();
        Gato felix = new Gato();
        Caballo ed = new Caballo();


        hacerCaminar(felix);
        hacerCaminar(buggie);
        //hacerCaminar(ed);

        felix.dormir();
        buggie.dormir();
    }

    private static void hacerCaminar(Mamifero mamifero) {
        mamifero.dormir(); //Polimorfismo googlear (es poder darle el mismo mje y q lo entienda, castear)
        mamifero.caminar();
        System.out.println("Cantidad de patas "+Perro.patas);
    }

}
