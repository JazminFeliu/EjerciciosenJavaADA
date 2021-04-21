package com.company;

public class Main {

    public static void main(String[] args) {
	/*
	Sistema CRUD de reservas en hotel

    Crear un sistema que permita realizar reservas en un hotel.
    Cuando un cliente quiere realizar una reserva, indica cúantos huespedes desean hospedarse.
    De la persona que realiza la reserva se anota su nombre, nro de contacto y correo.

    Nota: Las reservas son diarias y dependen de la disponibiidad en el momento.

    Cada habitación tiene un tope de capacidad. (2, 4, 6 personas).

    Un cliente puede cancelar o modificar una reserva en cualquier momento.
    Las modificaciones pueden ser: cambio de teléfono o email o cambio de cantidad de huespedes
    (no siempre se puede, validar si es posible realizar el cambio).

    CRUD = Create, Read, Update, Delete
    ABMC = Altas, Bajas, Modificaciones, Consultas
	 */

        Hotel hotel = new Hotel();
        hotel.iniciarMenu();

    }

}
