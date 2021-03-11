package com.company;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Optional<String> nombreOpcional = Optional.empty();

        Optional<Jugador> jugadorDos = Optional.empty();

        if(jugadorDos.isPresent()){
            System.out.println("Jugador dos ya llego");
        }else {
            System.out.println("Jugador dos todavia no llego");
        }

        Jugador unJugadorReal = new Jugador("12548785", "Jaz");
        jugadorDos = Optional.of(unJugadorReal);

        if(jugadorDos.isPresent()){
            System.out.println("Ahora si ya llego");
            jugadorDos.get().jugar();
        }

        Jugador jugadorTurno = jugadorDos.orElse(new Jugador("6524521", "jugador PC"));


    }
}
