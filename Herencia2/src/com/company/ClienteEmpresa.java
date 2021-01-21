package com.company;

public class ClienteEmpresa extends Cliente{

    private String razonSocial;
    private Integer cuit;

    public ClienteEmpresa(Integer idCliente, Double saldoInicial) {
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

    @Override
    public void pedirPrestamo(Double monto) {
        System.out.println("Este clinte es Empresa, no tiene permitido pedir préstamo");
    }
}
