package com.company.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "animales")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnimal;
    private String nombre;
    private Integer edad;
    private Integer cantidadAlas;
    private Integer cantidadAletas;
    private Integer cantidadPatas;
    private Byte tieneTrompa;
    private Byte tienePico;
    private Byte tieneCaparazon;
    private String sexo;
    private String color;

    @Id
    @Column(name = "idAnimal", nullable = false)
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "edad", nullable = true)
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "cantidadAlas", nullable = true)
    public Integer getCantidadAlas() {
        return cantidadAlas;
    }

    public void setCantidadAlas(Integer cantidadAlas) {
        this.cantidadAlas = cantidadAlas;
    }

    @Basic
    @Column(name = "cantidadAletas", nullable = true)
    public Integer getCantidadAletas() {
        return cantidadAletas;
    }

    public void setCantidadAletas(Integer cantidadAletas) {
        this.cantidadAletas = cantidadAletas;
    }

    @Basic
    @Column(name = "cantidadPatas", nullable = true)
    public Integer getCantidadPatas() {
        return cantidadPatas;
    }

    public void setCantidadPatas(Integer cantidadPatas) {
        this.cantidadPatas = cantidadPatas;
    }

    @Basic
    @Column(name = "tieneTrompa", nullable = true)
    public Byte getTieneTrompa() {
        return tieneTrompa;
    }

    public void setTieneTrompa(Byte tieneTrompa) {
        this.tieneTrompa = tieneTrompa;
    }

    @Basic
    @Column(name = "TienePico", nullable = true)
    public Byte getTienePico() {
        return tienePico;
    }

    public void setTienePico(Byte tienePico) {
        this.tienePico = tienePico;
    }

    @Basic
    @Column(name = "TieneCaparazon", nullable = true)
    public Byte getTieneCaparazon() {
        return tieneCaparazon;
    }

    public void setTieneCaparazon(Byte tieneCaparazon) {
        this.tieneCaparazon = tieneCaparazon;
    }

    @Basic
    @Column(name = "Sexo", nullable = true, length = 100)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Basic
    @Column(name = "color", nullable = true, length = 100)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return idAnimal == animal.idAnimal && Objects.equals(nombre, animal.nombre) && Objects.equals(edad, animal.edad) && Objects.equals(cantidadAlas, animal.cantidadAlas) && Objects.equals(cantidadAletas, animal.cantidadAletas) && Objects.equals(cantidadPatas, animal.cantidadPatas) && Objects.equals(tieneTrompa, animal.tieneTrompa) && Objects.equals(tienePico, animal.tienePico) && Objects.equals(tieneCaparazon, animal.tieneCaparazon) && Objects.equals(sexo, animal.sexo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnimal, nombre, edad, cantidadAlas, cantidadAletas, cantidadPatas, tieneTrompa, tienePico, tieneCaparazon, sexo, color);
    }
}
