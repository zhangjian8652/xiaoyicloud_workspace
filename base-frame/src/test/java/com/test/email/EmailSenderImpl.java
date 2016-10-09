package com.test.email;


import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * author:zhangjian
 * date:2016-05-25
 * describe:
 **/
public class EmailSenderImpl implements EmailSender {

    private JavaMailSender mailSender;

    private static Properties settings;

    private static String DEFAULT_ENCODEING = "UTF-8";

    static {
        readResourceMailProperties();
    }


    public EmailSenderImpl() {

        if (settings == null) {
            throw new RuntimeException("must be an properties settings named email.properties at the class root path");
        }

        String host = settings.getProperty("mail.smtp.host");
        if (host == null || "".equals(host)) {
            throw new RuntimeException("mail.smtp.host is required in setting properties");
        }

        String username = settings.getProperty("mail.smtp.username");
        if (username == null || "".equals(username)) {
            throw new RuntimeException("mail.smtp.username is required in setting properties");
        }

        String password = settings.getProperty("mail.smtp.password");
        if (password == null || "".equals(password)) {
            throw new RuntimeException("mail.smtp.username is required in setting properties");
        }

        String encoding = settings.getProperty("mail.smtp.encoding");

        if (encoding == null || "".equals(encoding)) {
            DEFAULT_ENCODEING = encoding;
        }
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setDefaultEncoding(DEFAULT_ENCODEING);
        javaMailSender.setJavaMailProperties(settings);

        this.mailSender = javaMailSender;
    }

    @Override
    public boolean send(Email email) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        this.transferEmailToMimeMessage(mimeMessage, email);
        mailSender.send(mimeMessage);

        return true;
    }

    private void transferEmailToMimeMessage(MimeMessage mimeMessage, Email email) {
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true,
                    DEFAULT_ENCODEING);
            helper.setFrom(email.getFromAddress());

            helper.setSubject(email.getSubject());

            boolean hasToAddress = false;
            if (email.getToAddress() != null) {
                helper.setTo(email.getToAddress());
                hasToAddress = true;
            }

            if (email.getToAddresses() != null && email.getToAddresses().length > 0) {
                helper.setTo(email.getToAddresses());
                hasToAddress = true;
            }

            if(!hasToAddress){
                throw new RuntimeException("to address can not be null");
            }

            if (email.getCcAddress() != null) {
                helper.setCc(email.getCcAddress());
            }

            if (email.getCcAddresses() != null && email.getCcAddresses().length > 0) {
                helper.setCc(email.getCcAddresses());
            }

            if(email.getBcAddress() != null){
                helper.setBcc(email.getBcAddress());
            }

            if(email.getBcAddresses() != null && email.getBcAddresses().length>0){
                helper.setBcc(email.getBcAddresses());
            }

            if(email.getAttachement() != null){
                helper.addAttachment(MimeUtility.encodeWord(email.getAttachement().getName()),
                        email.getAttachement());
            }

            if(email.getAttachements() != null && email.getAttachements().length>0){
                for (int i = 0; i < email.getAttachements().length; i++) {
                    helper.addAttachment(MimeUtility.encodeWord(email.getAttachements()[i].getName()),
                            email.getAttachements()[i]);
                }
            }

            helper.setText(email.getContext());
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Email receive() {
        return null;
    }


    private static boolean readResourceMailProperties() {
        try {
            settings = new Properties();
            InputStream is = EmailSenderImpl.class.getClassLoader().getResourceAsStream("email.properties");
            if (is == null) {
                return false;
            }
            settings.load(is);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
