package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	/*
	Una empresa tiene empleados gerentes y otros que no son gerentes.
	De cada empleado se sabe el nombre, dni y domicilio.
	Los gerentes tienen una lista de tareas que pueden asignar a sus empleados.
	Los empleados tienen una lista de tareas a ejecutar y pueden ejecutarlas.
	Cuando un empleado ejecuta una tarea, se agrega una lista de tareas ejecutadas.
	(y se quita de la lista de tareas pendientes).
	Cuando un gerente asigna una tarea, se agrega a una lista de tareas asignadas
	(y se quita de la lista de tareas pendientes).
	Cada empleado puede calcular su salario.

	El salario de un gerente se calcula como la cantidad de tareas asignadas multiplicadas por 75.
	El salario de los demás empleados se calcula com la cantidad de tareas ejecutadas por 150.*/


        Gerente g = new Gerente("Pablo", "30121452", "Vera 520 CABA");
        Empleado emp = new Empleado("Rosa", "20524152", "Medrano 750 CABA");

        List<Tarea> tareasPendientes1 = new ArrayList<>();
        tareasPendientes1.add(new Tarea(1));
        tareasPendientes1.add(new Tarea(2));
        tareasPendientes1.add(new Tarea(3));
        tareasPendientes1.add(new Tarea(4));

        List<Empleado> empleados1 = new ArrayList<>();
        empleados1.add(new Empleado("Jaime", "2958500", "Tomas 100"));
        empleados1.add(new Empleado("Sergio", "31055445", "Vera 850"));

        g.asignar(tareasPendientes1.get(0), empleados1.get(0));
        g.asignar(tareasPendientes1.get(1), empleados1.get(1));
        g.asignar(tareasPendientes1.get(2), empleados1.get(1));
        tareasPendientes1.remove(0);
        tareasPendientes1.remove(0);
        tareasPendientes1.remove(0);

        System.out.println("El salario del gerente es: " + g.calcularSalario());
        System.out.println("Los salarios de los empleados son: ");
        for (int i = 0; i < empleados1.size(); i++) {
            System.out.println("Salario de "+empleados1.get(i).getNombre()+" : "+empleados1.get(i).calcularSalario());
        }

        List<Empleado> empleados = new ArrayList<>(Arrays.asList(
                new Empleado("john","30214521","Silver 789"),
                new Empleado("ana","28526989","Gonzalez 963"),
                new Empleado("jim","35000254","Tropper 112"),
                new Empleado("karen","2763451","Roca 7")
        ));

        for(Empleado e: empleados)
            System.out.println(e.getNombre());

        List<Tarea> tareasPendientes = new ArrayList<>(Arrays.asList(
                new Tarea(1),
                new Tarea(2),
                new Tarea(3),
                new Tarea(4)
        ));

        g.asignar(tareasPendientes.get(0), empleados.get(0));
        tareasPendientes.remove(0);

        g.asignar(tareasPendientes.get(1), empleados.get(1));
    }

}
