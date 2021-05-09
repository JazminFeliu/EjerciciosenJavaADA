package com.company;

import com.company.entidades.Animal;
import com.company.entidades.Ave;
import com.company.entidades.Gato;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        List<Gato> gatos = (List<Gato>) session.createQuery("FROM Gato").list();

        for(Gato gato: gatos)
            System.out.println(gato);

        List<Ave> aves = (List<Ave>) session.createQuery("FROM Ave").list();
        for(Ave ave: aves)
            System.out.println(ave);

    }

}
