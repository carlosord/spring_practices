package com.practices.demo.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.practices.demo.model.Person;
import com.practices.demo.service.MailService;

/**
 * The Class MailServiceImpl.
 */
@Service
public class MailServiceImpl implements MailService {

	/** The java mail sender. */
	@Autowired
	private JavaMailSender javaMailSender;


	/**
	 * Send email.
	 *
	 * @param person the person
	 * @throws MailException the mail exception
	 */
	public void sendEmail(Person person) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo("pepepaquetemetes123@gmail.com");
		mail.setSubject(("mail.subject.reserve"));//CAMBIAR
		mail.setText(person.getName() + ", your reservation has been made successfully");

		javaMailSender.send(mail);

	}

	/**
	 * Send daily email.
	 */
	public void sendDailyEmail() {
		hourNow();
		try {
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo("pepepaquetemetes123@gmail.com");
			helper.setSubject(("mail.subject.day"));//CAMBIAR
			helper.setText("Testing messages");
			// helper.addAttachment("MyPdf.pdf", new FileSystemResource("F:\\Doc\\index.pdf"));

			this.javaMailSender.send(message);


		} catch (MessagingException ex) {
			System.out.println(ex.getMessage());
		}

	}

	/**
	 * Hour now.
	 */
	private void hourNow() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		System.out.println("Email sent at " + dateFormat.format(date));
	}

}
