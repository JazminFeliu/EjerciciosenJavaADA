package com.company;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Contenido {
    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    List<Episodio> episodios = new ArrayList<>();

    public Episodio getEpisodio(int numero){
        return episodios.get(numero);
    }

}
