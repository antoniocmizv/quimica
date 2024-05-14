package com.mycompany.Clases.objetos;

public class Materiales extends Producto {
    private String subtipo;
    private String descripcion;
    private String fecha_compra;
    private String numero_serie;


    public Materiales(String id_producto, String nombre, int cantidad, int stock_minimo, String ubicacion,
                      String almacen, int id_almacen, int id_ubicacion, String tipo, String descripcion, String fecha_compra, String numero_serie) {
        super(id_producto, nombre, cantidad, stock_minimo, ubicacion, almacen, id_almacen, id_ubicacion);
        this.subtipo = tipo;
        this.descripcion = descripcion;
        this.fecha_compra = fecha_compra;
        this.numero_serie = numero_serie;

    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    @Override
    public String toString() {
        return "Materiales{" +
                "tipo='" + subtipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_compra='" + fecha_compra + '\'' +
                ", numero_serie='" + numero_serie + '\'' +
                '}';
    }
}
