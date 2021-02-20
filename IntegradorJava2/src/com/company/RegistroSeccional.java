package com.company;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RegistroSeccional {

    private List<Vehiculo> vehiculos;
    private Integer idRegistroSeccional;
    private String uso; //uso particular o profesional
    private Persona propietario;
    private List<Persona>autorizados;
    private LocalDate fechaDeAlta;
    private LocalDate fechaCambioPropietario;
    private String patente;
    private HashSet<String>patentesUnicas = new HashSet<>();

    public RegistroSeccional(Integer idRegistroSeccional) {
        this.idRegistroSeccional = idRegistroSeccional;
        vehiculos = new LinkedList<>();
    }

    public void darAltaVehiculo(Vehiculo v ) {
        this.fechaDeAlta = getFechaDeAlta();
        this.patente = getPatente();
        vehiculos.add(v);
        //alta nuevo vehiculo
    }

    public void transferirVehiculo(Vehiculo v){
        //registro de vehiculo existente transferencia
    }

    public String getPatente(){
        do {
            patente = generarPatenteRandom();
        }while (!verificarIngresoPatenteUnica(patente));
        return patente;
    }

    public LocalDate getFechaDeAlta(){
        fechaDeAlta = LocalDate.now();
        return fechaDeAlta;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Integer getIdRegistroSeccional(){
        return idRegistroSeccional;
    }

    private String generarPatenteRandom(){
        String numeros = "";
        String letras = "";

        for(int i = 1; i<=3; i++){
            int n = (int)(Math.random()*9+0);
            numeros = n+numeros;
            int l = (int)(Math.random()*(90-65+1)+65);
            letras = (char)l + letras;
        }
        patente = numeros+letras;
        return patente;
    }

    private Boolean verificarIngresoPatenteUnica(String patente) {
       return(patentesUnicas.add(patente));
   }
    public void darAltaPropietario(Persona propietario){
        this.propietario = propietario;
    }
    public void darAltaAutorizados(List<Persona>autorizados){
        this.autorizados = autorizados;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public List<Persona> getAutorizados() {
        return autorizados;
    }

    public void cambiarPropietario(Vehiculo v){
    }
}


