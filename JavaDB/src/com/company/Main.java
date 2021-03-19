package com.company;


import java.sql.*;

public class Main {

	public static void main(String[] args) {

		Connection conexion = null;
		Statement st = null; // query = consulta
		ResultSet resultados = null;


		String dbURL = "jdbc:mysql://localhost:3306/jaz";
		String usuarioBD = "root";
		String passDB = "root";
		String sql = "INSERT INTO empleados(nombre, apellido, legajo) VALUES ('jorge','brisuela','C546')";

		String query = "SELECT legajo, nombre, apellido FROM empleados";

		try {
			conexion = DriverManager.getConnection(dbURL, usuarioBD, passDB);
			st = conexion.createStatement();
			st.execute(sql);
			resultados = st.executeQuery(query);

			while(resultados.next()){
				String nombre = resultados.getString("nombre");
				String apellido = resultados.getString("apellido");
				String legajo = resultados.getString("legajo");
				System.out.println(nombre +" "+ apellido+" (legajo: "+legajo+")");
			}
		} catch (SQLException e) { e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

	}
}