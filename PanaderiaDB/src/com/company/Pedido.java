package com.company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

public class Pedido {

    private int idPedido;
    private int total;
    private HashMap<Integer, Integer> productosPorPedido;
    private static final String dbName = "panaderia";
    private static final String dbUser = "root";
    private static final String dbPWD = "root";
    private Estado estado;

    public Pedido(HashMap<Integer, Integer> productosPorPedido) {
        this.productosPorPedido = productosPorPedido;
        this.total = calcularTotal();
        crearPedido();
        productosPorPedido.forEach(this::crearProductosPorPedido);
       // productosPorPedido.forEach(k,v) -> crearProductosPorPedido(k,v); otra forma de hacer lo mismo
    }

    public Pedido(int idPedido){
        String sql ="SELECT * FROM pedidos WHERE idPedido = ?";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setInt(1, idPedido);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                this.idPedido = idPedido;
                this.estado = Estado.values()[rs.getInt("estado")];
                this.total = rs.getInt("total");
                cargarProductosPorPedido();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }
    }

    private void crearProductosPorPedido(Integer idProducto, int cantidad) {
        String sql = "INSERT INTO productosxpedido (idPedido, idProducto, cantidad) VALUES (?,?,?);";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setInt(1, idPedido);
            pstmt.setInt(2, idProducto);
            pstmt.setInt(3, cantidad);
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }
    }

    private void cargarProductosPorPedido(){
        productosPorPedido = new HashMap<>();
        String sql = "SELECT idProducto, cantidad FROM productosxpedido WHERE idPedido = ?;";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setInt(1, idPedido);
            ResultSet rs = pstmt.executeQuery();
            if(rs != null)
                while (rs.next())
                    productosPorPedido.put(
                            rs.getInt("idProducto"),
                            rs.getInt("cantidad"));
            }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }


    private void crearPedido() {
        String sql = "INSERT INTO pedidos (total, estado) VALUES (?,?);";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setInt(1, total);
            pstmt.setInt(2, Estado.CONFIRMADO.ordinal());
            this.idPedido = conexionDB.ejecutarRetornarKey();
            this.estado = Estado.CONFIRMADO;
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }
    }

    private int calcularTotal() {
        int total = 0;
        for(Integer idProducto :productosPorPedido.keySet()){
            total += ProductoDAO.getPrecio(idProducto)*productosPorPedido.get(idProducto);
        }
        return total;
    }


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public HashMap<Integer, Integer> getProductosPorPedido() {
        return productosPorPedido;
    }

    public void setProductosPorPedido(HashMap<Integer, Integer> productosPorPedido) {
        this.productosPorPedido = productosPorPedido;
    }

    public String verDetalles() {
        String detalles = "Pedido: "+idPedido+"'\n";
        int total = 0;
        for(Integer idProducto: productosPorPedido.keySet()){
            Producto p = ProductoDAO.getProducto(idProducto);
            int cantidad = productosPorPedido.get(idProducto);
            int subtotal = cantidad*p.getPrecio();
            total +=subtotal;
            detalles += p.getNombre() + " : "+ cantidad +" x $"+p.getPrecio()+" = $"+subtotal+"\n";
        }
        detalles +="Total: $"+total;
        return  detalles;
    }

    public int pagar(int pago){
        actualizarEstado(Estado.PAGO);
        return pago-total;
    }

    private void actualizarEstado(Estado estado) {
        String sql ="UPDATE pedidos SET estado = ? WHERE idPedido = ?;";
        ConexionDB conexionDB = new ConexionDB(dbName, dbUser, dbPWD, sql);
        PreparedStatement pstmt = conexionDB.getPstmt();
        try {
            pstmt.setInt(1, estado.ordinal());
            pstmt.setInt(2, idPedido);
            pstmt.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            conexionDB.cerrar();
        }
    }

    private void cancelarPedido(){
        actualizarEstado(Estado.CANCELADO);
    }
}


