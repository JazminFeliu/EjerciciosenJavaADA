package com.company;

import java.util.*;

public class Presupuesto {

    private List<Item> items;
    private Usuario usuario;
    private Double totalPresupuesto;
    private Presupuesto presupuesto;

    public Presupuesto(Usuario usuario){
        this.usuario  = usuario;
        this.totalPresupuesto = 0.0;
        items  = new ArrayList<>();
    }


    public void armarPresupuesto(Usuario usuario, Presupuesto presupuesto){

        System.out.println("Se ha creado un nuevo presupuesto, por favor ingrese los items que quiere presupuestar.");

        Scanner sc = new Scanner(System.in);

        int op = 0;

        do{
            System.out.println("\n Menú: \n");
            System.out.println("1- Agregar Item");
            System.out.println("2 - Modificar Item ");
            System.out.println("3- Eliminar Item");
            System.out.println("4 - Mostrar presupuesto final");
            System.out.println("0 - Salir");
            System.out.println("Ingrese la opcion deseada: ");

            op = sc.nextInt();

            switch (op){
                case 1:
                    agregarElemento();
                    break;
                case 2:
                    modificarElemento();
                    break;
                case 3:
                    eliminarElemento();
                    break;
                case 4:
                    mostrarPresupuesto(usuario, presupuesto);
                    break;
                case 0:
                    System.out.println("Gracias por utilizar el presupuestador");
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta");
                    break;
            }

        }while (op != 0);

    }

    private void agregarElemento() {
        Scanner sc = new Scanner(System.in);
        Producto unProducto = new Producto("Cuaderno", "A4 Rallado", 150.00);
        System.out.println("Producto Cuaderno A4 Rallado");
        System.out.println("Ingrese la cantidad deseada: ");
        int cantidad = sc.nextInt();
        unProducto.setCantidad(cantidad);
        agregarItem(unProducto);
        agregarItem(new Servicio("Plomero", "Arregla los caños",500.0,4,"Silvio"));
        List<Item> items = getItems();
        for (int i = 0; i<items.size(); i++){
            this.totalPresupuesto += items.get(i).calcularTotal();
        }
    }

    public void mostrarPresupuesto(Usuario usuario, Presupuesto presupuesto) {

        List<Item> items = getItems();

        System.out.println("Presupuesto perteneciente al usuario: "+usuario.getNombre());
        System.out.println("Total del presupuesto: $ "+totalPresupuesto);

    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    private void eliminarElemento() {

    }

    private void modificarElemento() {

        List<Item> items = getItems();

        int indice = 0;

        Item unItem = items.get(indice);

        if(unItem instanceof Producto){
            Producto coso = (Producto) unItem;
            //hacer cosas de productos
            coso.calcularTotal();
            reemplazarItem(indice, coso);
        }else{
            Servicio coso = (Servicio) unItem;
            //hacer cosas de servicios...
            reemplazarItem(indice, coso);
        }

        if(unItem.getClass().getSimpleName().equals("Producto")){
            //tengo un producto
        }else{
            //tengo un servicio
        }
    }


    public List<Item> getItems() {
        return items;
    }


    public void agregarItem(Item item) {
        items.add(item);

    }

    public void eliminarItem(Item item) {
        items.remove(item);

    }


    public void reemplazarItem(int indice, Item item) {
        items.set(indice, item);
    }

    @Override
    public String toString() {
        return "Presupuesto{" +
                "items=" + items +
                ", usuario=" + usuario +
                ", totalPresupuesto=" + totalPresupuesto +
                '}';
    }
}
