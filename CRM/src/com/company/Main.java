package com.company;

import com.company.entidades.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*
         CRM para la gestión de ventas en una empresa Se requiere un sistema que permita registrar una oportunidad de negocio.
         En cada oportunidad se debe anotar el nombre de la empresa, el nombre del contacto, su cargo, el producto o servicio ofrecido
         y si acepta una llamada de seguimiento.
         Además, registrar fecha de contacto inicial y si se le brindó un precio de referencia y en ese caso, indicar monto.
         Debe registrar un estado.
         Notas: El sistema va a tener muchos vendedores.
         Cada vendedor debería tener muchas oportunidades de negocio.
         */

        Empresa empresa = new Empresa();
        empresa.iniciar();

        System.out.println("PROBANDO LISTAR CLIENTES CON HIBERNATE y ClientesDAO: ");
        //for(Cliente cli:ClienteDAO.getClientes() ) System.out.println(cli);
        System.out.println();

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try(Session session = sf.openSession()){
            session.beginTransaction();
            List<Cliente> clientes = (List<Cliente>) session.createQuery("FROM Cliente").list();
            System.out.println("PROBANDO LISTAR CLIENTES CON HIBERNATE: ");
            for(Cliente cliente: clientes) System.out.println(cliente);
            System.out.println();


            List<Producto> productos = (List<Producto>) session.createQuery("FROM Producto").list();
            System.out.println("PROBANDO LISTAR AHORA PRODUCTOS CON HIBERNATE: ");
            for(Producto producto: productos) System.out.println(producto);
            System.out.println();

            List<Servicio>servicios = (List<Servicio>) session.createQuery("FROM Servicio").list();
            System.out.println("AHORA LE TOCA A LOS SERVICIOS CON HIBERNATE!!");
            for(Servicio servicio: servicios) System.out.println(servicio);
            System.out.println();

            List<Empresa> empresas = (List<Empresa>) session.createQuery("FROM Empresa").list();
            System.out.println("Y QUE PASA CON LAS EMPRESAS Y HIBERNATE? A VEEERRR");
            for (Empresa empresa1: empresas) System.out.println(empresa1);
            System.out.println();

            List<Vendedor> vendedores = (List<Vendedor>) session.createQuery("FROM Vendedor").list();
            System.out.println("AHORA LE TOCA A HIBERNATE CON LOS VENDEDORES!");
            for (Vendedor vendedor: vendedores) System.out.println(vendedor);
            System.out.println();

            //Cliente unCliente =

        }
    }
}
