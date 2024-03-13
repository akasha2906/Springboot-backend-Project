package org.jsp.springbootproject.service;

import org.jsp.springbootproject.model.Merchant;
import org.jsp.springbootproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import static org.jsp.springbootproject.util.ApplicationConstant.MERCHANT_VERIFY_LINK;
import static org.jsp.springbootproject.util.ApplicationConstant.USER_VERIFY_LINK;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailsender;
	
	public String sendWelcomemail(Merchant merchant ,HttpServletRequest request)
	{
		String siteurl=request.getRequestURL().toString();
		String url=siteurl.replace(request.getServletPath(),"");
		String actualurl=url+MERCHANT_VERIFY_LINK+merchant.getToken();
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setText(actualurl);
			helper.setSubject("activate your account");
			helper.setTo(merchant.getEmail());
			mailsender.send(message);
			return "mail sended";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "mail not send";
		}
	}
	
	public String sendWelcomemail(User user ,HttpServletRequest request)
	{
		String siteurl=request.getRequestURL().toString();
		String url=siteurl.replace(request.getServletPath(),"");
		String actualurl=url+USER_VERIFY_LINK+user.getToken();
		MimeMessage message = mailsender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try {
			helper.setText(actualurl);
			helper.setSubject("activate your account");
			helper.setTo(user.getEmail());
			mailsender.send(message);
			return "mail sended";
		} catch (MessagingException e) {
			e.printStackTrace();
			return "mail not send";
		}
	}

}
