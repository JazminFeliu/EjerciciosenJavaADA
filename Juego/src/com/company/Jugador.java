package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jugador {

    private String nombre;
    private ColorEquipo colorEquipo;
    private Dificultad dificultad;
    private Integer posicion;
    private Integer meta;
    private List<Integer> jugadas = new ArrayList<>();
    private Random random = new Random();


    public Jugador(String nombre, ColorEquipo colorEquipo){
        this.nombre = nombre;
        this.colorEquipo = colorEquipo;
        this.posicion = setPosicionInicial(colorEquipo);
    }

    private Integer setPosicionInicial(ColorEquipo colorEquipo){
        switch (colorEquipo){
            case ROJO: case AZUL:
                this.meta = 0;
                this.posicion = 100;
                break;
            case NEGRO: case AMARILLO:
                this.meta = 100;
                this.posicion = 0;
                break;
        }return posicion;
    }

    public Boolean jugar(){
        System.out.println("Juega "+this.nombre+" [Posicion "+posicion+" ] [ Meta "+meta+" ]");
        int paso = random.nextInt(4)+1;
        System.out.println("Paso: "+paso);
        jugadas.add(paso);
        if(meta == 100){
            posicion += paso;
            return posicion >= meta;
        }else {
            posicion -= paso;
            return posicion <= meta;
        }
    }

    public Integer getDistanciaAlaMeta() {
        if(meta == 0 && posicion > 0){
            return posicion;
        }else if(meta == 100 && posicion < 100){
            return meta - posicion;
        }else {
            return 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", colorEquipo=" + colorEquipo +
                ", posicion=" + posicion +
                ", meta=" + meta +
                '}';
    }
}
