package com.company;

import java.sql.ClientInfoStatus;

/* Modelar las cuentas que maneja un banco de la siguiente manera:
Un cliente puede tener una cuenta corriente o una caja de ahorro.
En ambos tipos de cuentas se pueden realizar depositos y extracciones
Las cuentas pueden ser en distintas monedas.
Las cuentas corrientes tienen un descubierto, mientras que las cajas de ahorro no.
 */

/*Cliente PYMES, Cliente Empresa y Cliente Individuo.

Las pymes y las empresas tienen razón social y CUIT.
Los clientes individuos tienen nombre y DNI.

Los clientes de todas las categorías tienen número de cliente, cuenta corriente y caja de ahorro.

Todos los clientes pueden consultar su saldo, hacer depósitos y extracciones de sus cuentas.

YAPA: Los clientes individuo y pymes pueden pedir préstamos.*/


public class Main {

    public static void main(String[] args) {

        ClienteIndividuo jazmin = new ClienteIndividuo(1, 50.00);
        ClienteEmpresa globant = new ClienteEmpresa(1, 25000.00);
        ClientePyme aquaPyME = new ClientePyme(1, 10000.00);

        //Jazmin "es un" Cliente y "tiene una" caja de ahorro
        // "es un tipo de"  define Herencia Por ejm: Jazmin extends Persona (Jazmin es un tipo de Persona)
        // "es un" define tipo de Objeto. Por ej.: Cliente jazmin = new Cliente (jazmin es un objeto Cliente).
        // "tiene una" define atributo. Por ej.: private String nombre (jazmin tiene un atributo que es nombre)

        //cuendo se crea un cliente se debe especificar el saldo inicial
        //en su caja de ahorro
        //en la cuentaCorriente tendra saldo cero.

        //Cliente Individuo
        CajaAhorro cdaJazmin = jazmin.getCajaAhorro();

        cdaJazmin.depositar(100.00);
        cdaJazmin.extraer(100.00);
        cdaJazmin.depositar(9000.50);
        System.out.println("El saldo de Jazmin es: " + cdaJazmin.getSaldo());
        jazmin.pedirPrestamo(10000.00);
        System.out.println("El saldo de Jazmin con Préstamo es: " + cdaJazmin.getSaldo());

        CuentaCorriente ccJazmin = jazmin.getCuentaCorriente();
        System.out.println("El saldo inicial de la CC de Jazmin es: "+ccJazmin.getSaldo()+
                " y tiene un descubierto de $5000");

        // Cliente Empresa
        CajaAhorro cdaglobant = globant.getCajaAhorro();
        System.out.println("El saldo inicial de CA de la Empresa Globant es: " + cdaglobant.getSaldo());
        cdaglobant.depositar(10000.00);
        cdaglobant.extraer(400.50);
        System.out.println("El nuevo saldo de la CA de Globant es: "+cdaglobant.getSaldo());

        CuentaCorriente ccglobant = globant.getCuentaCorriente();
        System.out.println("El saldo incial de la CC de Globant es: "+ccglobant.getSaldo()+
                " y tiene un decubierto de $ 5000");
        ccglobant.extraer(29000.00);
        System.out.println("El nuevo saldo es: "+ccglobant.getSaldo());
        globant.pedirPrestamo(10000.00);

        //Cliente PyME
        CajaAhorro cdaAquaPyME = aquaPyME.getCajaAhorro();
        System.out.println("El saldo inicial de CA de la PyME Aqua es: " + cdaAquaPyME.getSaldo());
        cdaAquaPyME.depositar(5000.00);
        cdaAquaPyME.extraer(150.25);
        System.out.println("El nuevo saldo de la CA de la PyME Aqua es: "+cdaAquaPyME.getSaldo());
        aquaPyME.pedirPrestamo(10500.20);
        System.out.println("El saldo de la PyMe Aqua con Préstamo es: " + cdaAquaPyME.getSaldo());

        CuentaCorriente ccAquaPyME = aquaPyME.getCuentaCorriente();
        System.out.println("El saldo incial de la CC de la PyME Aqua es: "+ccAquaPyME.getSaldo()+
                " y tiene un decubierto de $ 5000");

        CuentaCorriente cuentaNueva = new CuentaCorriente(100.00);
        cuentaNueva.depositar(250.30);
        cuentaNueva.getDescubierto();

    }
}
