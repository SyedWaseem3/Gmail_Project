package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class customerauthentication extends Authenticator {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(MailMetaData.myUserMail, MailMetaData.myPass);


    }
}