package com.account.service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.account.entity.Transaction;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	final Configuration configuration;
	final JavaMailSender mailSender;

	public EmailService(Configuration configuration, JavaMailSender mailSender) {
		this.configuration = configuration;
		this.mailSender = mailSender;
	}

	public void sendEmail(Transaction transaction) throws MessagingException, TemplateException, IOException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject("Transaction Details");
		helper.setTo(transaction.getUserName());
		String emailContent = getEmailContent(transaction);
		helper.setText(emailContent, true);
		mailSender.send(mimeMessage);
	}

	String getEmailContent(Transaction transaction) throws TemplateException, IOException {
		StringWriter stringWriter = new StringWriter();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("trans", transaction);
		configuration.getTemplate("transaction-email.ftlh").process(model, stringWriter);
		return stringWriter.getBuffer().toString();
	}

}
