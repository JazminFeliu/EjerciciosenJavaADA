package com.company;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "autores")
public class Autor {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer idAutor;
    private String nombre;
    @ManyToMany (mappedBy = "autores", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Libro> libros = new ArrayList<>();
    private String paginaWeb;
    private String nacionalidad;

    public Autor() {
    }

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    public Autor(Integer idAutor, String nombre, List<Libro> libros, String paginaWeb, String nacionalidad) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.libros = libros;
        this.paginaWeb = paginaWeb;
        this.nacionalidad = nacionalidad;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAutor=" + idAutor +
                ", nombre='" + nombre + '\'' +
                ", paginaWeb='" + paginaWeb + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
