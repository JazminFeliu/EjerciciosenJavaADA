package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        try (Session session = sf.openSession()){
            session.beginTransaction();
            List<Producto> productos = (List<Producto>) session.createQuery("FROM Producto").list();
            for(Producto p: productos) System.out.println(p); }

    }

    }
