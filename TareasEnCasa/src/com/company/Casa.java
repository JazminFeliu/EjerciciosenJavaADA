package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Casa {

    private Scanner scanner = new Scanner(System.in);
    private String dbName = "casa";
    private String dbUser = "root";
    private String dbPWD = "root";
    private Boolean isMenu = true;


    public void iniciarMenu() {
        do{
            System.out.println();
            System.out.println("MENU DE TAREAS");
            System.out.println("1) Ver todas las tareas.");
            System.out.println("2) Ver todas las tareas PENDIENTES.");
            System.out.println("3) Ver todas las tareas de una persona en particular.");
            System.out.println("4) ver todas las tareas PENDIENTES de una persona en particular.");
            System.out.println("5) Agregar una nueva tarea.");
            System.out.println("6) Cambiar el estado de una tarea.");
            System.out.println("7) Cancelar una tarea.");
            System.out.println("0) Salir.");
            System.out.print("Elija una opcion: ");

            Integer opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1: listarTareas();
                break;

                case 2: listarTareasPendientes();
                break;

                //case 3: listarTareasPorResponsable();
                //break;

                //case 4: listarPendientesPorResponable();
                //break;

                case 5: agregarTarea(new Tarea());
                break;

                //case 6: cambiarEstadoDeTarea(int id, int idEstado);
                //break;

                case 7: cancelarTarea();
                break;

                case 0:
                    System.out.println("Gracias por utilizar el sistema de Tareas");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Ingrese una opcion correcta");
            };

        }while(isMenu);

    }

    private void cancelarTarea() {
    }

    public void cambiarEstadoDeTarea(Integer id, Integer idEstado) {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        String estado = Estado.values()[idEstado].name();
        String sql = "UPDATE tareas SET estado = '"+estado+"' WHERE (ID = "+id+");";

        try {
            conexionDB.ejecutar(sql);

        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el estado");
        } finally {
            conexionDB.cerrar();
        }

    }

    private void listarPendientesPorResponable(String responsable) {

        buscarYMostrarEnDB("SELECT * FROM tareas WHERE estado = 'PENDIENTE' AND responsable = '"+ responsable+"'");
    }

    public void listarTareasPorResponsable(String responsable) {

        buscarYMostrarEnDB("SELECT * FROM tareas WHERE responsable = '"+ responsable+"'");
    }

    private void listarTareasPendientes() {
    }


    public void listarTareas() {
        buscarYMostrarEnDB("SELECT * FROM tareas;");
    }

    public void buscarYMostrarEnDB(String sql) {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        ResultSet rs = conexionDB.consultar(sql);
        try {
            mostrarResultados(rs);
        } catch (SQLException e) {
            System.out.println("No se econtraron resultados");
        } finally {
            conexionDB.cerrar();
        }
    }

    public void mostrarTareaPorID(int id) {

        buscarYMostrarEnDB("SELECT * FROM tareas WHERE ID = " + id);
    }


    private void mostrarResultados(ResultSet rs) throws SQLException {
        if (rs != null)
            while (rs.next())
                System.out.println("Nombre: " + rs.getString("nombre")+" - "+rs.getString("responsable"));
    }

    public boolean agregarTarea(Tarea tarea) {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        String nombre = tarea.getNombre();
        String descripcion = tarea.getDescripcion();
        String responsable = tarea.getResponsable();
        String estado = tarea.getEstado().name();

        String sql = "INSERT INTO tareas (nombre, descripcion, responsable, estado) VALUES " +
                "('" + nombre + "','" + descripcion + "','" + responsable + "','" + estado + "');";

        boolean respuesta = false;

        try {
            respuesta = conexionDB.ejecutar(sql);

        } catch (SQLException e) {
            System.out.println("No se pudo agregar la tarea");
        } finally {
            conexionDB.cerrar();
        }
        return respuesta;
    }
}
