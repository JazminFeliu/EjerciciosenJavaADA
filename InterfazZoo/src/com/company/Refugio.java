package com.company;

import java.util.LinkedList;
import java.util.List;

public class Refugio {

    private List<IAnimal> animales = new LinkedList<>();

    public Refugio(){

    }

    public Refugio(List<IAnimal> animales){
        this.animales = animales;
    }

    //TODO borrar: método de prueba
    public void agregarMuchosAnimales(){
        agregarAnimal(new Mamifero("lolo", 1, true));
        agregarAnimal(new Reptil("manuelita", 2, 102));
        agregarAnimal(new Mamifero("felix", 3, false));
        agregarAnimal(new Reptil("juancho", 4, 96));
        agregarAnimal(new Reptil("margarito", 5, 36));

    }

    public IAnimal getAnimalPorNombre(String nombre){
        for (IAnimal animal : animales){
           if(animal.getNombre().equals(nombre)){
               return animal;
           }
        }
        return null;
    }

    public void agregarAnimal(IAnimal animal){
        animales.add(animal);
    }

    public void listarAnimales(){
        for(IAnimal animal: animales)
            System.out.println(animal.verDatos());
    }




}
