package com.company;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "libros")

public class Libro {

    @Id
    private Integer idLibro;
    private String nombre;
    private String categoria;
    private String isbn;
    private Integer anioPublicacion;

   @JoinTable(name ="librosxautor", joinColumns = @JoinColumn(name = "idLibro"), inverseJoinColumns = @JoinColumn(name ="idAutor"))
   @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Autor> autores;
    private String editorial;

    public Libro() {
    }

    public Libro(Integer idLibro, String nombre, String categoria, String isbn, Integer anioPublicacion, List<Autor> autores, String editorial) {
        this.idLibro = idLibro;
        this.nombre = nombre;
        this.categoria = categoria;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.autores = autores;
        this.editorial = editorial;
    }

    public Libro (String nombre, String categoria, String isbn, Integer anioPublicacion, List<Autor> autores, String editorial) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.autores = autores;
        this.editorial = editorial;
    }

    public Integer getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria +
                ", isbn='" + isbn + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", editorial='" + editorial + '\'' +
                '}';
    }
}
