package com.company.dao;

import com.company.entidades.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public abstract class ClienteDAO {

    private static SessionFactory sf = new Configuration().configure().buildSessionFactory();


    public static List<Cliente> getClientes(){
            Session session =sf.openSession();
            List<Cliente>clientes = (List<Cliente>) session.createQuery("FROM Cliente").list();
            session.close();
            return clientes;
    }

    public static Cliente buscarCliente(int id){
        Session session =sf.openSession();
        Cliente cliente = session.load(Cliente.class, id);
        session.close();
        return cliente;
    }

    public static void guardarCliente(Cliente cliente){
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
        session.close();
    }

    public static Cliente buscarClienteXNombre(String nombre){
        Session session =sf.openSession();
        Cliente cliente = (Cliente) session.createQuery("FROM Cliente WHERE nombreCliente LIKE :nombre").setParameter("nombre","%"+nombre+"%").list().get(0);
        session.close();
        return cliente;
    }



}
