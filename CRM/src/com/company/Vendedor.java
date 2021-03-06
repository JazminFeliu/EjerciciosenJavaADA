package com.company;

import java.util.List;

public class Vendedor {

    private Oportunidad oportunidad;
    private List<Cliente>clientes;
    private List<Oportunidad> oportunidades;
    private Estado estado;



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

}
