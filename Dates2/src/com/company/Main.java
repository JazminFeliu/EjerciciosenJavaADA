package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/* Se pide al usuario que ingrese la fecha de vencimiento de un producto.
	Si el producto está vencido, se le sugiere que lo tire.
	Si faltan 30 dias o mas para su vencimiento, se le sugiere que lo guarde.
	Si faltan menos de 30 dias para su vencimiento, se le pide que lo use pronto
	porque va a tener que tirarlo.
	 */

        Scanner sc = new Scanner(System.in);
        LocalDate hoy = LocalDate.now();
                System.out.println("Ingrese el dia: ");
        int dia = sc.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes = sc.nextInt();
        System.out.println("Ingrese el año: ");
        int anio = sc.nextInt();
        LocalDate fechaAVerificar = LocalDate.of(anio,mes,dia);
        int diasParaVto = fechaAVerificar.getDayOfYear() - hoy.getDayOfYear();
        if (diasParaVto < 0){
            System.out.println("El producto esta vencido, tirelo");
        }else if (diasParaVto > 30){
            System.out.println("Guarde el producto, faltan mas de 30 dias para su vencimiento");
        } else {
            System.out.println("Use el producto, vence pronto");
        }

    }
}
