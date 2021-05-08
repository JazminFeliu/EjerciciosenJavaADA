package com.company.entidades;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "oportunidades")

public class Oportunidad {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idOportunidad;
    @ManyToOne @JoinColumn(name = "idCliente")
    private Cliente cliente; //la PERSONA a la que le voy a vender
    private LocalDate ultimaFechaDeContacto; //ultima vez que hable
    private LocalDate proximaFechaDeContacto; //proxima vez que lo voy a llamar
    private Boolean acepta2daCall;
    //private Map<Item, Double>itemsOfrecidos;
    // private List<Item> catalogo; //productos y servicios ofrecidos
    private Double precioOfrecido;



}
