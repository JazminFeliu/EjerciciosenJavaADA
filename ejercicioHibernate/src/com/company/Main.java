package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	/* Crear un sistema(usando Java, MySQL, Hibernate)
	que permita listar los libros en una librería.

	Cada libro tiene un nombre, una categoría, un ISBN, un año de publicacion, un autor y una editorial.

	De cada autor se sabeL su nombre, los libros que escribió, su pagina web, su nacionalidad.


	 */

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        try(Session session = sf.openSession()){
            session.beginTransaction();
            System.out.println("LISTO LOS LIBROS!");
            List<Libro> libros = (List<Libro>) session.createQuery("FROM Libro").list();
            for(Libro libro: libros) System.out.println(libro);

            System.out.println("AHORA LOS AUTORES!");
            List<Autor> autores = (List<Autor>) session.createQuery("FROM Autor").list();
            for(Autor autor: autores) System.out.println(autor);


            Autor unAutor = new Autor("Jazmin");
            Autor unAutor2 = new Autor("Gabriela");
            List<Autor>autores2 = new ArrayList<>();
            autores2.add(unAutor);
            autores2.add(unAutor2);
            Libro unLibro = new Libro( "Matematica I", "ciencias exactas", "12345", 2004,autores2,"sudamericana" );

            List<Autor>losAutores = new ArrayList<>();
            losAutores.add(unAutor);
            unLibro.setAutores(losAutores);

            session.save(unLibro);

        }
    }
}
