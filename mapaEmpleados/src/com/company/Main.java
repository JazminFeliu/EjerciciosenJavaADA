package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	/*
	crear un mapa que permita la rápida búsqueda empleados en una empresa por número de empleado.
	De cada empleado se sabe el nombre, nro de empleado, dni, edad, direccion y puesto.
	Cargar 10 empleados (en cualquier orden) mostrar la LISTA de empleados de forma ordenada.
	mapa.entrySet().stream() .sorted(Map.Entry.comparingByKey()) .forEach(System.out::println);
	 */

        Empleado e = new Empleado("Jimena", 62);
        HashMap<Integer,Empleado> mapaEmpleados = new HashMap<>();

        Empleado a = new Empleado("Jacinta", 28);
        Empleado b = new Empleado("Dionisia", 87);
        Empleado c = new Empleado("Jorge", 2);

        mapaEmpleados.put(a.getNroEmpleado(), a);
        mapaEmpleados.put(b.getNroEmpleado(), b);
        mapaEmpleados.put(e.getNroEmpleado(), e);
        mapaEmpleados.put(c.getNroEmpleado(), c);

        mapaEmpleados.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        }
}
