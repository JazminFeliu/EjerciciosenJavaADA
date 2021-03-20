package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Sector {

    private Scanner sc = new Scanner(System.in);
    private String dbName = "empresa";
    private String dbUser = "root";
    private String dbPWD = "root";

    public void iniciarMenu() {

        int op = 0;
        System.out.println("Bienvenida al sistema");
        do {
            System.out.println("Elija una opcion: ");
            System.out.println(" 1. Mostrar empleados");
            System.out.println(" 2. Buscar empleado por legajo");
            System.out.println(" 3. Agregar nuevo empleado");
            System.out.println(" 0. Salir");
            System.out.print("Opcion: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op){
                case 1: listarEmpleados();
                    break;
                case 2: mostrarEmpleadoPorLegajo();
                    break;
                case 3: agregarEmpleado();
                    break;
                case 0:
                    System.out.println("Gracias por usar el sistema con DB");
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta.");

            }
        }while (op != 0);

    }

    public void listarEmpleados() {
        buscarYMostrarEnDB("SELECT nombre FROM empleados");
    }

    public void buscarYMostrarEnDB(String sql) {
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPWD);
        ResultSet rs = conexionDB.consultar(sql);
        try {
            mostrarResultados(rs);
        } catch (SQLException e) {
            System.out.println("No se econtraron resultados");
        } finally {
            conexionDB.cerrar();
        }
    }

    public void mostrarEmpleadoPorLegajo(){

        System.out.print("Ingrese un legajo: ");
        int legajo = Integer.parseInt(sc.nextLine());
        buscarYMostrarEnDB("SELECT nombre, apellido FROM empleados WHERE legajo = "+legajo);
        }


    private void mostrarResultados(ResultSet rs) throws SQLException {
        if (rs != null)
            while (rs.next())
                System.out.println("Nombre: "+rs.getString("nombre"));
    }

    private void agregarEmpleado() {
        System.out.println("Vamos a crear un nuevo empleado: ");
        System.out.print("Ingrese el nombre:");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el apellido: ");
        String apellido = sc.nextLine();

        Empleado empleado = new Empleado(nombre, apellido);

        if(agregarEmpleadoALaDB(empleado)){
            System.out.println("Se agregó a la DB: "+empleado);
        }else{
            System.out.println("No se pudo agregar a la db: "+empleado);
        }
    }

    private boolean agregarEmpleadoALaDB(Empleado empleado) {
        boolean respuesta = false;
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPWD);
        String nombre = empleado.getNombre();
        String apellido =empleado.getApellido();
        String sql = "INSERT INTO empleados (nombre, apellido) VALUES ('"+nombre
                +"','"+apellido+"');";

        try{

            conexionDB.insertar(sql);
            respuesta = true;

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("No se pudo agregar al empleado");
        }finally {
            conexionDB.cerrar();
        }
        return respuesta;
    }
}
