package com.company;

import java.sql.ClientInfoStatus;

/* Modelar las cuentas que maneja un banco de la siguiente manera:
Un cliente puede tener una cuenta corriente o una caja de ahorro.
En ambos tipos de cuentas se pueden realizar depositos y extracciones
Las cuentas pueden ser en distintas monedas.
Las cuentas corrientes tienen un descubierto, mientras que las cajas de ahorro no.
 */
public class Main {

    public static void main(String[] args) {

       Cliente jazmin = new Cliente(50.00);

       //Jazmin "es un" Cliente y "tiene una" caja de ahorro
        // "es un tipo de"  define Herencia Por ejm: Jazmin extends Persona (Jazmin es un tipo de Persona)
        // "es un" define tipo de Objeto. Por ej.: Cliente jazmin = new Cliente (jazmin es un objeto Cliente).
        // "tiene una" define atributo. Por ej.: private String nombre (jazmin tiene un atributo que es nombre)

        //cuendo se crea un cliente se debe especificar el saldo inicial
        //en su caja de ahorro
        //en la cuentaCorriente tendra saldo cero.

       CajaAhorro cdaJazmin = jazmin.getCajaAhorro();

       cdaJazmin.depositar(100.00);
       cdaJazmin.extraer(100.00);
       cdaJazmin.depositar(9800.00);
        System.out.println("El saldo de Jazmin es: "+cdaJazmin.getSaldo());

    }
}
