package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class Usuario{

    private String nombre;
    private Presupuesto presupuesto;



    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void armarPresupuesto(Usuario usuario) {
        presupuesto = new Presupuesto(usuario);
        presupuesto.armarPresupuesto(usuario, presupuesto);
    }

    public Presupuesto getPresupuesto(){
        return presupuesto.getPresupuesto();
    }

    public String getNombre() {
        return nombre;
    }


}
