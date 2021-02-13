package com.company;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	//queue es una cola, una fifo


        PriorityQueue<String> cola1 = new PriorityQueue<>();
        cola1.add("Jazmin");
        cola1.add("Agus");
        cola1.add("Pablo");
        cola1.add("Juli");
        cola1.add("Silvia");

        System.out.println("Cantidad de personas en espera: "+cola1.size());
        System.out.println("Primera persona"+cola1.peek());

        for(String persona: cola1){
            System.out.println("La siguiente persona es: "+persona);
        }

        System.out.println("Cantidad de personas en espera: "+cola1.size());
        cola1.clear();
        System.out.println("Cantidad de personas en espera: "+cola1.size());
    }
}
