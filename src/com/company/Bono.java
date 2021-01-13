package com.company;

public class Bono {

    Double valor;

    public Bono(Integer antiguedad, Double salario){
        Double bonoAntiguedad;
        Double bonoSalario;

        bonoAntiguedad = calcularBonoAntiguedad(antiguedad, salario);
        bonoSalario = calcularBonoSalario(salario);
        //shorthand if ; operador condicional ternario
        this.valor = bonoAntiguedad > bonoSalario ? bonoAntiguedad : bonoSalario;
    }

    private Double calcularBonoAntiguedad(Integer antiguedad, Double salario) {
        double bonoAntiguedad;
        if (antiguedad > 2 && antiguedad < 5){
            bonoAntiguedad = salario * 0.2;
        }else if ( antiguedad >= 5){
            bonoAntiguedad = salario*0.3;
        }else{
            bonoAntiguedad = 0.0;
        }
        return bonoAntiguedad;
    }

    private Double calcularBonoSalario(Double salario) {
        double bonoSalario;
        if(salario < 1000){
            bonoSalario = salario*0.25;
        }else if (salario <=3500){
            bonoSalario = salario * 0.15;
        }else{
            bonoSalario = salario * 0.1;
        }
        return bonoSalario;
    }

    public Double obtenerValor() {
        return this.valor;
    }
}
