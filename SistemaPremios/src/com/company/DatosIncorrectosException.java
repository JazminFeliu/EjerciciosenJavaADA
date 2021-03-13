package com.company;

public class DatosIncorrectosException extends RuntimeException {

    public DatosIncorrectosException(String mensaje){
        super(mensaje);
    }
}
