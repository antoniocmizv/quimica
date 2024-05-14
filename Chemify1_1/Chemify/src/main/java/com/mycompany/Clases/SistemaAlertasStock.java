package com.mycompany.Clases;

import java.util.List;

import com.mycompany.Clases.objetos.Producto;
import com.mycompany.ConexionSQL.Conexion;

public class SistemaAlertasStock {

    // Función para verificar el nivel de stock y enviar alertas si es necesario
    public static void verificarStock() {
        List<Producto> productos = Conexion.obtenerProductos(); // Obtener la lista de productos desde la base de datos

        for (Producto producto : productos) {

            if (producto.getCantidad() < producto.getStock_minimo()) {
                // Enviar una alerta
                enviarAlertaStock(producto);
                System.out.println("Alerta de stock enviada para el producto: " + producto.getNombre());
            }
        }
    }

    // Función para enviar una alerta de stock
    private static void enviarAlertaStock(Producto producto) {

        String mensaje = "Alerta de stock: El producto " + producto.getNombre() + " tiene un nivel de stock bajo.";
        enviarCorreoElectronico("admin@example.com", "Alerta de Stock", mensaje);
    }

    // Función de ejemplo para enviar un correo electrónico
    private static void enviarCorreoElectronico(String destinatario, String asunto, String mensaje) {

        System.out.println("Correo electrónico enviado a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
    }


}
