package com.company;

import java.util.List;

public class Mamifero extends Animal{

    public Mamifero(String nombre, Integer numeroId, String horarioDeComidas) {
        super(nombre, numeroId, horarioDeComidas);
    }
    public Mamifero(String nombre, Integer numeroId, String horarioDeComidas, Boolean vacunado) {
        super(nombre, numeroId, horarioDeComidas, vacunado);
    }

    @Override
    public String toString() {
        return "Mamifero{" +
                "nombre='" + nombre + '\'' +
                ", numeroCollar=" + numeroCollar +
                ", horarioDeComidas='" + horarioDeComidas + '\'' +
                ", vacunado=" + vacunado +
                '}';
    }
}
