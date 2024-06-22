package com.example.edukate.service.impl;

import com.example.edukate.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    @Override
    public void sendConfirmationEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("nathen.quigley@ethereal.email");
        message.setTo("nathen.quigley@ethereal.email");
        message.setSubject("Confirm email");
        // http://localhost:9090/auth/confrim?email=rizvan@itbrain.edu.az&token=adfhaskjfhaj
        // Template literals
        String res = "http://localhost:9090/auth/confrim?email="+email+"&token="+token;
        message.setText(res);
        mailSender.send(message);
    }

    @Override
    public void sendPasswordResetEmail(String email, String token) {

    }
}