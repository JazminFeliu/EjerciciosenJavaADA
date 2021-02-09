package com.company;
import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {

    private List<Tarea> tareasEjecutadas;

    public Empleado(String nombre, String dni, String domicilio) {
        super(nombre, dni, domicilio);
        tareasEjecutadas = new ArrayList<>();
    }

    public List<Tarea> getTareasEjecutadas(){
        return  tareasEjecutadas;
    }

    private void agregarTareasEjecutadas(Tarea tarea){
        tareasEjecutadas.add(tarea);
    }

    @Override
    public Integer calcularSalario(){
        return tareasEjecutadas.size()*150;
    }

    public void ejecutar(Tarea tarea){
        agregarTareasEjecutadas(tarea);
        super.eliminarTareaPendiente(tarea);
    };


}
