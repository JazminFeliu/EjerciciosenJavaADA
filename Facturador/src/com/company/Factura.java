package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Double descuento;
    private List<Item> items;

    public Factura() {
        items = new ArrayList<>();
    }

    public Factura(List<Item> items){
        this.items = items;
        descuento = 0.00;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double consultarMontoSinDescuento() {
        Double montoTotal = 0.0;
        for(Item i: items)
            montoTotal +=i.getSubTotal();
        return montoTotal;
    }

    public Double consultarMontoFinal(){
        Double montoTotal = consultarMontoSinDescuento();
        montoTotal = montoTotal*1.21;
        if (descuento > 0){
        montoTotal = montoTotal - (montoTotal*descuento);
        }
        Math.round(montoTotal); //redondea al numero entero mas cercano
        Math.ceil(montoTotal); // redondea para arriba
        Math.floor(montoTotal); //redondea para abajo

        return Math.floor(montoTotal);
    }


    public void agregarItem(Item i) {
        items.add(i);
    }
}

