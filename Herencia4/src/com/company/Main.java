package com.company;

public class Main {

    public static void main(String[] args) {

        /*
        Una financiera tiene 3 tipos de clientes: Riesgosos, confiables y nuevos.
        Todos los clientes pueden solicitar un préstamo.
        A los clientes riesgosos sólo se les otorgan préstamos de hasta 100 pesos.
        A los nuevos se les puede prestar 200. A los confiables hasta 500.
        Los clientes pueden pagar su deuda de forma total o parcial. Todos los clientes pueden consultar su deuda.
        Si un cliente ya solicitó un préstamo y cancela su deuda, se convierte en cliente confiable.
        Definiciones java https://ibm.box.com/v/definicionesJavaPOO
         */
       Cliente c = new Cliente("riesgoso");
       c.pedirPrestamo(50.00);
        System.out.println("Deuda actual: "+c.consultarDeuda());
        c.realizarPago(10.00);
        System.out.println("Ahora debe: "+c.consultarDeuda());
        System.out.println("El monto prestado originalmente $"+c.getMontoPrestado());
        c.realizarPago(c.consultarDeuda());
        System.out.println("La categoria es: "+c.getCategaoria());
    }
}
