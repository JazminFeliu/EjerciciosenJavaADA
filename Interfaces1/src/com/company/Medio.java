package com.company;

public interface Medio {

    default void subirVolumen() {

    }

    default void bajarVolumen() {

    }

    default void pausar() {

    }

    void reproducir();

    default void detener() {

    }

}
