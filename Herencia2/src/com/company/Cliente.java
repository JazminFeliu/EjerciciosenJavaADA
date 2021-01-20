package com.company;

public class Cliente {

    private CuentaCorriente CuentaCorriente;
    private CajaAhorro CajaAhorro;

    public Cliente(Double saldoInicial){
        CuentaCorriente = new CuentaCorriente(0.00);
        CajaAhorro = new CajaAhorro(saldoInicial);
    }

    public CuentaCorriente getCuentaCorriente() {
        return CuentaCorriente;
    }

    public CajaAhorro getCajaAhorro() {
        return CajaAhorro;
    }

}
