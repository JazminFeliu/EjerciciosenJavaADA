package com.company;

import java.sql.*;

public class Huesped {

    private Connection conexion = null;
    private Integer idHuesped;
    private String nombre;
    private String telefono;
    private String email;
    private String dbName = "hotel";
    private String dbUser ="root";
    private String dbPWD = "root";
    private Integer idReserva;
    //private Integer idHabitacion;

    public Huesped(String nombreReserva, String email, String telefono, Integer idReserva){
        this.nombre = nombreReserva;
        this.email = email;
        this.telefono = telefono;
        this.idReserva = idReserva;
        crearHuesped();
    }

    public Huesped(String nombreReserva, String email, String telefono){
        this.nombre = nombreReserva;
        this.email = email;
        this.telefono = telefono;

    }

    public Huesped(String nombre, int idReserva) {
        this.nombre = nombre;
        this.email="";
        this.telefono ="";
        this.idReserva = idReserva;
        crearHuesped();
    }

    public Huesped(Integer idHuesped, String nombre, String telefono, String email, Integer idReserva) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.idReserva = idReserva;
    }
    public Huesped(Integer idHuesped, String nombre, String telefono, String email) {
        this.idHuesped = idHuesped;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.idReserva = idReserva;
    }

    private boolean crearHuesped() {
        String sql = "INSERT INTO huespedes(nombre, email, telefono, idReserva) VALUES (?,?,?,?);";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            pstmt.setString(3, telefono);
            pstmt.setInt(4, idReserva);
            this.idHuesped = conexionDB.ejecutarRetornarKey();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            conexionDB.cerrar();
        }return (this.idHuesped >0 );
    }

    public Integer getIdHuesped() {
        return idHuesped;
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "idHuesped=" + idHuesped +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
