package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	/*Sistema de facturación para una zapatería.
	Donde tenemos: Productos -> id, nombre, precioUnitario
	Facturas -> id, nombreCliente, precioTotal, cantidadItems
	Items de facturas -> id, idProducto, cantidad, precioSubtotal
	Crear el sistema que permita registrar nuevas facturas y mostrarlas en pantalla.
	Items de facturas -> id, idFactura, idProducto, cantidad, precioSubtotal
	 */

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session =sf.openSession();

        List<Producto> productos = (List<Producto>) session.createQuery("FROM Producto").getResultList();
        for(Producto producto: productos)
            System.out.println(producto);

        System.out.println("Ahora muestro las facturas:");
        List <Factura> facturas = (List<Factura>) session.createQuery("FROM Factura").list();
        for (Factura f: facturas) {
            System.out.println(f);
        }
        System.out.println("Pasa el tiempo");
        System.out.println("Hago otras cosas");
        System.out.println("Y un dia quiero hacer esto:");
        Factura unaFactura = facturas.get(0);
        System.out.println("Detalle de items de la primer factura");
        System.out.println(unaFactura.getItems());
    }
}
