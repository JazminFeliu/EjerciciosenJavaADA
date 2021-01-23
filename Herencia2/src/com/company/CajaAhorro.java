package com.company;

public class CajaAhorro extends Cuenta{


    public CajaAhorro(Double saldoInicial) {
        super(saldoInicial);

    }

    //polimorfismo
    @Override
    public void extraer(Double monto) {
        if(monto <= saldo){
            saldo -= monto;;
        }
    }
}
