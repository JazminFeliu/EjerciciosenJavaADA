package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        try(Session session = sf.openSession()){
            List<Asistencia> asistencias = (List<Asistencia>) session.createQuery("FROM Asistencia").list();
            for(Asistencia a: asistencias)
                System.out.println(a);
        }
    }
}
