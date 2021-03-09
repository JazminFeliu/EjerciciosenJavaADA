package com.company;

import java.util.List;

public class CRM {

    private List<Vendedor> vendedores;
    private List<Oportunidad>oportunidades;

    public void iniciar() {
        System.out.println("Bienvenido al CRM - Gestion de Oportunidades de Clientes Empresa!");
        System.out.println();

    }


    Vendedor gteVentas = new Vendedor("jazmin", null, true);
    Vendedor pablo = new Vendedor("Pablo", gteVentas);
    Vendedor adriana = new Vendedor("Adriana", gteVentas);

    public void cargarMenu() {


    }


    private void SetVendedorenLista(Vendedor vendedor){
        vendedores.add(vendedor);
    }


}
