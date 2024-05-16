package com.mycompany.Clases;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SendWhatsAppMessage {
    public static final String ACCOUNT_SID = "AC647ec51889f203aac21ab060bba4657a";
    public static final String AUTH_TOKEN = "2d52c48bf671613e99ce897dd61fae3d";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber("whatsapp:+34667032610"),
                        new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                        "hola mario").create();
        System.out.println("Mensaje enviado exitosamente!");
    }


}
