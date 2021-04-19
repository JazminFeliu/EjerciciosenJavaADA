package com.company;

public class Promo {

    private String nombrePromo;
    private Integer descuento; //es un monto de descuento, no un porcentaje

    public Promo(String nombrePromo, Integer descuento){
        this.nombrePromo = nombrePromo;
        this.descuento = descuento;
    }

    public String getNombrePromo(){
        return nombrePromo;
    }

    public void setNombrePromo(String nombrePromo){
        this.nombrePromo = nombrePromo;
    }

    public Integer getDescuento(){
        return descuento;
    }

    public void setDescuento(Integer descuento){
        this.descuento = descuento;
    }
}
