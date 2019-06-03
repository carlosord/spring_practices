package com.practices.demo.service.impl;

import java.io.IOException;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

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
import com.practices.demo.service.TicketService;

/**
 * The Class MailServiceImpl.
 */
@Service
public class MailServiceImpl implements MailService {

	/** The java mail sender. */
	@Autowired
	private JavaMailSender javaMailSender;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The ticket service. */
	@Autowired
	private TicketService ticketService;

	/** The env. */
	@Autowired
	Environment env;

	/**
	 * Send confirm reserve email.
	 *
	 * @param person the person
	 * @throws MailException the mail exception
	 */
	public void sendConfirmReserveEmail(Person person) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		String[] p = new String[] { person.getName() };

		mail.setTo("pepepaquetemetes123@gmail.com");
		mail.setSubject(messageSource.getMessage("mail.reserve.subject", null, LocaleContextHolder.getLocale()));
		mail.setText(messageSource.getMessage("mail.reserve.text", p, LocaleContextHolder.getLocale()));

		javaMailSender.send(mail);

	}

	/**
	 * Send report daily reserves email.
	 */
	public void sendReportDailyReservesEmail() {
		try {

			DataSource attachment = new ByteArrayDataSource(ticketService.generatePDFReserveReport(),
					"application/pdf");
			MimeMessage message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo("pepepaquetemetes123@gmail.com");
			helper.setSubject(messageSource.getMessage("mail.day.subject", null, LocaleContextHolder.getLocale()));
			helper.setText(messageSource.getMessage("mail.day.text", null, LocaleContextHolder.getLocale()));
			helper.addAttachment("ticketReserve.pdf", attachment);

			this.javaMailSender.send(message);

		} catch (MessagingException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
