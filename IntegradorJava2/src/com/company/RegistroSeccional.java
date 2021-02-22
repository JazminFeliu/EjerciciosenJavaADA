package com.company;

import java.time.LocalDate;
import java.util.*;

public class RegistroSeccional {

    private List<Vehiculo> vehiculos;
    private Integer idRegistroSeccional;
    private String uso;
    private Persona propietario;
    private List<Persona>autorizados;
    private LocalDate fecha;
    private String patente;
    private HashSet<String>patentesUnicas = new HashSet<>();


    public RegistroSeccional(Integer idRegistroSeccional) {
        this.idRegistroSeccional = idRegistroSeccional;
        vehiculos = new LinkedList<>();
    }
    private LocalDate cargarFechaAleatoria(Integer opcion){
         LocalDate fechaopcional1 = LocalDate.now();
         LocalDate fechaopcional2 = LocalDate.of(2019,06,15);
         LocalDate fechaOpcional3 = LocalDate.of(2020, 9, 6);
         Map<Integer,LocalDate>mapaFechasOpcionales = new HashMap<>();
         nuevaFechaEnMapa(mapaFechasOpcionales,1,fechaopcional1);
         nuevaFechaEnMapa(mapaFechasOpcionales, 2, fechaopcional2);
         nuevaFechaEnMapa(mapaFechasOpcionales, 3, fechaOpcional3);
        return mapaFechasOpcionales.get(opcion);
    }

    private static void nuevaFechaEnMapa(Map<Integer,LocalDate>mapaFechasOpcionales,Integer nro, LocalDate fecha) {
        mapaFechasOpcionales.put(nro,fecha);
    }

    //Opcional 2: Se debe registrar la FECHA en la que se da de alta un automotor.
    public LocalDate getFechaDeAlta(){
        Random aleatorio = new Random();
        int opcionFechaAleatoria = aleatorio.nextInt(3)+1;
        fecha = cargarFechaAleatoria(opcionFechaAleatoria);
        return fecha;
    }

    public void darAltaVehiculo(Vehiculo v ) {
        this.fecha = getFechaDeAlta();
        this.patente = getPatente();
        this.uso = getUso();
        vehiculos.add(v);
        //alta nuevo vehiculo
    }

    public String getPatente(){
        do {
            patente = generarPatenteRandom();
        }while (!verificarIngresoPatenteUnica(patente));
        return patente;
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

    //Opcional 1: Cada automotor tiene una PATENTE unica que se asigna automáticamente
    // al realizar el alta del registro
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

    public String getUso() {
        Random r = new Random();
        if (r.nextInt() < 20) {
            uso = "Particular";
        }else{
            uso = "Profesional";
        }return uso;
    }
}


