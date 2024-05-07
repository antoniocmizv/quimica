package org.clases.Clases;

public class Quimico extends Producto {
    private String pureza;
    private String fecha_caducidad;

    public Quimico(String id_producto, String nombre, int cantidad, int stock_minimo, String ubicacion, String almacen
            , String pureza, String fecha_caducidad) {

        super(id_producto, nombre, cantidad, stock_minimo, ubicacion, almacen);
        this.pureza = pureza;
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getPureza() {
        return pureza;
    }

    public void setPureza(String pureza) {
        this.pureza = pureza;
    }

    public String getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(String fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    @Override
    public String toString() {
        return STR."Quimico{pureza='\{pureza}\{'\''}, fecha_caducidad='\{fecha_caducidad}\{'\''}\{'}'}";
    }
}
