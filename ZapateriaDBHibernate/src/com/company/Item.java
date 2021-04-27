package com.company;

import javax.persistence.*;

@Entity
@Table(name ="items")
public class Item {

    @Id
    private int id;
    private int idFactura;
    @OneToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;
    private int cantidad;
    private int precioSubTotal;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioSubTotal() {
        return precioSubTotal;
    }

    public void setPrecioSubTotal(int precioSubTotal) {
        this.precioSubTotal = precioSubTotal;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", idFactura=" + idFactura +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", precioSubTotal=" + precioSubTotal +
                '}';
    }
}
