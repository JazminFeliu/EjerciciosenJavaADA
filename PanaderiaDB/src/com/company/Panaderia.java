package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Panaderia {

    public static void main(String[] args) {
	/*
	Crear un sistema de facturación de una panaderia.
	Se tiene una lista de productos con nombre, descripción y precio.
	Existen promos especiales por comprar una docena y media de facturas o por comprar 1kg de pan y 1 torta.
	Todos los meses salen nuevas promos.
	Cada cliente pide los productos que quiere llevar y hace fila en la caja para pagar.
	En la caja se atienden los clientes de a uno y se les cobra el total.
	Si abonan más de lo que se debe cobrar, se informa el vuelto.
	 */
        System.out.println("Bienvenidos a la Panaderia ONLINE!");

        List<Producto> productos = ProductoDAO.getProductos();
        for(Producto producto: productos)
            System.out.println(producto);

        int op=0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("¿Desea crear un nuevo pedido (1) o pagar (2) uno existente? Salir con O.");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1 -> crearNuevoPedido();
                case 2 -> pagar();
            }
        }while (op !=0);

    }
    private static void crearNuevoPedido() {
        int op=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nueva orden. Indique 0 para salir.");
        HashMap<Integer, Integer> productosPorPedido = new HashMap<>();
        do {
            System.out.print("Indique el ID de Producto: ");
            int idProd = Integer.parseInt(sc.nextLine());
            System.out.print("Indique la cantidad deseada: ");
            int cantidad = Integer.parseInt(sc.nextLine());
            productosPorPedido.put(idProd, cantidad);
            System.out.print("¿Desea finalizar? (1= No, 0=Si) ");
            op = Integer.parseInt(sc.nextLine());
        }while (op != 0);
        Pedido pedido = new Pedido(productosPorPedido);
        System.out.println("Pedido creado!");
        System.out.println(pedido.verDetalles());
    }

    private static void pagar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("ID del pedido: ");
        int idPedido = Integer.parseInt(sc.nextLine());
        Pedido pedido = new Pedido(idPedido);
        System.out.println(pedido.verDetalles());
        System.out.print("¿Esta ok? 1=SI, 0=No");
        if (Integer.parseInt(sc.nextLine()) == 1){
            System.out.print("¿Con cuanto abona? ");
            int pago = Integer.parseInt(sc.nextLine());
            int vuelto = pedido.pagar(pago);
            if(vuelto>0) System.out.println("Vuelto: $"+vuelto);
            System.out.println("Listo!");
        }
    }

}
