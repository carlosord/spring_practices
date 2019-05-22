package com.practices.demo.service;

import com.practices.demo.dto.PersonDto;

/**
 * The Interface MailService.
 */
public interface MailService {

	/**
	 * Send email.
	 *
	 * @param person the person
	 */
	public void sendEmail(PersonDto person);

}
