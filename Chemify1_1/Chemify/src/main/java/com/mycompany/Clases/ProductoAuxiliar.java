package com.mycompany.Clases;

public class ProductoAuxiliar extends Producto {
    private String formato;

    public ProductoAuxiliar(String id_producto, String nombre, int cantidad, int stock_minimo, String ubicacion,
                            String almacen, int id_almacen, int id_ubicacion,String formato) {
        super(id_producto, nombre, cantidad, stock_minimo, ubicacion, almacen, id_almacen, id_ubicacion);
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    @Override
    public String toString() {
        return "ProductoAuxiliar{" +
                "formato='" + formato + '\'' +
                '}';
    }
}
