package com.company;

import java.util.ArrayList;
import java.util.List;

public class Refugio {

    private List<Mamifero> mamiferos;
    private List<Reptil> reptiles;

    public Refugio(){
        mamiferos = new ArrayList<>();
        reptiles = new ArrayList<>();
    }

    public List<Mamifero> getMamiferos() {
        return mamiferos;
    }

    public List<Reptil> getReptiles() {
        return reptiles;
    }

}
