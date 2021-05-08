package com.company.entidades;

import javax.persistence.*;
import java.util.List;
@Entity
@Table (name = "empresas")
public class Empresa {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;
    private String vendedores;
    private String items;
    private String oportunidades;
    //private List<Vendedor> vendedores; //javier, josefina, milena
    //private List<Item> catalogo; //lo que puedo vender
    //private List<Oportunidad> oportunidades;  //LAZZI PORFA
    private String nombreEmpresa;


    public void iniciar() {
        System.out.println("Bienvenido al CRM - Gestion de Oportunidades de Clientes Empresa!");
        System.out.println();
    }

    public Empresa() {
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getVendedores() {
        return vendedores;
    }

    public void setVendedores(String vendedores) {
        this.vendedores = vendedores;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(String oportunidades) {
        this.oportunidades = oportunidades;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", vendedores='" + vendedores + '\'' +
                ", items='" + items + '\'' +
                ", oportunidades='" + oportunidades + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                '}';
    }
}



