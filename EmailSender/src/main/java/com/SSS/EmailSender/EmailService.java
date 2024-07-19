//----------------- email API Service

package com.SSS.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    public void send(String to, String body, String sub) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("fromemail@gmail.com");
        message.setTo(to);
        message.setText(body);
        message.setSubject(sub);
        mailSender.send(message);
        System.out.println("Mail Send...");
    }
}
