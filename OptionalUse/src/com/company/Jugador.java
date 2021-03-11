package com.company;

import java.util.zip.DataFormatException;

public class Jugador {

    private Integer dni;
    private String nombre;
    public Jugador(Integer dni, String nombre){
        this.nombre = nombre;
        try {
            asignarDNI(dni);

        } catch (DatosIncorrectosException e ){
            e.printStackTrace();
        }
    }

    private void asignarDNI(Integer dni) throws DatosIncorrectosException {
        if(String.valueOf(dni).length()!=8){
            throw new DatosIncorrectosException("El DNI debe tener 8 digitos");
        }else {
            this.dni = dni;
        }
    }
    public void jugar() {
        System.out.printf("Soy %s y estoy jugando");
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni)  {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
