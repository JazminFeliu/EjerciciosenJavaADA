package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class AsistenciaDAO {

    public static List<Asistencia> getPresentes(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Asistencia.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        return (List<Asistencia>) session.createQuery("FROM Asistencia WHERE presente =1").list();
    }

    public static Asistencia getAsistenciaPorId(int id){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Asistencia.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        return session.get(Asistencia.class, id);
    }

    public static void guardarAsistencia(Asistencia asistencia){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Asistencia.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(asistencia);
        session.getTransaction().commit();
    }
}
