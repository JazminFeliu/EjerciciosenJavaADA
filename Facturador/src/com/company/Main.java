package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	/*
	Una empresa desea implementar un sistema facturador que permita emitir facturas.
	Cada factura tiene ítems varios que contienen la siguiente información:
	nro., detalle, cantidad y precio unitario, subtotal.
	De cada factura se puede consultar el monto total, incluyendo un 21% de IVA.
	Algunas facturas pueden tener un descuento de 5% o 10%.
	Se desea tener una lista de todas las facturas emitidas con sus montos y el monto total vendido.

	Clases: Factura (nrofactura, subtotal, iva, total)
	Item(nroItem, detalle, cantidad, precioUnitario, tieneDescuento)
	Una lista de objetos Factura.
	Metodos calcularIva, calcularDescuento, emitirFactura, Constructor, Getters y Setters de precioUnitario, montoTotal.
	 */
        Factura factura = new Factura();
        List<Factura> facturas = new ArrayList<>();

        factura.setDescuento(0.05);

        factura.agregarItem(new Item(1,"tornillos",20, 15.00));
        factura.agregarItem(new Item(2,"tuerca",24, 17.00));
        factura.agregarItem(new Item(3,"arandela",80, 25.00));
        factura.agregarItem(new Item(4,"martillo",2, 150.00));

        Double montoTotal = factura.consultarMontoFinal();
        System.out.println("El monto total es "+montoTotal);

        List<Item> itemsNuevos = new ArrayList<>();
        itemsNuevos.add(new Item(1, "tarugo", 18,20.00 ));
        itemsNuevos.add(new Item(2, "taladro", 1,2580.00 ));
        itemsNuevos.add(new Item(3, "destornillador", 1,750.00 ));
        facturas.add(new Factura(itemsNuevos));
        System.out.println("El monto total es "+montoTotal);

        Double montoTotalVendido = 0.00;

        for(Factura factura1:facturas){
            Double montoDeFactura = factura1.consultarMontoFinal();
            montoTotalVendido +=montoDeFactura;
            System.out.println("Factura por $ "+montoDeFactura);
        }

        System.out.println("Monto total vendido $ "+montoTotalVendido);
    }
}

