package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO {

    public static final String dbName = "asistenciasSeminario";
    public static final String dbUser = "root";
    public static final String dbPwd = "root";

    public static List<Asistencia> getPresentes() {
        List<Asistencia> lista = new ArrayList<>();
        String sql ="SELECT * FROM asistencias WHERE asistencia = 1;";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd);
        try {
            ResultSet rs = conexionDB.consultar(sql);
            if (rs!=null)
                while (rs.next())
                    lista.add(new Asistencia(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            Estado.values()[rs.getInt("asistencia")]
                    ));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }

        return lista;

    }

    public static void save(Asistencia asistencia) {
        String sql = "INSERT INTO asistencias (nombre, asistencia) VALUES (?,?)";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPwd, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setString(1, asistencia.getNombre());
            pstmt.setInt(2, asistencia.getPresente().ordinal());
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }

    }
}

