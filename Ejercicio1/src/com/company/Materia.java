package com.company;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Materia {
    private Scanner teclado;
    private int[][] materia;
    private int _fila;
    private int _columna;

    public Materia(){
        teclado = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de alumnos de la materia: ");
         _fila = teclado.nextInt();

        System.out.println("Ingrese la cantidad de notas por alumno: ");
        _columna = teclado.nextInt();

        materia = new int[_fila][_columna];
    }

    public void cargarMatrizMateria(){
        for(int f=0; f<_fila;f++){
            System.out.println("Notas del alumno número "+(f+1));
            for(int c=0; c<_columna; c++){
                System.out.println("Ingrese nota número "+(c+1));
                materia[f][c] = teclado.nextInt();
            }
        }
    }

    public int calcularPromedioMateria(){
        int promedio = 0;
        int suma = 0;
        for(int f=0; f<_fila;f++){
            for(int c=0; c<_columna; c++){
                suma = materia[f][c] + suma;
            }
        }
        promedio = suma/(_fila*_columna);
        System.out.println("El promedio de la Materia es: "+ promedio);
        return promedio;
    }
}


