package com.company;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
	       /* En una farmacia se tienen Clientes que ingresan a una cola para ser atendidos.
        La farmacia atiende con menor prioridad a los particulares.
        Clientes pueden ser jubilados, embarazadas, particulares o afiliados.
         */


       Queue<Cliente> cola = new PriorityQueue<>();

       cola.add(new Cliente("juan","jubilado"));
       cola.add(new Cliente("jose", "particular"));

       for (Cliente c :cola){
           System.out.println("Cantidad de clientes por atender: "+cola.size());
           System.out.println(cola);
       }


    }
}
