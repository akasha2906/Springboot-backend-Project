package org.jsp.springbootproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException; 
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class mailcontroller {
	@Autowired
	private JavaMailSender mailsender;

	
	private String token;

	@PostMapping("/sendmail")
	public String sendmail(HttpServletRequest request, @RequestParam String email) {
		token="abcde";
		String siteurl = request.getRequestURL().toString();
		String url = siteurl.replace(request.getServletPath().toString(), "/verify")+"?token="+token;
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setSubject("account verification");
			helper.setTo(email);
			helper.setText(url);
			mailsender.send(message);
			return url;
		} catch (MessagingException e) {
			return "maill not sended";
		}
	}
	
	@GetMapping("/verify")
	public String verify(@RequestParam String token)
	{
		if(this.token.equals(token))
			return "verification succesfull";
		else
			return"not verify";		
	}
}
