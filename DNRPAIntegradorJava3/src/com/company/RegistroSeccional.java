package com.company;

import java.time.LocalDate;
import java.util.*;

public class RegistroSeccional {

    private List<Vehiculo> vehiculos;
    private Integer idRegistroSeccional;
    private Uso uso;
    private Persona propietario;
    private List<Persona>autorizados;
    private LocalDate fecha;
    private String patente;
    private HashSet<String> patentesUnicas = new HashSet<>();
    private Random aleatorio = new Random();
    private Scanner scanner = new Scanner(System.in);


    public RegistroSeccional(Integer idRegistroSeccional) {
        this.idRegistroSeccional = idRegistroSeccional;
        vehiculos = new LinkedList<>();
    }

    private LocalDate cargarFechaAleatoria(Integer opcion){

        LocalDate fechaopcional1 = LocalDate.now();
        LocalDate fechaopcional2 = LocalDate.of(2019,06,15);
        LocalDate fechaOpcional3 = LocalDate.of(2020, 9, 6);
        LocalDate fechaOpcional4 = LocalDate.of(2010,4,10);
        LocalDate fechaOpcional5 = LocalDate.of(2003,9,21);
        LocalDate fechaOpcional6 = LocalDate.of(2016,01,15);

        Map<Integer,LocalDate> mapaFechasOpcionales = new HashMap<>();

        nuevaFechaEnMapa(mapaFechasOpcionales,1,fechaopcional1);
        nuevaFechaEnMapa(mapaFechasOpcionales, 2, fechaopcional2);
        nuevaFechaEnMapa(mapaFechasOpcionales, 3, fechaOpcional3);
        nuevaFechaEnMapa(mapaFechasOpcionales, 4, fechaOpcional4);
        nuevaFechaEnMapa(mapaFechasOpcionales,5,fechaOpcional5);
        nuevaFechaEnMapa(mapaFechasOpcionales,6,fechaOpcional6);

        return mapaFechasOpcionales.get(opcion);
    }

    public LocalDate getFechaDeAlta(){
        fecha = LocalDate.now();
        return fecha;
    }

    //Opcional 2: Se debe registrar la FECHA en la que se da de alta un automotor.
    public LocalDate getFechaDeAltaAleatoria(){
        int opcionFechaAleatoria = aleatorio.nextInt(6)+1;
        fecha = cargarFechaAleatoria(opcionFechaAleatoria);
        return fecha;
    }

    public void darAltaVehiculoAleatorio(Vehiculo v ) {
        this.patente = getPatenteAleatoria();
        vehiculos.add(v);
        //alta nuevo vehiculo aleatorio
    }

    public void darAltaVehiculo(Vehiculo v){
        this.patente = getPatente();
        vehiculos.add(v);

    }

    public Uso getUso() {
        Boolean isCorrect = true;

        do {
            System.out.print("Ingrese el uso que dará al vehículo (0: Particular/1:Profesional): ");
            Integer opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 0:
                    uso = uso.Particular;
                    isCorrect = false;
                    break;
                case 1:
                    uso = uso.Profesional;
                    isCorrect = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta");

            }

        }while (isCorrect);

        return uso;
    }

    public String getPatente(){
        do{
            this.patente = generarPatenteRandomNueva();
        }while (!verificarIngresoPatenteUnica(patente));

        return patente;
    }

    public String getPatenteAleatoria(){
        do {
            LocalDate fechaBorde = LocalDate.of(2016,04,01);
            if (fecha.isAfter(fechaBorde)) {
                this.patente = generarPatenteRandomNueva();
            } else {
                this.patente = generarPatenteRandomVieja();
            }
        }while (!verificarIngresoPatenteUnica(patente));
        return patente;
    }


    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Integer getIdRegistroSeccional() {
        return idRegistroSeccional;
    }


    private String generarPatenteRandomVieja() {
        String numeros = "";
        String letras = "";

        for(int i = 1; i <= 3; i++) {
            int n = (int)(Math.random()*9+0);
            numeros = n+numeros;
            int l = (int)(Math.random()*(90-65+1)+65);
            letras = (char)l + letras;
        }
        patente = letras+numeros;
        return patente;
    }

    private String generarPatenteRandomNueva() {
        String numeros = "";
        String letrasInicio = "";
        String letrasFin ="";

        for(int i = 1; i <= 3; i++) {
            int n = (int)(Math.random()*9+0);
            numeros = n+numeros;
            int l = (int)(Math.random()*(90-65+1)+65);
            letrasInicio = (char)l + letrasInicio;
            l = (int)(Math.random()*(90-65+1)+65);
            letrasFin = (char)l + letrasFin;
        }

        patente = letrasInicio.substring(0,2)+numeros+letrasFin.substring(0,2);
        return patente;
    }

    //Opcional 1: Cada automotor tiene una PATENTE unica que se asigna automáticamente
    // al realizar el alta del registro

    private Boolean verificarIngresoPatenteUnica(String patente) {
        return(patentesUnicas.add(patente));
    }

    public void darAltaPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public void darAltaAutorizados(List<Persona>autorizados) {
        this.autorizados = autorizados;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public List<Persona> getAutorizados() {
        return autorizados;
    }

    public Uso getUsoAleatorio() {

        if (aleatorio.nextInt() < 20)
            uso = uso.Particular;
        else
            uso = uso.Profesional;
        return uso;
    }

    private static void nuevaFechaEnMapa(Map<Integer,LocalDate>mapaFechasOpcionales,Integer nro, LocalDate fecha) {
        mapaFechasOpcionales.put(nro,fecha);

    }

}
