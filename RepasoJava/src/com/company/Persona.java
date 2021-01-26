package com.company;

public class Persona {

    private String nombre;
    private Integer miNumero = 0;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    public int contar(){
        miNumero ++;
        return miNumero;
    }

    public void saltar() {
        System.out.println("Estoy saltando");
    }

    public void dormir() {
        System.out.println("Estoy durmiendo");
    }


}
