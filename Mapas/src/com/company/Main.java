package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona(12345678, "Pablo", "xxx 123", 35);
        Persona p2 = new Persona(22457832, "Ana", "xyt 765", 41);
        Persona p3 = new Persona(42587452, "Pedro", "yug 147", 10);
        Persona p4 = new Persona(36528965, "Julia", "ere 232", 80);

        Map<Integer, Persona> mapaPersonas = new HashMap<>();

        agregarPersonaAlMapa(mapaPersonas, p1);
        agregarPersonaAlMapa(mapaPersonas, p2);
        agregarPersonaAlMapa(mapaPersonas, p3);
        agregarPersonaAlMapa(mapaPersonas, p4);

        Persona nuevaP = mapaPersonas.get(12345678);
        System.out.println("Nueva persona: "+nuevaP);
        System.out.println("---------");

        mapaPersonas.put(12345678, new Persona(156,"otro nombre", "", 89));
        System.out.println("Nueva persona actualizada: "+nuevaP);
        System.out.println("------");

        mapaPersonas.forEach(
                (dni, persona) -> System.out.println("DNI: "+dni+" - "+ persona)
        );

        System.out.println("-------");
        Set<Map.Entry<Integer,Persona>> entradas = mapaPersonas.entrySet();
        for (Map.Entry<Integer,Persona> entrada : entradas){
            System.out.println("Entrada: "+entrada.getValue());
        }
        System.out.println("------------");
        Iterator<Map.Entry<Integer,Persona>> iterador = mapaPersonas.entrySet().iterator();
        while ((iterador.hasNext())){
            Persona p = iterador.next().getValue();
            System.out.println("Persona: "+p);
        }

    }

    private static void agregarPersonaAlMapa(Map<Integer, Persona> mapaPersonas, Persona p) {
        mapaPersonas.put(p.getDni(),p);
    }
}
