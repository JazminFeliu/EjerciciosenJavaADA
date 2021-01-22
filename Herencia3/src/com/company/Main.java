package com.company;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	/* en un refugio cuidan de perros, gatos y otros animales.
        A todos los animales que llegan se les asigna una etiqueta /collar
        con nombre, numero y un listado de los horarios en los que se le da comida.
        En el caso de perros y gatos, se anota si estan o no vacunados.
        En el caso de tortugas se anota la edad estimada.
	 */
       Refugio refugio = new Refugio();

       List<Mamifero> mamiferos = refugio.getMamiferos();

       mamiferos.add(new Mamifero(
               "Perro Jhon",1,"10hs, 15 hs, 20 hs",true));
       mamiferos.add(new Mamifero(
               "Gato Gardfield",2,"11 hs, 16 hs, 21 hs", false));
       mamiferos.add(new Mamifero(
               "Cabra Dolly", 3,"11hs, 21 hs"));
       mamiferos.add(new Mamifero(
               "Perro Firulays",4, "10hs, 15 hs, 20 hs", false));
       mamiferos.add(new Mamifero(
               "Hurón Young",5, "11hs, 21 hs"));
       mamiferos.add(new Mamifero(
               "Gato Felix", 6, "1130 hs, 1600 hs, 2130 hs", true));


        System.out.println("El listado de Mamiferos es: ");
        mamiferos.forEach((mamifero) ->{
            System.out.println(mamifero);
        });

       List<Reptil> reptiles = refugio.getReptiles();
       reptiles.add(new Reptil(
               "Tortuga Manuelita",1,"1200 hs, 22 hs", 20));
       reptiles.add(new Reptil(
               "Lagarto Juancho",2,"1300 hs, 20 hs"));
       reptiles.add(new Reptil(
               "Tortuga Pepa",3,"1200 hs, 22 hs",40));
       reptiles.add(new Reptil(
               "Serpiente Rob",4,"1400 hs, 21 hs"));
       reptiles.add(new Reptil(
               "Tortuga Oslo",5,"1200 hs, 22 hs", 124));
       reptiles.add(new Reptil(
               "lagardo Overo",6,"1000 hs, 20 hs"));

        System.out.println("El listado de Reptiles es: ");
        reptiles.forEach(reptil -> {
            System.out.println(reptil);
                });
    }
}
