package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hotel {

    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Huesped> huespedes = new ArrayList<>();
    private List<Reserva>reservas = new ArrayList<>();
    private final String dbName = "hotel";
    private final String dbUser = "root";
    private final String dbPwd = "root";
    private Boolean isMenu;
    private Scanner sc = new Scanner(System.in);
    private Integer opcion;



    public Hotel(){
        this.isMenu = true;

    }

    public void iniciarMenu() {
        while (isMenu){
            System.out.println("Bienvenido al sistemas de reservas del Hotel");
            System.out.println("1 - Crear nueva Reserva");
            System.out.println("2 - Verificar Estado de la Reserva");
            System.out.println("3 - Listar todas las reservas");
            System.out.println("4 - Listar habitaciones disponibles");
            System.out.println("0 - Salir");

            System.out.print("Ingrese una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cantidad de huespedes: ");
                    int cantidadHuespedes = Integer.parseInt(sc.nextLine());
                    System.out.print("Cantidad de habitaciones: ");
                    int cantidadHabitaciones = Integer.parseInt(sc.nextLine());
                    int cantHab = cantidadHabitacionesDisponibles();
                    System.out.println("Tengo "+cantHab+" habitaciones disponibles");
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();
                    if(crearReserva(nombre, cantidadHuespedes,cantidadHabitaciones, email, telefono))
                        System.out.println("Reserva creada!");
                    else
                        System.out.println("NO se pudo crear la reserva");
                    break;
                case 2:
                    System.out.println("verfificar estado reserva");
                    break;
                case 3:
                    System.out.println("Listar todas las reservas");
                    for(Reserva r: getReservas()){
                        System.out.println("Reserva:"+r );
                    }
                    break;
                case 4:
                    System.out.println("listar todas las habitaciones disponibles");
                    int cant = cantidadHabitacionesDisponibles();
                    System.out.printf("Tengo %d habitaciones disponbles. \n", cant);
                    break;
                case 0:
                    System.out.println("Gracias por utilizar el servicio de Reservas");
                    isMenu = false;
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta");
            }
        }
    }


    public Boolean crearReserva(String nombreReserva, Integer cantidadHuespedes, Integer cantidadHabitaciones, String  mail, String telefono){
        //ACUERDO NUESTRO
        boolean reservado = false;
        int capacidad = (int) Math.ceil(cantidadHuespedes / cantidadHabitaciones);
        if(cantidadHabitacionesDisponibles(capacidad) >= cantidadHabitaciones){
            reservas.add(new Reserva(nombreReserva, cantidadHuespedes, cantidadHabitaciones, mail, telefono));
            reservado = true;
        }
        return reservado;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Huesped> getHuespedes() {
        return huespedes;
    }

    public void setHuespedes(List<Huesped> huespedes) {
        this.huespedes = huespedes;
    }

    public int cantidadHabitacionesDisponibles(){
        return cantidadHabitacionesDisponibles(0);
    }


    public int cantidadHabitacionesDisponibles(int cantidad){
        int cantidadHabitacionesDisponibles = 0;
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd);
        ResultSet resultados = conexionDB.consultar("SELECT COUNT(*) AS cantidad FROM habitaciones WHERE disponible = TRUE AND capacidad >= "+cantidad+";");
        try {
            if (resultados!=null)
                if (resultados.next())
                    cantidadHabitacionesDisponibles = resultados.getInt("cantidad");
        }catch (SQLException e){
            System.out.println("Error");

        }finally {
            conexionDB.cerrar();
        }
        return cantidadHabitacionesDisponibles;
    }
    public List<Reserva> getReservas() {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd);
        ResultSet resultados = conexionDB.consultar("SELECT reservas.idReserva, reservas.estado, huespedes.nombre, huespedes.email, huespedes.telefono, reservas.cantidadHuespedes, reservas.cantidadHabitaciones FROM reservas INNER JOIN huespedes ON reservas.idReserva = huespedes.idReserva;");
        try {
            if (resultados != null){
                this.reservas.clear();
            while (resultados.next()) {
                Integer idReserva = resultados.getInt("reservas.idReserva");
                Integer nroEstado = resultados.getInt("reservas.estado");
                Estado estado = Estado.values()[nroEstado];
                String nombre = resultados.getString("huespedes.nombre");
                Integer cantidadHuspedes = resultados.getInt("reservas.cantidadHuespedes");
                Integer cantidadHabitaciones = resultados.getInt("reservas.cantidadHabitaciones");
                String email = resultados.getString("huespedes.email");
                String telefono = resultados.getString("huespedes.telefono");
                this.reservas.add(new Reserva(idReserva, estado, nombre, cantidadHuspedes, cantidadHabitaciones, email, telefono));
            }
        }
        }catch (SQLException e){
            System.out.println("No hay reservas");
        }finally {
            conexionDB.cerrar();
        }
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }


}
