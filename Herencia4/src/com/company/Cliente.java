package com.company;

public class Cliente {

    private Double montoPrestado;
    private String categoria;
    private Double montoDevuelto;

    public Cliente(String categoria) {
        this.categoria = categoria;
        montoPrestado = 0.00;
        montoDevuelto = 0.00;
    }

    public String getCategaoria() {
        return categoria;
    }

    public void setCategaoria(String categaoria) {
        this.categoria = categaoria;
    }

    public void pedirPrestamo(Double monto){
     if((categoria.equals("riesgoso")&& monto <= 100) ||
             (categoria.equals("nuevo") && monto <= 200) ||
             (categoria.equals("confiable") && monto <= 500))
                 montoPrestado = monto;
    }

    public void realizarPago(Double monto){
        montoDevuelto += monto;
        if(montoDevuelto >= montoPrestado){
            categoria = "confiable";
        }
    }

    public Double consultarDeuda(){
        return montoPrestado - montoDevuelto;
    }
    public Double getMontoPrestado() {
        return montoPrestado;
    }
}


