package com.company;

public interface Animal {

    Integer patas = 4; //cualquier atributo de una interface es public final static

    void caminar();

    private void hacerAlgo(){  //a partir de java8 se pueden crear metodos privados en las interfaces
        System.out.println("Estoy haciendo algo");
    }
    default boolean tieneHambre(){ // a partir de java8 se puede generar comportamiento en los metodos de las interfaces
        System.out.println("Todos los animales tienen hambre");
        return true;
    }



}
