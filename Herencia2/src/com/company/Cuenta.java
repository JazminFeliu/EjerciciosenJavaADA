package com.company;

public class Cuenta {

    private Double saldo;
    private String moneda;

    public Cuenta() {
        saldo = 0.00;
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
