package com.company;
import java.util.List;

public class Vehiculo {

    private Integer idRegistro;
    private String uso;
    private String tipoDeVehiculo;
    private String tipoDeMotor;
    private Persona propietario;
    List<Persona> autorizados;

    public Vehiculo(Integer idRegistro, String uso, String tipoDeVehiculo, String tipoDeMotor, Persona propietario, List<Persona>autorizados){
        this.idRegistro = idRegistro;
        this.uso = uso;
        this.tipoDeVehiculo = tipoDeVehiculo;
        this.tipoDeMotor = tipoDeMotor;
        this.propietario = propietario;
        this.autorizados = autorizados;
    }

    public Integer getIdRegistro(){
        return idRegistro;
    }

    public String getUso(){
        return uso;
    }

    public String getTipoDeVehiculo(){
        return tipoDeVehiculo;
    }

    public String getTipoDeMotor(){
        return tipoDeMotor;
    }
    public Persona getPropietario(){
        return propietario;
    }

    public List<Persona> getAutorizados(){
        return autorizados;
    }
}


