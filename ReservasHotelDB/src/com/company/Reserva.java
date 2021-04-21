package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private Integer idReserva;
    private Integer cantidadHuespedes;
    private Estado estado;
    private Integer cantidadHabitaciones;
    private String nombreReserva;
    private String email;
    private String telefono;
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Huesped> huespedes = new ArrayList<>();

    private String dbName ="hotel";
    private String dbUser ="root";
    private String dbPwd ="root";

    public Reserva(String nombreReserva, Integer cantidadHuespedes, Integer cantidadHabitaciones, String email, String telefono){
        this.cantidadHuespedes = cantidadHuespedes;
        this.cantidadHabitaciones = cantidadHabitaciones;
        if(crearReserva(Estado.CONFIRMADA.ordinal(), cantidadHuespedes, cantidadHabitaciones)) {
            this.estado = Estado.CONFIRMADA;
            actualizarHabitaciones();
            Huesped huesped = new Huesped(nombreReserva, email, telefono, idReserva);
            crearHuespedXReserva(huesped.getIdHuesped());
            huespedes.add(huesped);
        }else {
            this.estado = Estado.CANCELADA;
        }
    }

    private void borrarReserva() {
        String sql = "DELETE FROM 'reserva' WHERE idReserva =?;";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setInt(1, idReserva);
            conexionDB.ejecutar();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionDB.cerrar();
        }
    }


    private void crearHuespedXReserva(int idHuesped) {
        String sql = "INSERT INTO huespedesxreserva (idReserva, idHuesped) VALUES (?,?);";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setInt(1, idReserva);
            pstmt.setInt(2, idHuesped);
            conexionDB.ejecutar();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionDB.cerrar();
        }
    }

                private void reservarHabitacion(int idHabitacion) {
                    String sql = "UPDATE habitaciones SET idReserva = ?, disponible ='0' WHERE idHabitacion = ?";
                    ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd, sql);
                    PreparedStatement pstmt = conexionDB.getPstmt();
                    try {
                        pstmt.setInt(1, idReserva);
                        pstmt.setInt(2, idHabitacion);
                        conexionDB.ejecutar();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        conexionDB.cerrar();
                    }
                }

            private void crearHabitacionXReserva(int idHabitacion){
                String sql = "INSERT INTO habitacionesxreserva (idReserva, idHabitacion) VALUES (?,?);";
                ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd, sql);
                PreparedStatement pstmt = conexionDB.getPstmt();
                try {
                    pstmt.setInt(1, idReserva);
                    pstmt.setInt(2, idHabitacion);
                    conexionDB.ejecutar();
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    conexionDB.cerrar();
                }
            }

            private void actualizarHabitaciones(){
                String sql = "SELECT * FROM habitaciones WHERE disponible = 1 AND (capacidad >= ? AND capacidad <= ?) ORDER BY capacidad;";
                ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd, sql);
                PreparedStatement pstmt = conexionDB.getPstmt();
                int capacidadMinima = (int) Math.ceil(cantidadHuespedes/cantidadHabitaciones);
                try {
                    pstmt.setInt(1, capacidadMinima);
                    pstmt.setInt(2, capacidadMinima+2);
                    ResultSet rs = pstmt.executeQuery();
                    if(rs!=null)
                        for (int i = 0; i<cantidadHabitaciones; i++)
                            if(rs.next()){
                                reservarHabitacion(rs.getInt(1));
                                crearHabitacionXReserva(rs.getInt(1));
                            }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    conexionDB.cerrar();
                }
            }


        private boolean crearReserva(int estado, Integer cantidadHuespedes, Integer cantidadHabitaciones) {
            String sql = "INSERT INTO reservas (estado, cantidadHuespedes, cantidadHabitaciones) VALUES (?, ?, ?)";
            ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd, sql);
            PreparedStatement pstmt = conexionDB.getPstmt();
            try {
                pstmt.setInt(1, estado);
                pstmt.setInt(2, cantidadHuespedes);
                pstmt.setInt(3, cantidadHabitaciones);
                this.idReserva = conexionDB.ejecutarRetornarKey();
            }catch (SQLException e){
                e.printStackTrace();
                return false;
            }finally {
                conexionDB.cerrar();
            }return (this.idReserva >0 );
        }

        public Reserva(int idReserva, Estado estado, String nombreReserva, int cantidadHuespedes, int cantidadHabitaciones, String email, String telefono) {
            this.idReserva = idReserva;
            this.estado = estado;
            huespedes.add(new Huesped(nombreReserva, email, telefono));
            this.cantidadHabitaciones = cantidadHabitaciones;
            this.cantidadHuespedes = cantidadHuespedes;
        }

        public void agregarHuesped(String nombre){
            huespedes.add(new Huesped(nombre, idReserva));
        }


        @Override
        public String toString() {
            return "Reserva{" +
                    "idReserva=" + idReserva +
                    ", cantidadHuespedes=" + cantidadHuespedes +
                    ", estado=" + estado +
                    ", cantidadHabitaciones=" + cantidadHabitaciones +
                    ", habitaciones=" + habitaciones +
                    ", huestedes=" + huespedes +
                    '}';
        }
}

