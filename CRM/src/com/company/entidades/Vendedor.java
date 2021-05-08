package com.company.entidades;

import javax.persistence.*;

@Entity
@Table (name = "vendedores")
public class Vendedor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVendedor;
    private String nombreVendedor;
    private String email;
    //private List<Cliente>clientes;
    private String oportunidades;
    //private List<Oportunidad> oportunidades; // de cada vendedor
    private String cargo; //vededor de productos, vendedor de servicios
    private String telefono;
    private Double salario;


    public Vendedor() {
    }

    public Integer getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Integer idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombreVendedor;
    }

    public void setNombre(String nombre) {
        this.nombreVendedor = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(String oportunidades) {
        this.oportunidades = oportunidades;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "idVendedor=" + idVendedor +
                ", nombre='" + nombreVendedor + '\'' +
                ", mail='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                ", oportunidades='" + oportunidades + '\'' +
                ", telefono='" + telefono + '\'' +
                ", salario=" + salario +
                '}';
    }
}
