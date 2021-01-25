package com.company;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Persona {

    private Integer salario;

    public Gerente(String nombre, String dni, String domicilio) {

        super(nombre, dni, domicilio);

    }

    List<Tarea> tareasAsignadas = new ArrayList<>();

    public void asignar(Tarea tarea, Empleado empleado) {
        empleado.ejecutar(tarea);
        tareasAsignadas.add(tarea);
    }

    @Override
    public Integer calcularSalario() {
        this.salario = tareasAsignadas.size() * 75;
        return salario;
    }
}
