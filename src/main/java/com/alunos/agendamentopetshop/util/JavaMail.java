/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.alunos.agendamentopetshop.util;

import com.alunos.agendamentopetshop.model.entidades.Agendamento;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class JavaMail {
    private static JavaMail instance;

    public static JavaMail getInstance() {
        if (instance == null) {
            instance = new JavaMail();
        }
        return instance;
    }

    public void enviarEmail(Agendamento agende, int n) {
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("petpalacy@gmail.com", "2018palacy");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("petpalacy@gmail.com")); //Remetente

            if (n == 1) {
                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse(agende.getServico().getEmpresa().getEmail());

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Solicitação de Agendamento");//Assunto
                message.setText("O clinte " + agende.getCliente().getNome() + " solicitou o agendamento"
                        + " do serviço " + agende.getServico().getNome() + " para a data " + agende.getData()
                        + " e hora " + agende.getHora() + "!!!");
            }
            if (n == 2) {
                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse(agende.getCliente().getEmail());

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Resposta a Pedido de Agendamento");//Assunto
                message.setText("A sua solicitação de Agendamento foi " + agende.getStatusAgen() + "!!!");
            }

            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);
            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
