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
    private Integer sizePatentesUnicas;



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
        patente = generarPatenteRandom();
        while (verificarIngresoPatenteUnica(patente) == false){
            generarPatenteRandom();
        }return patente;
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
        return patente;
    }

    private Boolean verificarIngresoPatenteUnica(String patente) {
        patentesUnicas.add(patente);
        sizePatentesUnicas = patentesUnicas.size();
        if (patentesUnicas.size() == sizePatentesUnicas) {
            return false;
        }
        return true;
   }
    public void cargarPersonas(Vehiculo v){
        //propietarios y autorizados
    }

    public void cambiarPropietario(Vehiculo v){
    }
}


