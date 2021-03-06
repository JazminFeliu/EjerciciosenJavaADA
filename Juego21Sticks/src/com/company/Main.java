package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/* Juego de 21 sticks: Vos vs PC
	¿Queres jugar primero (S/N)?: S (hay que validar lo que me dice el usuario)
	sino juega primero la maquina
	Tu turno: ¿cuantos palitos queres sacar?(1 o 2): 1
	Quedan 20
	Turno pc: 2 palitos (pierde el que saca el último)
	Pierde el que se queda con un palito
	 */


        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido al Juego de 21 Sticks");
        System.out.print("Ingresá tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println(nombre + " ,querés jugar primero? (S/N): ");
        String op = sc.nextLine();

        System.out.println("Opcion elegida: " + op);

        Integer sticks = 21;
        Integer palito;

        while (sticks > 2) {
            System.out.println("Cantidad de Sticks: " + sticks);

            switch (op.toUpperCase(Locale.ROOT)) {
                case "S": {
                    System.out.println("Cuantos sticks querés sacar? (1 o 2): ");
                    palito = Integer.parseInt(sc.nextLine());

                    sticks -= palito;
                    op = "N";

                }
                break;

                case "N": {
                    if (sticks % 3 == 0) {
                        System.out.println("Me toca a mi y saco 2");
                        sticks -= 2;

                    } else {
                        System.out.println("Mi turno saco 1");
                        sticks -= 1;

                    }
                    op = "S";
                }
                break;

                default:
                    System.out.println("Ingrese una opcion correcta (S/N):");
                    op = sc.nextLine();

                    break;
            }
        }

        if (sticks == 2) {
            System.out.println("Saco 1 y Te gane!!! ");

        }else {
            System.out.println("Gane!");
        }
    }
}
