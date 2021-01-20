package com.company;

public class CuentaCorriente extends Cuenta{

    // tiene un descubierto que es igual para todos los clientes
    // y HOY vale $ 5000.00

    private static final Double descubierto = 5000.00;

    public CuentaCorriente(Double saldoInicial) {
        super(saldoInicial);
    }

    public static Double getDescubierto() {
        return descubierto;
    }

    //SOBREESCRIBIR el método extraer() para que cuando trabaje con la CuentaCorriente use el descubierto
    @Override
    public void extraer(Double monto) {
        if(monto >= (saldo+descubierto)){
            return;}

            super.extraer(monto);
    }
}