package com.company;

public class Cuenta {

    protected Double saldo; // protected significa que lo puede acceder el objeto y las subclases (Cuenta y CajaAhorro y CuentaCorriente)
    private String moneda;

    public Cuenta(Double saldoInicial) {
        this.saldo = saldoInicial;
        moneda = "AR$";
    }

    public void depositar(Double monto){

        saldo += monto;
    }

    public void extraer(Double monto){

        saldo -= monto;

    }
    public Double getSaldo(){

        return saldo;
    }
}
