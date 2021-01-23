package com.company;

public abstract class Cliente {

    protected Integer idCliente;
    protected CuentaCorriente CuentaCorriente;
    protected CajaAhorro CajaAhorro;
    private Double prestamo;

    public Cliente(Integer idCliente, Double saldoInicial){
        this.idCliente = idCliente;
        CuentaCorriente = new CuentaCorriente(saldoInicial);
        CajaAhorro = new CajaAhorro(saldoInicial);
    }

    public Integer getIdCliente(){
        return idCliente;
    }
    public CuentaCorriente getCuentaCorriente() {
        return CuentaCorriente;
    }

    public CajaAhorro getCajaAhorro() {
        return CajaAhorro;
    }

    public void pedirPrestamo(Double monto){
        CajaAhorro.depositar(monto);
    }

}
