package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	/*
    Ejercicio empleados abstractos con menos dependencias, sobre lo que aprendo del ej. de Naty. Genial!
	 */

        Gerente gerente = new Gerente("Jimena", "31121452", "Soo 112");
        List<Empleado> empleados = new ArrayList<>(Arrays.asList(
                new Empleado("otto","23456987","www 99"),
                new Empleado("anna","32456987","rrr 98"),
                new Empleado("kim", "12545658", "qqq 111")
        ));
        gerente.setEmpleados(empleados);

        List<Tarea>tareas = new ArrayList<>(Arrays.asList(
                new Tarea(1),
                new Tarea(2),
                new Tarea(3),
                new Tarea(4),
                new Tarea(5),
                new Tarea(6),
                new Tarea(7),
                new Tarea(8),
                new Tarea(9)

        ));

        gerente.setTareasPendientes(tareas);

        while (gerente.getTareasPendientes().size() > 0){
            Double i = Math.floor(Math.random()*3);
            gerente.asignar(gerente.getProximaTareaPendiente(), gerente.getEmpleados().get(i.intValue()));
        }

        for (Empleado e: gerente.getEmpleados()){
            while (e.getTareasPendientes().size() > 0){
                e.ejecutar(e.getProximaTareaPendiente());
            }
        }

        System.out.println("Tareas asignadas del Gerente: "+gerente.getNombre());
        gerente.mostrarTareas(gerente.getTareasAsignadas());
        System.out.println(("Sueldo a cobrar: "+ gerente.calcularSalario()));
        System.out.println("Tareas pendientes: "+ gerente.getTareasPendientes().size());
        System.out.println();

        for (Empleado e: gerente.getEmpleados()){
            System.out.println("Tareas ejecutadas del empleado: "+e.getNombre());
            gerente.mostrarTareas(e.getTareasEjecutadas());
            System.out.println("Tareas pendientes: "+ e.getTareasPendientes().size());
            System.out.println("Sueldo a cobrar: "+e.calcularSalario());
        }

    }
}
