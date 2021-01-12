package com.company;
//Una universidad tiene varias carreras.
//Cada carrera universitaria tiene una cantidad de materias. Se solicita el promedio de cada materia.
//Cada profesor presentará el promedio de su cursada. La institucion calculará luego el promedio de la carrera.
//Utilizar matrices y constructores siempre que sea posible.


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        carrera.calcularPromedioCarrera();
    }
}
