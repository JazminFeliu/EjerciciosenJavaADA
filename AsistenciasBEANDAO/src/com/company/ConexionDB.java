package com.company;

import java.sql.*;

public class ConexionDB {

    private Connection conexion = null;
    private Statement st = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;


    private String dbURL;
    private String dbUSER;
    private String dbPWD;

    public ConexionDB(String dbName, String dbUSER, String dbPWD){
        this.dbURL = "jdbc:mysql://localhost/"+dbName;
        this.dbUSER = dbUSER;
        this.dbPWD = dbPWD;
        iniciarConexion();
    }


    public ConexionDB(String dbName, String dbUSER, String dbPWD, String sql){
        this.dbURL = "jdbc:mysql://localhost/"+dbName;
        this.dbUSER = dbUSER;
        this.dbPWD = dbPWD;
        iniciarConexionPSTMT(sql, true);
    }


    private void iniciarConexion() {
        try {
            conexion = DriverManager.getConnection(dbURL, dbUSER, dbPWD);
            st = conexion.createStatement();
        }catch (SQLException e){
            System.out.println("No se ha podido conectar con la base de datos.");
        }
    }

    private void iniciarConexionPSTMT(String sql, boolean retornaKeys) {
        try {
            conexion = DriverManager.getConnection(dbURL, dbUSER, dbPWD);
            if (retornaKeys)
                pstmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            else
                pstmt = conexion.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar con la base de datos.");
        }
    }public int ejecutarRetornarKey() throws SQLException{
        int idGenerado = 0;
        if(pstmt.executeUpdate() >  0){
            ResultSet keyGeneradas = pstmt.getGeneratedKeys();
            if(keyGeneradas.next())
                idGenerado =keyGeneradas.getInt(1);
        }
        return idGenerado;
    }

    public void ejecutar() throws SQLException{
        if(pstmt!=null && !pstmt.isClosed())
            pstmt.executeUpdate();
    }

    public ResultSet consultar(String sql){
        try{
            if(st!=null && !st.isClosed())
                rs = st.executeQuery(sql);
        }catch (SQLException | NullPointerException e){
            System.out.println("No se ha podido realizar la búsqueda.");
        }
        return rs;
    }

    public int actualizar(String sql) throws SQLException{
        return st.executeUpdate(sql);
    }

    public PreparedStatement getPstmt(){
        return this.pstmt;
    }

    public void cerrar(){
        try {
            if(pstmt!=null && !pstmt.isClosed())
                pstmt.close();
            if(st!=null && !st.isClosed())
                st.close();
            if(conexion !=null && !conexion.isClosed())
                conexion.close();
        }catch (SQLException throwables){
            System.out.println("Conexion con base de datos cerrada.");
        }
    }

}