package com.company;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    List<Contenido> catalogo = new ArrayList<>();
    List<Contenido> favoritos = new ArrayList<>();
    List<Contenido> recomendaciones = new ArrayList<>();
    List<Medio> continuarViendo = new ArrayList<>();


    public Usuario(List<Contenido> catalogo) {
        this.catalogo = catalogo;

        Contenido contenido = catalogo.get(0);
        Medio medio;

        if(contenido.isPelicula()){
            medio = (Medio) contenido; //casteo, ojo al usar

        }else{
            Serie s = (Serie) contenido;
            medio = (Medio) s.getEpisodio(0);
        }
        medio.reproducir();

    }
}
