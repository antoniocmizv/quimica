package org.clases.Clases;

public class Materiales extends Producto {
    private String tipo;
    private String descripcion;
    private String fecha_compra;
    private String numero_serie;


    public Materiales(String id_producto, String nombre, int cantidad, int stock_minimo, String ubicacion,
                      String almacen, String tipo, String descripcion, String fecha_compra, String numero_serie) {
        super(id_producto, nombre, cantidad, stock_minimo, ubicacion, almacen);
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha_compra = fecha_compra;
        this.numero_serie = numero_serie;

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        return STR."Materiales{tipo='\{tipo}\{'\''}, descripcion='\{descripcion}\{'\''}, fecha_compra='\{fecha_compra}\{'\''}, numero_serie='\{numero_serie}\{'\''}\{'}'}";
    }
}
