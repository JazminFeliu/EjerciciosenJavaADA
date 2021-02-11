package com.company;

public class Granja {

    public static void main(String[] args) {

        Perro buggie = new Perro();
        Gato felix = new Gato();
        Caballo ed = new Caballo();


        hacerCaminar(felix);
        hacerCaminar(buggie);
        hacerCaminar(ed);

        felix.dormir();
        buggie.dormir();
    }

    private static void hacerCaminar(Animal animal) {
        animal.caminar(); //Polimorfismo googlear (es poder darle el mismo mje y q lo entienda, castear)

        if(animal.tieneHambre()){
            System.out.println("Este animal tiene hambre");
        };
        System.out.println("Cantidad de patas "+Perro.patas);

    }

}
