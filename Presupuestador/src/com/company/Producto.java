package com.company;

public class Producto extends Elemento implements Item{
    //Cada producto tiene una cantidad, un precio unitario, un nombre y una descripcion.


    private Integer cantidad;
    private Double precio;
    private Double total;

    public Producto( String nombre, String descripcion, Double precio, int cantidad){
        super(nombre,descripcion);
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String nombre, String descripcion, Double precio){
        super(nombre, descripcion);
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public Double calcularTotal() {
        return cantidad*precio;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalle del producto: "+nombre);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Cantidad: "+cantidad);
        System.out.println("Precio:"+precio);
        total = calcularTotal();
        System.out.println("Total del producto: "+total);
        System.out.println();
    }

}
