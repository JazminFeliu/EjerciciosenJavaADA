package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*crear un sistema que permita llevar el registro de tareas hogareñas
        asignadas a cada habitante de la casa.

        Cada tarea debe tener un nombre, una descripcion, un responsable que vive en la casa y
        un estado que puede ser: PENDIENTE, EN_PROCESO, FINALIZADA, CANCELADA.

        Crear un menu donde se permita:
        1) Ver todas las tareas.
        2) Ver todas las tareas PENDIENTES.
        3) Ver todas las tareas de una persona en particular.
        4) ver todas las tareas PENDIENTES de una persona en particular.
        5) Agregar una nueva tarea.
        6) Cambiar el estado de una tarea.
        7) Cancelar una tarea.
        0) Salir.

        UX = User eXperience

         */

        Casa casa = new Casa();
       // casa.iniciarMenu();

        System.out.println("Las tareas de Pablo: ");
        casa.listarTareasPorResponsable("pablo");

        System.out.println("Las tareas pendientes de Pablo: ");
        casa.listarTareasPorResponsable("pablo");

        System.out.println("Vamos a cambiar el estado de una tareas");
        System.out.println("Estas son las tareas: ");
        casa.listarTareas();

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el ID de la tarea qu equeres cambiar: ");
        int idACambiar = Integer.parseInt(sc.nextLine());

        System.out.println("Ingresa el nro. de Estado que querés asignarle: ");
        System.out.println("0: PENDIENTE, 1: CANCELADA, 2:FINALIZADA, 3: EN PROCESO");
        int idEstado = Integer.parseInt(sc.nextLine());
        casa.cambiarEstadoDeTarea(idACambiar, idEstado);
        casa.listarTareas();

    }
}
