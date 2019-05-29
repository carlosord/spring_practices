package com.practices.demo.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
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

	 @Autowired
	  private MessageSource messageSource;

	 @Autowired
	 Environment env;


	/**
	 * Send email.
	 *
	 * @param person the person
	 * @throws MailException the mail exception
	 */
	public void sendEmail(Person person) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		String[] p = new String[] {person.getName()};

		mail.setTo("pepepaquetemetes123@gmail.com");
		mail.setSubject(messageSource.getMessage("mail.reserve.subject", null, LocaleContextHolder.getLocale()));
		mail.setText(messageSource.getMessage("mail.reserve.text",p , LocaleContextHolder.getLocale()));

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
			helper.setSubject(messageSource.getMessage("mail.day.subject", null, LocaleContextHolder.getLocale()));
			helper.setText(messageSource.getMessage("mail.day.text", null, LocaleContextHolder.getLocale()));
			//helper.addAttachment("MyPdf.pdf", new FileSystemResource("F:\\Doc\\index.pdf"));

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
