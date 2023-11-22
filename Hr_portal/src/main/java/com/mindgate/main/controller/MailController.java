package com.mindgate.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.main.domain.Mail;
import com.mindgate.main.service.MailService;

@RestController
@CrossOrigin("*")
@RequestMapping("mailApi")
public class MailController {
	
	
	  	@Autowired
	    private MailService emailService;

	    // http://localhost:8081/emailapi/mail
	    @RequestMapping(value = "mail",method = RequestMethod.POST)
	    public boolean sendMail(@RequestBody Mail emailSender) {
	        emailService.sendSimpleEmail(emailSender.getMailId(), "Mindgate Hiring Freshers Interview Call Letter", "Dear "
	                + emailSender.getName() + " ,\r\n" + "\r\n" + " \r\n" + "\r\n"
	                + "Mindgate Interview Call letter :\r\n" + "\r\n" + " \r\n" + "\r\n"
	                + "We would like you to invite for an interview with us which is scheduled on "+emailSender.getInterviewDate() +" at the Venue - 7th Floor, Prestige Polygon, No 471, Anna Salai, Rathna Nagar Teynampet, Nandanam, Chennai – 600035. Opp to Rain tree hotel\r\n"
	                + "\r\n" + " \r\n" + "\r\n"
	                + "You are requested to reach the venue 30 minutes prior . You are supposed to be carry Resume  for the interview.");
//	        emailService.sendEmail("sudarshan.vive@gmail.com", "Confirmation", "ConfirmationBody");
	        return true;
	    }

}
