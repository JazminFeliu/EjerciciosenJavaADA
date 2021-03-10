package com.company;

public class Main {

    public static void main(String[] args) {

        Refugio refugio = new Refugio();

        // TODO prueba:
        refugio.agregarMuchosAnimales();

        refugio.listarAnimales();

        IAnimal unAnimal = refugio.getAnimalPorNombre("felix");

        System.out.println("Felix es un "+unAnimal.getClass().getSimpleName());



       // if(unAnimal.getClass().getSimpleName().equals("Mamifero")) dos formas de preguntar lo mismo

            if(unAnimal instanceof Mamifero){
            System.out.println(unAnimal.getNombre()+" es un mamifero");
            Mamifero m = (Mamifero) unAnimal;
            String vacunas = (m.isVacunado())?"Esta vacunado!":"no esta vacunado";
                System.out.println(vacunas);
        } else {
            System.out.println(unAnimal.getNombre()+" es un reptil");
            Reptil r = (Reptil) unAnimal;
            System.out.println("Y su edad es: "+r.getEdadEstimada());
        }
    }
}
