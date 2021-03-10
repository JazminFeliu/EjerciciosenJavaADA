package com.company;

public class Mamifero extends Animal implements IAnimal {

    private boolean isVacunado;

    public Mamifero(String nombre, int id,  boolean isVacunado) {
        super(nombre, id);
        this.isVacunado = isVacunado;
    }

    @Override
    public String verDatos() {
        String vacunas = (isVacunado)?" (vacunado)" : "(sin vacunas)";
        return id+": " + nombre + vacunas;
    }

    public boolean isVacunado(){
        return isVacunado;
    }

    public void setVacunado(boolean isVacunado){
        this.isVacunado = isVacunado;
    }
}
