package com.company;

public class ClienteIndividuo extends Cliente{

    private String nombre;
    private Integer dni;

    public ClienteIndividuo(Integer idCliente, Double saldoInicial) {
        super(idCliente, saldoInicial);
        this.nombre = getNombre();
        this.dni = getDni();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDni() {
        return dni;
    }




}

