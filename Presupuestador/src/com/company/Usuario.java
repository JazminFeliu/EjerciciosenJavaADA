package com.company;

public class Usuario{

    private String nombre;
    private Presupuesto presupuesto;


    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public void armarPresupuesto(Usuario usuario) {

        presupuesto = new Presupuesto(usuario);
        presupuesto.armarPresupuesto();

    }

    public Presupuesto getPresupuesto(){
        return presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

}
