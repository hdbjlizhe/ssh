package com.info.event.listener;

import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

@Component
public class MyJavaMailSender extends JavaMailSenderImpl {

	@Override
	public void send(SimpleMailMessage simpleMessage) throws MailException {
		super.send(simpleMessage);
	}

	@Override
	public void send(SimpleMailMessage... simpleMessages) throws MailException {
		super.send(simpleMessages);
	}

	@Override
	public MimeMessage createMimeMessage() {
		return super.createMimeMessage();
	}

	@Override
	public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
		return super.createMimeMessage(contentStream);
	}

	@Override
	public void send(MimeMessage mimeMessage) throws MailException {
		super.send(mimeMessage);
	}

	@Override
	public void send(MimeMessage... mimeMessages) throws MailException {
		super.send(mimeMessages);
	}

	@Override
	public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
		super.send(mimeMessagePreparator);
	}

	@Override
	public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {
		super.send(mimeMessagePreparators);

	}

}
