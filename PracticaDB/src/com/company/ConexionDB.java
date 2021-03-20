package com.company;

import com.sun.source.tree.BreakTree;

import java.sql.*;

public class ConexionDB {
    private Connection conexion = null;
    private Statement st = null;
    private ResultSet rs = null;

    private String dbURL;
    private String dbUSER;
    private String dbPWD;

    public ConexionDB(String dbName, String dbUSER, String dbPWD) {
        this.dbURL = "jdbc:mysql://localhost/"+dbName;
        this.dbUSER = dbUSER;
        this.dbPWD = dbPWD;
        iniciarConexion();
    }


    private void iniciarConexion(){
        try {
            conexion = DriverManager.getConnection(dbURL, dbUSER,dbPWD);
            st = conexion.createStatement();

        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.out.println("No se ha podido conectar con la base de datos.");
        }
    }


    public ResultSet consultar(String sql) {
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            System.out.println("No se ha podido realizar su búsqueda.");
        }
        return rs;
    }

    public void cerrar(){
        try {
            if(st !=null && !st.isClosed())
                st.close();
            if(conexion != null && !conexion.isClosed())
            conexion.close();
        } catch (SQLException throwables) {
            System.out.println("Conexion con base de datos cerrada.");;
        }
    }

    public boolean insertar(String sql) throws SQLException {
        return st.execute(sql);
    }
}
