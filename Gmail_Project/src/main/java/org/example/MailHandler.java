package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

    void sendMail(){

        Properties systemProperties= System.getProperties(); //hashmap
        System.out.println(systemProperties);
        systemProperties.put("mail.smtp.host", MailMetaData.HostServer);
        systemProperties.put("mail.smtp.port", MailMetaData.port);
        systemProperties.put(MailMetaData.sslProperty, "true");
        systemProperties.put(MailMetaData.authPerm, "true");

        Authenticator mailAuthenticator= new customerauthentication();
        Session mailSession= Session.getInstance(systemProperties, mailAuthenticator);


        MimeMessage mailMessage= new MimeMessage(mailSession);
        try {
            mailMessage.setFrom(MailMetaData.myUserMail);
            mailMessage.setSubject("Assignment 3 Submission");

            mailMessage.setText("Hello this side is Waseem");

            Address receiverEmail = new InternetAddress(MailMetaData.receiverMail);
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(MailMetaData.receiverMail));

            Transport.send(mailMessage);

        }
        catch(Exception mailException){
            System.out.println(mailException.toString());
        }
    }
}