package com.mycompany.Clases;

import java.util.ArrayList;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.mycompany.ConexionSQL.Conexion;

public class EnvioCorreo {
    public static void main(String[] args) {
        // Ejemplo de cómo utilizar la función de enviar alerta de stock
        enviarAlertaStock("lasenololy@gmail.com", "Alerta de Stock",
                "El producto X tiene un nivel de stock bajo.");
    }

    public static void enviarAlertaStock(String destinatario, String asunto, String mensaje) {

        // Configuración de las propiedades del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Autenticación del usuario y contraseña del servidor de correo
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("chemify100@gmail.com", "qnhf rylk pync eytu");
                // Reemplaza con tu correo y contraseña de Gmail
            }
        });

        try {
            // Creación del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("chemify100@gmail.com")); // Reemplaza con tu correo electrónico
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario)); // Correo del destinatario
            message.setSubject(asunto); // Asunto del correo
            message.setText(mensaje); // Contenido del correo

            // Envío del mensaje
            Transport.send(message);

            System.out.println("Correo electrónico enviado con éxito.");

        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar el correo electrónico.", e);
        }
    }

    //obtener el correo del usuario de la base de datos
    public static ArrayList<String> obtenerCorreosUsuarios() {
        ArrayList<String> correos = new ArrayList<String>();
        // Aquí se realizaría la consulta a la base de datos para obtener los correos de los usuarios
        // y se agregarían a la lista de correos
        correos = Conexion.obtenerCorreosUsuarios();
        return correos;
    }

    public static void enviarAlertaStockProductos(String mensaje) {

        for (String correo : obtenerCorreosUsuarios()) {
            enviarAlertaStock(correo, "Alerta de Stock", mensaje);
        }
    }

}
