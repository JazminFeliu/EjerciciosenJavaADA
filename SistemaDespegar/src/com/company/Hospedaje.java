package com.company;

public abstract class Hospedaje implements Reservable, LowCost{

    @Override
    public void informarPrecio(){
        LowCost.super.informarPrecio();
    }
}
