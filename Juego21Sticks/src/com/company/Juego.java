package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Juego {
    Scanner sc = new Scanner(System.in);

    public void iniciarJuego() {

        System.out.println("Bienvenido al Juego de 21 Sticks");

        System.out.println(Dificultad.DIFICIL.toString()+" : "+Dificultad.DIFICIL.getNivel());
        System.out.println(Dificultad.MEDIO.toString()+" : "+Dificultad.MEDIO.getNivel());
        System.out.println(Dificultad.FACIL.toString()+" : "+Dificultad.FACIL.getNivel());
        System.out.println("¿Con cual nivel de dificultad queres jugar?");
        Integer dificultad = Integer.parseInt(sc.nextLine());

        System.out.print("Ingresá tu nombre: ");
        String nombre = sc.nextLine();

        System.out.println(nombre + " ,querés jugar primero? (S/N): ");
        String op = sc.nextLine();

        System.out.println("Opcion elegida: " + op);
        do {
            switch (dificultad){
                case 8:
                    jugarDificil(nombre, op);
                    break;
                case 5:
                    jugarMedio(nombre, op);
                    break;
                case 3:
                    jugarFacil(nombre, op);
                    break;
                default:
                    System.out.println("Ingrese una opción correcta (8/5/3), 0 si quiere salir");
                    dificultad = Integer.parseInt(sc.nextLine());
            }
        }while (dificultad == 0);



    }

    private void jugarFacil(String nombre, String op) {
    }

    private void jugarMedio(String nombre, String op) {
    }

    private void jugarDificil(String nombre, String op) {
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
