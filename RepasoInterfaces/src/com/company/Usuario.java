package com.company;

import java.util.LinkedList;
import java.util.List;

public class Usuario extends Persona implements Item {

    public Double subtotal = 0.0;
    public Double total = 0.0;
    public List<Itemclass> listaDeItems = new LinkedList<>();

    public Usuario(String nombre) {
        super(nombre);
    }
    public Usuario(){

    }

    @Override
    public void agregarItem(Itemclass item) {
        listaDeItems.add(item);
    }

    @Override
    public void mostrarDetallePresupuesto() {

        System.out.println("Detalle del presupuesto: ");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < listaDeItems.size(); i++) {

            this.subtotal = listaDeItems.get(i).precio * listaDeItems.get(i).cantidadItem;
            this.total += subtotal;
            if (listaDeItems.get(i).tipoItem == "p"){
                listarProducto(listaDeItems.get(i), subtotal);
            } else {
                listarServicio(listaDeItems.get(i), subtotal);
            }
            System.out.println("----------------------------------------------------------------");

        }
        System.out.println("Total presupuestado: "+total);
    }

    private void listarProducto(Itemclass item, Double subtotal){
        System.out.println("Producto: "+item.nombre);
        System.out.println("Descripcion: "+item.descripcion);
        System.out.println("Cantidad presupuestada: "+item.cantidadItem);
        System.out.println("Precio Unitario: "+item.precio);
        System.out.println("Subtotal: "+subtotal);
    }

    public void listarServicio(Itemclass item, Double subtotal){
        System.out.println("Servicio: "+item.nombre);
        System.out.println("Descripcion: "+item.descripcion);
        System.out.println("Profesional: "+item.nombreProfesional);
        System.out.println("Cantidad de Horas: "+item.cantidadItem);
        System.out.println("Precio por hora: "+item.precio);
        System.out.println("Subtotal: "+subtotal);

    }

    @Override
    public void modificarItem(Itemclass item) {

    }

    @Override
    public void eliminarItem(Itemclass item) {

    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getTotal() {
        return total;
    }

    public List<Itemclass> getListaDeItems() {
        return listaDeItems;
    }
}
