package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	/*Crear un sistema de turno para una farmacia utilizando un mapa para asignar
	turnos a los clientes que llegan.
	Cargar 8 clientes y mostrar en la pantalla el turno que tiene cada uno.
	 */
        Persona p1 = new Persona(1, "Jaz");
        Persona p2 = new Persona(7, "Seba");
        Persona p3 = new Persona(5, "Santy");
        Persona p4 = new Persona(4, "Julia");
        Persona p5 = new Persona(6, "Ana");
        Persona p6 = new Persona(2, "Mario");
        Persona p7 = new Persona(8, "Roberto");
        Persona p8 = new Persona(3, "Smith");

        Map<Integer,Persona>mapaTurnos = new HashMap<>();

        cargarNuevoTurno(mapaTurnos,p1);
        cargarNuevoTurno(mapaTurnos, p2);
        cargarNuevoTurno(mapaTurnos, p3);
        cargarNuevoTurno(mapaTurnos, p4);
        cargarNuevoTurno(mapaTurnos, p5);
        cargarNuevoTurno(mapaTurnos, p6);
        cargarNuevoTurno(mapaTurnos, p7);
        cargarNuevoTurno(mapaTurnos, p8);

        System.out.println("Personas con turno, con foreach:");
        mapaTurnos.forEach(
                (numero,persona) -> System.out.println("Nro: "+numero+" - "+persona)
        );
        System.out.println("--------------------------------------------------------");
        System.out.println("Personas con turno, con map");
        Set<Map.Entry<Integer,Persona>> turnos = mapaTurnos.entrySet();
        for (Map.Entry<Integer,Persona> turno: turnos){
            System.out.println("Turno: "+turno.getValue());
        }
        System.out.println("--------------------------------------------------------");

        System.out.println("Personas con turno, con iterator");
        Iterator<Map.Entry<Integer,Persona>> iterador = mapaTurnos.entrySet().iterator();
        while ((iterador.hasNext())){
            Persona p = iterador.next().getValue();
            System.out.println("Turno: "+p);
        }
        System.out.println("--------------------------------------------------------");

        System.out.println("Personas con turno, ordenadas con stream");
        mapaTurnos.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------------");

        //Otra forma usando un array e Iterator
        HashMap<Integer, Cliente> otrosTurnos = new HashMap<>();

        for (int i = 0; i < 8; i++)
            cargarTurno(i, new Cliente(), otrosTurnos);
        ArrayList<String> nombres = new ArrayList<>(List.of("Pablo", "Juliana", "john", "mike", "anne", "liz", "jules", "carmen"));
        otrosTurnos.forEach((k, v) -> v.setNombre(nombres.get(k)));

        otrosTurnos.entrySet().stream().forEach(System.out::println);
    }

    private static void cargarNuevoTurno(Map<Integer, Persona> mapaTurnos, Persona p) {
        mapaTurnos.put(p.getNumero(), p);}

    private static void cargarTurno(int turno, Cliente cliente, HashMap<Integer, Cliente> turnos) {
        turnos.put(turno, cliente);
    }
}



