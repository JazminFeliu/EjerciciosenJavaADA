package com.company;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        /*Ejercicio con figuras: crear un sistema que permita calcular el perimetro y area de una figura.
        Las figuras pueden ser cuadrados, triangulos o circulos.
        Todas las figuras tienen un color asignado, que puede consultarse.
        Nota: el valor de Pi pueden tomarlo como 3.14 o pueden usar la constante Math.PI
         */

        Cuadrado cua = new Cuadrado(10.00,"verde");
        System.out.println("El perimetro del cuadrado es: "+cua.getPerimetro());
        System.out.println("El area del cuadrado es: "+cua.getArea());

        //introduccion a reflections
        Object o = new Object();
        Persona p = new Persona("Ana");
        p.saltar();
        System.out.println("Contando "+p.contar());
        p.dormir();
        System.out.println("Contando "+p.contar());

        Class clase = p.getClass();
        for(Method metodo : clase.getMethods()){
            metodo.getName();
            System.out.println("Metodo: "+metodo.getName());
        }
        o = p;
        metodoMisterioso(o);
    }

    private static void metodoMisterioso(Object objeto){
        System.out.println("Que sos? "+objeto.getClass().getSimpleName());
    }
}
