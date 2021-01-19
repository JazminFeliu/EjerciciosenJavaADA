package com.company;

public class Cliente extends Cuenta{

    private CuentaCorriente CuentaCorriente;
    private CajaAhorro CajaAhorro;

    public Cliente() {
        CuentaCorriente = new CuentaCorriente();
        CajaAhorro = new CajaAhorro();
    }

    public com.company.CuentaCorriente getCuentaCorriente() {
        return CuentaCorriente;
    }

    public com.company.CajaAhorro getCajaAhorro() {
        return CajaAhorro;
    }

}
