package com.company;

import java.util.Scanner;

public class Carrera {
    private String _nombreCarrera;
    private Scanner teclado;
    private Integer _cantidadMaterias;
    private Integer _promedioCarrera;
    private Integer _sumaPromedioCarrera;

    public Carrera() {
        teclado = new Scanner(System.in);

        System.out.println("Ingrese el nombre de la carrera: ");
        _nombreCarrera = teclado.nextLine();

        System.out.println("Ingrese la cantidad de materias de la carrera de " + _nombreCarrera);
        _cantidadMaterias = teclado.nextInt();

        _sumaPromedioCarrera = 0;

        for (int i = 0; i < _cantidadMaterias; i++) {
            Materia materia = new Materia();
            materia.cargarMatrizMateria();
            _sumaPromedioCarrera = materia.calcularPromedioMateria() + _sumaPromedioCarrera;
        }
    }

    public void calcularPromedioCarrera() {
        _promedioCarrera = _sumaPromedioCarrera / _cantidadMaterias;
        System.out.println("El promedio de la Carrera de " + _nombreCarrera +" es: " + _promedioCarrera);
    }
}
