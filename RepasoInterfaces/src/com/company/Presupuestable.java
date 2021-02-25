package com.company;

public interface Presupuestable {



    default void agregarItem(Item item){

    }

    default void modificarItem(Item item){
    }


    default void eliminarItem(Item item){

    }

    default void armarPresupuesto(Integer opcion){

    }
    default void mostrarDetallePresupuesto(){

   }


}
