package com.mindgate.main.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mindgate.main.domain.Mail;
@Service
public class MailService {
	
	@Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail,
                                String subject,
                                String body
    ) {
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("akshaya.ravikumar2001@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
       
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send...");



	
    }
	
}
