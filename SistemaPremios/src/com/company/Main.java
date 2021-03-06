package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/* Crear un sistema que permita registrar usuarios de una empresa para un sistema de premios.
	Para el registro se necesita el nombre y el legajo.

	El legajo debe tener 4 letras o numeros, y comenzar con "A", "B" o "C".

	No permitir el registro si el legajo no es correcto.


	TIP:
	palabra.toUpperCase() // convierte a mayusculas

	palabra.startsWith("HOLA") // verifica si comienza con el texto que pasamos por parámetro.

	Anotaciones sobre excepciones:
	TryCatch ======== try { asignarDNI(dni); } catch (DatosIncorrectosException e)
	{ e.printStackTrace(); this.dni = 0; }
	Método que arroja una excepción ===============================
	private void asignarDNI(Integer dni) throws DatosIncorrectosException
	{ if(String.valueOf(dni).length()!=8){ throw new DatosIncorrectosException
	("El DNI debe tener 8 dígitos."); }else{ this.dni = dni; } }
	 */
        SistemaPremios premios = new SistemaPremios();

        Scanner sc = new Scanner(System.in);
        int op = 0;
        System.out.println("Vamos a agregar empleados!");

        do {
            premios.registrarNuevoUsuario();
            System.out.println("¿Desea agregar usuario nuevo?: (1= SI, 0 = NO)");
            op = Utilitaria.getInt();
        }while (op !=0);

        System.out.println("Lista");
        premios.listarUsuarios();


    }
}
