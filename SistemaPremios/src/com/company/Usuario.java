package com.company;

import jdk.jshell.execution.Util;

import java.util.Locale;

public class Usuario {

    private String nombre;
    private String legajo;

    public Usuario(String nombre, String legajo){
        setNombre(nombre);

        try {
            setLegajo(legajo);

        } catch (LegajoIncorrectoException e){
            e.printStackTrace();
        }
    }

    private void setNombre(String nombre) {
        if(Utilitaria.validarString(nombre,20))
        this.nombre = nombre;
        else {
            throw new DatosIncorrectosException("El nombre no es correcto.");
        }
    }

    private void setLegajo(String legajo) throws LegajoIncorrectoException {
        legajo = legajo.toUpperCase(Locale.ROOT);
        if((legajo.startsWith("A") || legajo.startsWith("B") ||
        legajo.startsWith("C")) && (legajo.length() == 4)){
            this.legajo = legajo;
            System.out.println("El legajo es valido: "+getLegajo());

        }else {
            throw new LegajoIncorrectoException("El legajo debe comenzar con A, B o C, y tres letras o numeros mas");
        }
    }

    public String getLegajo (){
        return this.legajo;
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", legajo='" + legajo + '\'' +
                '}';
    }
}
