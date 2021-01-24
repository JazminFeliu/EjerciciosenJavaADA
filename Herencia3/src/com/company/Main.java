package com.company;
import java.util.ArrayList;
import java.util.Arrays;
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
       List<Integer>horasDeComidas = new ArrayList<>();
       List<Mamifero> mamiferos = refugio.getMamiferos();
       horasDeComidas.add(10);
       horasDeComidas.add(15);
       horasDeComidas.add(20);
       mamiferos.add(new Mamifero("Perro Jhon",1,horasDeComidas,false));

       List<Integer>horasDeComidas5 = new ArrayList<>();
       horasDeComidas5.add(10);
       horasDeComidas5.add(15);
       horasDeComidas5.add(22);
       mamiferos.add(new Mamifero("Gato Gardfield", 2,horasDeComidas5, false));

       List<Integer>horasDeComidas1 = new ArrayList<>();
       horasDeComidas1.add(11);
       horasDeComidas1.add(16);
       horasDeComidas1.add(21);
       mamiferos.add(new Mamifero("Cabra Dolly", 3,horasDeComidas1, true));

       List<Integer>horasDeComidas2 = new ArrayList<>();
       horasDeComidas2.add(10);
       horasDeComidas2.add(15);
       horasDeComidas2.add(20);
       mamiferos.add(new Mamifero("Perro Firulays",4, horasDeComidas2, false));

       List<Integer>horasDeComidas3 = new ArrayList<>();
       horasDeComidas3.add(11);
       horasDeComidas3.add(16);
       horasDeComidas3.add(21);
       mamiferos.add(new Mamifero("Hurón Young",5, horasDeComidas3, true));

       List<Integer>horasDeComidas4 = new ArrayList<>();
       horasDeComidas4.add(1130);
       horasDeComidas4.add(1630);
       horasDeComidas4.add(2130);
       mamiferos.add(new Mamifero("Gato Felix", 6, horasDeComidas4, true));

        System.out.println("El listado de Mamiferos es: ");
        mamiferos.forEach((m) ->{
            System.out.println(m);
        });

        System.out.println("Procedemos a vacunar Perros y Gatos que no lo esten");
        for (int i = 0; i < mamiferos.size(); i++){
            mamiferos.get(i).vacunar(mamiferos, i);
        }

        System.out.println("El listado de Mamiferos luego de la vacunacion es: ");
        mamiferos.forEach((m) ->{
            System.out.println(m);
        });

       List<Reptil> reptiles = refugio.getReptiles();
       List<Integer> horas1 = new ArrayList<>();
       horas1.add(1130);
       horas1.add(1630);
       horas1.add(2130);
       reptiles.add(new Reptil("Tortuga Manuelita",1,horas1, 20));

       List<Integer> horas2 = new ArrayList<>();
       horas2.add(11);
       horas2.add(16);
       horas2.add(21);
       reptiles.add(new Reptil("Lagarto Juancho",2,horas2, null));

       List<Integer> horas3 = new ArrayList<>();
       horas3.add(10);
       horas3.add(15);
       horas3.add(20);
       reptiles.add(new Reptil("Tortuga Pepa",3,horas3,40));

       System.out.println("El listado de Reptiles es: ");
        reptiles.forEach(reptil -> {
            System.out.println(reptil);
                });
    }
}
