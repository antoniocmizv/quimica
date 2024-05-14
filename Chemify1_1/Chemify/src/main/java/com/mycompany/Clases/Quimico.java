package com.mycompany.Clases;


import org.openxmlformats.schemas.spreadsheetml.x2006.main.STIconSetType;

import java.util.ArrayList;

public class Quimico extends Producto {
    private String pureza;
    private String fecha_caducidad;
    private String formato;
    private String riesgo;
    private ArrayList<Pictograma> pictogramas = new ArrayList<Pictograma>();

    public Quimico(String id_producto, String nombre, int cantidad, int stock_minimo, String ubicacion, String almacen
            ,int id_almacen,int id_ubicacion,String pureza, String fecha_caducidad, String formato,String riesgo) {

        super(id_producto, nombre, cantidad, stock_minimo, ubicacion, almacen,id_almacen,id_ubicacion);
        this.pureza = pureza;
        this.fecha_caducidad = fecha_caducidad;
        this.formato = formato;
        this.riesgo = riesgo;
        this.pictogramas = obtenerPictos(riesgo);
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

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getRiesgo() {
        return riesgo;
    }
    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public ArrayList<Pictograma> getPictogramas() {
        return pictogramas;
    }

    public void setPictogramas(ArrayList<Pictograma> pictogramas) {
        this.pictogramas = pictogramas;
    }

    public static ArrayList<Pictograma> obtenerPictos(String riesgos){
        ArrayList<Pictograma> pictogramas = new ArrayList<Pictograma>();
        riesgos = riesgos.toLowerCase();
        String[] nombreRiesgos = riesgos.split(",");
        //elimino los espacios en blanco
        for (int i = 0; i < nombreRiesgos.length; i++) {
            nombreRiesgos[i] = nombreRiesgos[i].trim();
        }
        for (String riesgo: nombreRiesgos) {
            switch (riesgo){
               case "comburente"
                     -> {
                     pictogramas.add(new Pictograma(1, "comburente", "comburente.png"));
                }
                case "corrosivo"
                     -> {
                     pictogramas.add(new Pictograma(2, "corrosivo", "corrosivo.png"));
                }
                case "toxicidad aguda"
                     -> {
                     pictogramas.add(new Pictograma(3, "toxicidad aguda", "toxicidad_aguda.png"));
                }
                case "peligroso para el medio ambiente"
                     -> {
                     pictogramas.add(new Pictograma(4, "peligroso para el medio ambiente",
                             "peligroso-ambiente.png"));
                }
                case "carcinógeno"
                     -> {
                     pictogramas.add(new Pictograma(5, "carcinógeno", "carcinogeno.png"));
                }
                case "inflamable"
                     -> {
                     pictogramas.add(new Pictograma(6, "inflamable", "inflamable.png"));
                }
                case "gases a presión"
                     -> {
                     pictogramas.add(new Pictograma(7, "gases a presión", "gas.png"));
                }
                case "riesgo biológico"
                     -> {
                     pictogramas.add(new Pictograma(8, "riesgo biológico", "biologico.png"));
                }
                case "nocivo"
                     -> {
                     pictogramas.add(new Pictograma(9, "nocivo", "nocivo.png"));
                }
                case "irritante"
                     -> {
                     pictogramas.add(new Pictograma(10, "irritante", "nocivo.png"));
                }
            }
        }
        return pictogramas;
    }

    @Override
    public String toString() {
        return "Quimico{" +
                "pureza='" + pureza + '\'' +
                ", fecha_caducidad='" + fecha_caducidad + '\'' +
                ", formato='" + formato + '\'' +
                ", riesgo='" + riesgo + '\'' +
                '}';
    }
}
