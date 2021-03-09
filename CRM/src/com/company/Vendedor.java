package com.company;

import java.util.List;

public class Vendedor {

    private Oportunidad oportunidad;
    private String nombre;
    private List<Cliente>clientes;
    private List<Oportunidad> oportunidades;
    private Vendedor gerente; //
    private Estado estado;
    private Boolean manager;

    public Vendedor(String nombre, Vendedor gerente, boolean esManager){
        this.nombre = nombre;
        this.gerente = gerente;
        this.manager = esManager;
    }

    public Vendedor(String nombre, Vendedor gerente){
        this.nombre = nombre;
        this.gerente = gerente;
        this.manager = false;
    }





    public List<Oportunidad> getOportunidades(){
        return oportunidades;
    }

    private void llamarAlCliente(){

    }

    private void cambiarEstadoOportunidad(){

    }

    private void setOportunidadALista(Oportunidad oportunidad){
        oportunidades.add(oportunidad);
    }

    private void registrarFechaContactoInicial(){

    }
    private void registrarMontoDeReferencia(){

    }

    public void registrarOportunidad() {
    }

}
