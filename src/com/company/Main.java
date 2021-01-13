//CONSIGNA: Cierta empresa proporciona un bono mensual a sus trabajadores, el cual puede ser por su antiguedad o bien
// por el monto de su sueldo (el que sea mayor), de la siguiente forma:
//Cuando la antiguedad es mayor a 2 años pero menor a 5, se otorga 20% de su sueldo; cuando es de 5 años o mas, 30%.

//Ahora bien, el bono por concepto de sueldo, si éste es menor a $1000, se da 25% de este, cuando este es mayor a $ 1000,
// pero menor o igual a $ 3500, se otorga 15% de su sueldo, para mas de $3500 un 10%.
//crear un programa en java que informe el bono correspondiente a un empleado.


package com.company;

public class Main {

    public static void main(String[] args) {

        Empleado empleado = new Empleado(10,2500.50);
        empleado.informarBono();


    }
}
