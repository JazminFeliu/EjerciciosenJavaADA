package com.company;

public class Cliente  {

    private String nombre;
    private String prioridad;

    public Cliente(String nombre, String prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    //@Override
    public int compareTo(Cliente cliente2){
        String otraPrioridad = cliente2.getPrioridad();
        if(this.prioridad.equals("particular"))
            return -1;
        return 0;
        /*
        caso1:
        if(this.prioridad.equals(otraPrioridad))

        caso2:
        this.prioridad.equals("particular")
        caso3:
        otraPrioridad.equals.("particular")

         */

    }

    private String getPrioridad() {
        return "";
    }
}
