package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Almacenes “El harapiento distinguido” tiene una promoción: a todos los trajes
        que tienen un precio superior a $2500.00 se les aplicará un descuento de 15 %, a todos
        los demás se les aplicará sólo 8%. Realice un algoritmo para determinar el precio final
        que debe pagar una persona por comprar un traje y de cuánto es el descuento que
        obtendrá.

        Ejercicios:
        1. Cargar 7 trajes. mostrar el inventario.
        2. Agregar 2 trajes en la 4ta y 6ta posicion.
        3. Actualizar el precio del traje 1 y 3.
        4. aplicar descuentos de 15% y 8%
         */

        List<Producto> inventario = new ArrayList<Producto>();

        //1. Cargar 7 trajes. mostrar inventario actualizado.

        inventario.add(new Producto("Armani",3000.00));
        inventario.add(new Producto("Bogani",2500.00));
        inventario.add(new Producto("HugoBoss",10000.00));
        inventario.add(new Producto("HugoBoss",3500.00));
        inventario.add(new Producto("Armani",1000.00));
        inventario.add(new Producto("Bogani",1500.00));
        inventario.add(new Producto("Prada",30000.00));

        inventario.forEach((Producto) -> {
            System.out.println(Producto);
        });

        //2. Agregar 2 trajes en la 4ta y 6ta posicion. Mostrar inventario actualizado

        Producto traje1 = new Producto("CocoChanel", 250000.00);
        Producto traje2 = new Producto("CocoChanel", 1500.00);
        inventario.add(3,traje1);
        inventario.add(5,traje2);

        System.out.println();
        System.out.println("Inventario actualizado: ");
        System.out.println();
        inventario.forEach((Producto) -> {
            System.out.println(Producto);
        });

        //3. Actualizar el precio del traje 1 y 3. Mostrar inventario actualizado

        inventario.get(0).setPrecio(100.00);
        inventario.get(2).setPrecio(100.00);

        System.out.println();
        System.out.println("Inventario actualizado: ");
        System.out.println();
        inventario.forEach((Producto) -> {
            System.out.println(Producto);
        });

        //4. aplicar descuentos de 15% (precio > 2500) y 8%(todos lo demas).Mostrar inventario actualizado

        System.out.println();
        System.out.println("Inventario actualizado: ");
        System.out.println();

        Double  descuento = 0.00;

        for (int i = 0; i < inventario.size(); i++ ){

            Producto prod = inventario.get(i);

            if (prod.getPrecio() > 2500.00){
                descuento = prod.getPrecio() * 0.15;
                prod.setPrecio(prod.getPrecio() - descuento);
                System.out.println(prod + " recibe un descuento del 15% y ahora es de $"+ prod.getPrecio());
            }else {
                descuento = prod.getPrecio() * 0.08;
                prod.setPrecio(prod.getPrecio() - descuento);
                System.out.println(prod + " recibe un descuento del 8% y ahora es de $" + prod.getPrecio());
            }
        }
    }
}
