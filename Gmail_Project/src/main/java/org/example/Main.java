package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting to Send out mails");

        MailHandler mailHandler=new MailHandler();
        mailHandler.sendMail();

    }

}