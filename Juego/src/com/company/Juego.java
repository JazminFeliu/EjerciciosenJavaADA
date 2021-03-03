package com.company;

import java.util.*;

public class Juego {

    private boolean activo;
    private Dificultad dificultad;
    private ColorEquipo colorEquipo;
    private List<Jugador> jugadores = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);


    public Juego(Dificultad dificultad) {
        this.dificultad = dificultad;
        this.activo = true;
    }

    public boolean isActivo(){
        return activo;
    }

    public void setActivo(boolean activo){
        this.activo = activo;
    }

    public void iniciar() {
        System.out.println("Bienvenido al Juego de Equipos de Colores!");
        System.out.println("Se puede jugar de a 2, 3 o 4 equipos");
        System.out.println("Ingrese la cantidad de equipos");
        int cantidadJugadores = scanner.nextInt();
        String nombre;
        ColorEquipo colorEquipo;
        scanner.nextLine();
        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.println("Ingrese el nombre del jugador: ");
            nombre = scanner.nextLine();
            colorEquipo = ColorEquipo.values()[i];
            jugadores.add(new Jugador(nombre,colorEquipo));
            System.out.println("El jugador " + nombre + " pertenece al equipo " + colorEquipo);

        }

    }

    public void mostrarResultados() {
        System.out.println("###### TABLA DE RESULTADOS #######");
        TreeMap<Integer, Jugador>tablaDePosiciones = new TreeMap<>();
        for (Jugador jugador: jugadores){
            tablaDePosiciones.put(jugador.getDistanciaAlaMeta(), jugador);
        }
        System.out.println(tablaDePosiciones);
    }

    public void jugarTurno() {
        for (Jugador jugador : jugadores)
            if (jugador.jugar()) {
                activo = false;
                System.out.println("El ganador es: " + jugador.getNombre());
            }

    }


}
