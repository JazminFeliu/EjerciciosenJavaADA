package com.company;
/*
     VOID
     getters y setters
     métodos y atributos de clase
     herencia
     cohesion y acoplamiento
     arrays
     listas
     colecciones
     ordenamiento
  */

public class Main {

    public static void main(String[] args) {

        /*Crear un sistema que calcule el promedio de las tres notas de un alumno que
        pertenece a un curso de programación.
        Calcular promedio aun si no tiene las tres notas.
         */
        Alumno alumno = new Alumno();

        //opcion1 Paso las notas de a una:
        alumno.guardarNota(3.00, 0);
        alumno.guardarNota(6.00, 1);
        alumno.guardarNota(8.00, 2);

        //opcion2 creo un array y se lo paso al setter de notas
        Double[] notas = new Double[3];
        notas[0] = 3.00;
        notas[1] = 6.00;
        notas[2] = 8.00;
        alumno.setNotas(notas);

        //opcion3 creo un array de notas y se lo paso al setter de notas
        Double[] notas2 = {3.00, 6.00, 8.00};
        alumno.setNotas(notas2);

        Double promedio = alumno.getPromedio();
        System.out.println("El promedio es: " + promedio);
    }
}
