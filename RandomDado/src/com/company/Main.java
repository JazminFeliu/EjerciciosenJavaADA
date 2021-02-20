package com.company;

import java.util.*;
import java.util.stream.IntStream;

/* hacer un sistema que simule el lanzamiento de un dado.
Se debe mostrar por pantalla el valor de la cara que queda en la parte superior.
 */
public class Main {

    public static void main(String[] args) {
        Random aleatorio = new Random();
        int dado = aleatorio.nextInt(6)+1;
        System.out.println("Valor dado: "+dado);

        /*
        Crear un sistema que genere numeros aleatorios de 3 cifras y guardarlos en un conjunto,
        sin repeticiones. Preguntar al usuario la cantidad de numeros que desea guardar,
        generarlos y luego mostrarlos en pantalla.
         */

        Scanner sc = new Scanner(System.in);
        int cantidad;
        do{
            System.out.println("Cantidad de numeros de 3 cifras: ");
            cantidad = sc.nextInt();
            System.out.println("");
        }while (cantidad < 0 || cantidad > 999);

        IntStream numeros = aleatorio.ints(100,1000);
        Set<Integer> unSetDeNumerosEnteros = new HashSet<>();

        //Iteradores muy bueno!
        //eager -> ansioso
        //lazy -> perezoso

        Iterator iteradorNumeros = numeros.filter(n ->n>500).distinct().iterator();

        while (iteradorNumeros.hasNext() && unSetDeNumerosEnteros.size() < cantidad)
            unSetDeNumerosEnteros.add((Integer)iteradorNumeros.next());

        unSetDeNumerosEnteros.forEach(n -> System.out.println("Numero: "+n));
    }
}
