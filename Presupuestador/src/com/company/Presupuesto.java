package com.company;

import java.util.*;

public class Presupuesto {

    private List<Item> items;
    private Usuario usuario;
    private Double totalPresupuesto;
    private Boolean isSum = false;
    private Scanner scanner = new Scanner(System.in);


    public Presupuesto(Usuario usuario){
        this.usuario  = usuario;
        this.totalPresupuesto = 0.0;
        items  = new ArrayList<>();
    }

    public void armarPresupuesto(){

        System.out.println("Se ha creado un nuevo presupuesto, por favor ingrese los items que quiere presupuestar.");

        int op = 0;

        do{
            System.out.println("\n Menú: \n");
            System.out.println("1- Agregar Item");
            System.out.println("2 - Modificar Item ");
            System.out.println("3- Eliminar Item");
            System.out.println("4 - Mostrar presupuesto final");
            System.out.println("0 - Salir");
            System.out.println("Ingrese la opcion deseada: ");

           op = scanner.nextInt();

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
                    mostrarPresupuesto();
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

        Producto unProducto = new Producto("Cuaderno", "A4 Rallado", 150.00);

        System.out.println("Producto Cuaderno A4 Rallado");
        System.out.println("Ingrese la cantidad deseada: ");
        int cantidad = scanner.nextInt();

        unProducto.setCantidad(cantidad);
        agregarItem(unProducto);
        scanner.nextLine();

        Producto unProducto1 = new Producto("Termo 1.5 Lt", "Stanley Acer. Inox. Verde", 1000.00);

        System.out.println("Producto Termo 1.5 Lt Stanley Acer. Inox. Verde");
        System.out.println("Ingrese la cantidad deseada: ");
        cantidad = scanner.nextInt();

        unProducto1.setCantidad(cantidad);
        agregarItem(unProducto1);
        scanner.nextLine();

        agregarItem(new Servicio("Clase particular", "Informática I y II",500.0,4,"Pablo"));

        System.out.println("Servicio Clase Particular de Informática I y II");
        System.out.println("Se han cargado 4 hs del Servicio, clase de Informática");
    }

    public void mostrarPresupuesto() {

        List<Item> items = getItems();

        System.out.println();
        System.out.println("### Presupuesto perteneciente al usuario: "+usuario.getNombre()+" ###");
        System.out.println();

        if (isSum){
            totalPresupuesto = 0.0;
        }

        for (int i = 0; i<items.size(); i++){
            items.get(i).mostrarDetalles();
            this.totalPresupuesto += items.get(i).calcularTotal();
        }
        System.out.println("*********>>>> TOTAL del presupuesto: $ "+totalPresupuesto);
        isSum = true;
    }

    private void eliminarElemento() {

        List<Item> items = getItems();

        System.out.println(" *** LISTA DE ITEMS PRESUPUESTADOS ***");

        for (int i = 0; i< items.size(); i++){
            System.out.println("Item nro.:  "+ i);
            items.get(i).mostrarDetalles();

        }
        System.out.println("Ingrese el nro. de item que quiere eliminar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        Item unItem = items.get(indice);

        if(unItem instanceof Producto){
            Producto producto = (Producto) unItem;
            eliminarItem(producto);
            System.out.println("El producto ha sido eliminado.");

        }else{
            Servicio servicio = (Servicio) unItem;
            eliminarItem(servicio);
            System.out.println("El servicio ha sido eliminado.");
        }
    }

    private void modificarElemento() {

        List<Item> items = getItems();

        System.out.println(" *** LISTA DE ITEMS PRESUPUESTADOS ***");

        for (int i = 0; i< items.size(); i++){
            System.out.println("Item nro.:  "+ i);
            items.get(i).mostrarDetalles();
        }

        System.out.println("Ingrese el nro. de item que quiere modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();

        Item unItem = items.get(indice);

        if(unItem instanceof Producto){
            Producto producto = (Producto) unItem;

            System.out.println("Ingrese la nueva cantidad: ");
            int cantidad = scanner.nextInt();

            scanner.nextLine();
            producto.setCantidad(cantidad);

            producto.calcularTotal();

            reemplazarItem(indice, producto);

            System.out.println("El producto ha sido reemplazado con éxito.");

        }else{
            Servicio servicio = (Servicio) unItem;

            System.out.println("Ingrese la nueva cantidad: ");
            int cantidad = scanner.nextInt();

            scanner.nextLine();
            servicio.setCantidad(cantidad);

            servicio.calcularTotal();

            reemplazarItem(indice, servicio);

            System.out.println("El servicio ha sido reemplazado con éxito.");
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

    public Double getTotalPresupuesto(){
        return totalPresupuesto;
    }
}
