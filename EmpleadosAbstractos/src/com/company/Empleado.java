package com.company;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {

    private Integer salario;
    public Empleado(String nombre, String dni, String domicilio) {

        super(nombre, dni, domicilio);
    }

    List<Tarea> tareasEjecutadas = new ArrayList<>();

    public void ejecutar(Tarea tarea){
        tareasEjecutadas.add(tarea);
    };

    @Override
    public Integer calcularSalario(){
            salario = tareasEjecutadas.size() *150;
            return salario;
    }
}
