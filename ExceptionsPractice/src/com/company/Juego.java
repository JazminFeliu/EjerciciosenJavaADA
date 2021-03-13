package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Juego {

    private List<Jugador> jugadores = new LinkedList<>();
    private Scanner sc = new Scanner(System.in);
    private Integer op;
    private String nombre;
    private String elDni;

    public Juego(){

    }

    public void iniciarJuego() {
        do{
            System.out.print("Desea crear un nuevo juegador? ( 1=SI, 0=NO ):");
            op = Integer.parseInt(sc.nextLine());
            crearJugador();
        }while (op !=0);

    }

    private void crearJugador() {
        System.out.println();
        System.out.print("Ingrese el dni: ");
        elDni = sc.nextLine();
        int dni;
        try {
            dni = Integer.parseInt(elDni);
        }catch (NumberFormatException e){
            dni = 0;
        }
        System.out.println();
        System.out.println("Ingrese nombre: ");
        nombre = sc.nextLine();
        try {
            agregarJugador(new Jugador(nombre, dni));
        }catch (validacionDNIException e){
            System.out.println("No se pudo crear el jugador. Intente nuevamente.");
        }

    }

    public List<Jugador> getJugadores(){
        return jugadores;
    }

    public void agregarJugador(Jugador jugador){
        jugadores.add(jugador);
    }
}
