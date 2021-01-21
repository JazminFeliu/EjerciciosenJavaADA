package com.company;

public class ClientePyme extends Cliente {

    private String razonSocial;
    private Integer cuit;

    public ClientePyme(Integer idCliente, Double saldoInicial) {
        super(idCliente, saldoInicial);
        this.razonSocial = getRazonSocial();
        this.cuit = getCuit();
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public Integer getCuit() {
        return cuit;
    }
}
