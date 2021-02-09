package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    List<Item> items;
    String nombre;
    Boolean jubilado;
    LocalDate fechaNacimiento;

    public Cliente(List<Item>items){

    }

    public void agregarItem(int c, Producto p){
        items.add(new Item(c, p));
    }

    public Double calcularTotal(){
        Double total = 0.0;

        for (Item i:items)
            total +=i.getCantidad() * i.getProducto().getPrecioUnitario();

        if(jubilado){
            total -= total * 0.15;
        }
        if((fechaNacimiento.getDayOfYear() - LocalDate.now().getDayOfYear()) == 0)
            total -= total *0.10;
        return total;
    }

}
