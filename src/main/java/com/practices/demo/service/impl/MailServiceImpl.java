package com.practices.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.practices.demo.dto.PersonDto;
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
	public void sendEmail(PersonDto person) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();

		mail.setTo("pepepaquetemetes123@gmail.com");
		mail.setSubject("SpringBoot Reserve");
		mail.setText(person.getName() + ", your reservation has been made successfully");

		javaMailSender.send(mail);

	}
}
