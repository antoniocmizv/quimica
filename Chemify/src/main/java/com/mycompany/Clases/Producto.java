package com.mycompany.Clases;

import com.mycompany.ConexionSQL.Conexion;

public class Producto implements Comparable ,metodosProducto {
    private String id_producto;
    private String nombre;
    private int cantidad;
    private int stock_minimo;
    private String ubicacion;
    private String almacen;
    private int id_almacen;
    private int id_ubicacion;

    public Producto(String id_producto, String nombre, int cantidad, int stock_minimo, String ubicacion,
                    String almacen, int id_almacen, int id_ubicacion) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.stock_minimo = stock_minimo;
        this.ubicacion = ubicacion;
        this.almacen = almacen;
        this.id_almacen = id_almacen;
        this.id_ubicacion = id_ubicacion;
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

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
    }

    public int getId_ubicacion() {
        return id_ubicacion;
    }

    public void setId_ubicacion(int id_ubicacion) {
        this.id_ubicacion = id_ubicacion;
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

    @Override
    public int compareTo(Object o) {
        Producto p = (Producto) o;
        //comparo los productos por su nombre
        return this.nombre.compareTo(p.getNombre());

    }

    @Override
    public void modificar(Producto p) {
        this.nombre = p.getNombre();
        this.cantidad = p.getCantidad();
        this.stock_minimo = p.getStock_minimo();
        this.ubicacion = p.getUbicacion();
        this.almacen = p.getAlmacen();
        this.id_almacen = p.getId_almacen();
        this.id_ubicacion = p.getId_ubicacion();

        Conexion.modificarProducto(this);
    }
}
