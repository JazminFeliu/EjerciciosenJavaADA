package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

public class SistemaPremios {

    private List<Usuario> empleados = new LinkedList<>();

    public void registrarNuevoUsuario(){
        String nombre = Utilitaria.getString("Ingrese el nombre");
        String legajo = Utilitaria.getString("Ingrese el legajo");

        try {
            Usuario usuario = new Usuario(nombre, legajo);
            agregarUsuarioALIsta(usuario);
        }catch (DatosIncorrectosException e){
            System.out.println("No se pudo cargar el empleado."+e.getMessage());
        }

    }

    private void agregarUsuarioALIsta(Usuario usuario) {
        empleados.add(usuario);
    }


    public void listarUsuarios(){
        for(Usuario u:empleados){
            System.out.println(u.toString());
        }

    }

}
