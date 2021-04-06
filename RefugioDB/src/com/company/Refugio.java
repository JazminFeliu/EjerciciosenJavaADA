package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Refugio {

    private Boolean isMenu = true;
    Scanner scanner = new Scanner(System.in);
    Integer opcion;

    private String dbName = "refugio";
    private String dbUser = "root";
    private String dbPWD = "root";


    public void iniciarMenu() {
        System.out.println();
        System.out.println("Bienvenido al refugio de animales!! ");
        System.out.println();
        do{
            System.out.println("1) Ingresar nuevo animal");
            System.out.println("2) Establecer edad");
            System.out.println("3) Listar a todos los animales");
            System.out.println("4) Buscar animal segun ESPECIE");
            System.out.println("0) Salir");
            System.out.println();
            System.out.print("Ingrese una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion){
                case 1: ingresarAnimal();
                break;

                case 2: establecerEdad();
                break;

                case 3: listarTodosAnimales();
                break;

                case 4: buscarPorEspecie();
                break;

                case 0:
                    System.out.println("Gracias por utilizar el sistema");
                    isMenu = false;
                    break;

                default:
                    System.out.println("Ingrese una opción correcta.");
            }

        }while (isMenu);

    }

    private void ingresarAnimal() {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);

        Animal animal = new Animal();
        System.out.println("Ingrese el nombre del animal: ");
        animal.setNombre(scanner.nextLine());

        System.out.println("Ingrese la especie: (PERRO/GATO/CABALLO/BALLENA/TORTUGA)");
        animal.setEspecie(Especie.valueOf(scanner.nextLine()));

        System.out.println("Ingrese la edad: ");
        animal.setEdad(Integer.parseInt(scanner.nextLine()));

        String nombre = animal.getNombre();
        Integer edad = animal.getEdad();
        Especie especie = animal.getEspecie();

        String sql = "INSERT INTO tareas ( nombre, especie, edad) VALUES " +
                "('" + nombre + "','" + especie +  "','" + edad + "');";

        try {
            conexionDB.ejecutar(sql);

        } catch (SQLException e) {
            System.out.println("No se pudo agregar la tarea");
        } finally {
            conexionDB.cerrar();
        }

    }

    private void buscarPorEspecie() {
        System.out.println("Ingrese la especie que quiere consultar: 0) PERRO, 1) GATO, 2) TORTUGA, 3) CABALLO, 4)BALLENA;");
        String especie = Especie.values()[Integer.parseInt(scanner.nextLine())].name();
        buscarYMostrarEnDB("SELECT * FROM animales WHERE especie LIKE '%"+ especie+"%'");
    }

    private void listarTodosAnimales() {
        buscarYMostrarEnDB("SELECT * FROM animales;");
    }

    private void establecerEdad() {
        System.out.println("Ingrese el id del animal: ");
        Integer idElegido = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese la edad que quiere establecer: ");
        Integer edad = Integer.parseInt(scanner.nextLine());
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        String sql = "UPDATE animales SET edad = '"+edad+"' WHERE (ID = "+idElegido+");";

        try {
            conexionDB.ejecutar(sql);

        } catch (SQLException e) {
            System.out.println("No se pudo actualizar la edad");
        } finally {
            conexionDB.cerrar();
        }
    }

    public void buscarYMostrarEnDB(String sql) {
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD);
        ResultSet rs = conexionDB.consultar(sql);
        try {
            mostrarResultadosPOO(rs);
        } catch (SQLException e) {
            System.out.println("No se econtraron resultados");
        } finally {
            conexionDB.cerrar();
        }
    }


    private void mostrarResultadosPOO(ResultSet resultados) throws SQLException {
        if (resultados != null)
            while (resultados.next())
                System.out.println(
                        new Animal(
                                resultados.getInt("id"),
                                resultados.getString("nombre"),
                                Especie.valueOf(resultados.getString("especie")),
                                resultados.getInt("edad")
                        )
                );
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
