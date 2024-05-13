package com.mycompany.Clases;

public class Producto {
 private String id_producto;
 private String nombre;
 private int cantidad;
 private int stock_minimo;
 private String ubicacion;
 private String almacen;

    public Producto(String id_producto, String nombre, int cantidad, int stock_minimo, String ubicacion, String almacen) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.stock_minimo = stock_minimo;
        this.ubicacion = ubicacion;
        this.almacen = almacen;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getStock_minimo() {
        return stock_minimo;
    }

    public void setStock_minimo(int stock_minimo) {
        this.stock_minimo = stock_minimo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id_producto='" + id_producto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", stock_minimo=" + stock_minimo +
                ", ubicacion='" + ubicacion + '\'' +
                ", almacen='" + almacen + '\'' +
                '}';
    }
}
