package com.company;

import java.util.List;
import java.util.Scanner;

public class Presupuesto implements Item {

    private Usuario usuario;
    private Double subtotal;
    private Double total;
    private Menu menu;
    private Integer opcion;
    private List<Itemclass> listaDeItems;
    private Scanner sc;
    private Itemclass item;
    private boolean isNext;


    public Presupuesto() {

        menu = new Menu();
        subtotal = 0.0;
        total = 0.0;
        this.listaDeItems = usuario.getListaDeItems();
        sc = new Scanner(System.in);
        item = new Itemclass();
        isNext = true;

    }

    public void elegirOpcion() {
        System.out.println("Solicitud de presupuesto, por favor elija una opción: ");
        System.out.println("1 - Agregar un item al presupuesto.");
        System.out.println("2 - Modificar un item.");
        System.out.println("3 - Eliminar un item.");
        System.out.println("4- Mostrar detalle del presupuesto.");
        System.out.println("5 - Finalizar carga");
        System.out.println("6 - Salir");

        Scanner sc = new Scanner(System.in);
        opcion = sc.nextInt();

        while (isNext) {
            String opcionElegida = menu.elegirOpcionMenu(opcion);
            System.out.println("Usted eligio la opcion: " + opcionElegida);
            armarPresupuesto(opcion);
        }
    }

    @Override
    public void armarPresupuesto(Integer opcion){

            switch (opcion){
                case 1:
                    System.out.println("Cantidad items: "+listaDeItems.size()+"elija uno:");
                    opcion = sc.nextInt();
                    this.item = listaDeItems.get(opcion);
                    agregarItem(item);
                    break;
                case 2: modificarItem( item);
                    break;
                case 3: eliminarItem( item);
                    break;
                case 4: mostrarDetallePresupuesto();
                    break;
                case 5:
                    System.out.println("Gracias por usar el presupuestador.");
                    mostrarDetallePresupuesto();
                    isNext = false;
                    break;
            }
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

    private void listarServicio(Itemclass item, Double subtotal){
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

}
