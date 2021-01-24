package com.company;
import java.util.List;

public class Mamifero extends Animal{

    private Boolean vacunado;

    public Mamifero(String nombre, Integer numeroId, List<Integer> horarioDeComidas, Boolean vacunado) {
        super(nombre, numeroId, horarioDeComidas);
        this.vacunado = vacunado;
    }

    public void vacunar(List<Mamifero> mamiferos, int i){
        if (mamiferos.get(i).vacunado == false){
            this.vacunado = true;
        }
    }

    @Override
    public String toString() {
        return "Mamifero{" +
                "nombre='" + nombre + '\'' +
                ", numeroCollar=" + numeroCollar +
                ", horarioDeComidas='" + horario + '\'' +
                ", vacunado=" + vacunado +
                '}';
    }
}
