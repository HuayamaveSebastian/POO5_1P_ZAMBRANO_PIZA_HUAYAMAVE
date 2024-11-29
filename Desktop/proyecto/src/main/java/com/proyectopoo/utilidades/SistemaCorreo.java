package com.proyectopoo.utilidades;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import io.github.cdimascio.dotenv.Dotenv;

public class SistemaCorreo {

    static Session session;

    static String host;
    static String port;
    static String user;
    static String pass;

    /**
     * Inicializar la sesion de mails y las variables de entorno
     */
    public static void init()
    {
        Dotenv dot = Dotenv.load(); // Iniciar el entorno

        // Variables de entorno
        host = dot.get("MAIL_HOST");
        port = dot.get("MAIL_PORT");
        user = dot.get("MAIL_USER");
        pass = dot.get("MAIL_PASS");

        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);

        session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(user, pass);
            }
        });
    }

    /**
     * Metodo util para generar correos 
     */
    public static void generarCorreo(String remitente, String destinatario, String tema,String mensaje)
    {
        if (session == null)
            return;

        System.out.println("Notificando a los administradores via mail");

        try {
            Message mes = new MimeMessage(session);
            mes.setFrom(new InternetAddress(user,"SISTEMA DE RESERVAS"));
            mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse("josrzamb@espol.edu.ec")); // Se envia todo a ese correo
            mes.setSubject(tema);
            mes.setText(mensaje);
            Transport.send(mes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }   
    }
}
