package com.practices.demo.service;

import com.practices.demo.model.Person;

/**
 * The Interface MailService.
 */
public interface MailService {

	/**
	 * Send email.
	 *
	 * @param p the person
	 */
	public void sendConfirmReserveEmail(Person p);

	/**
	 * Send daily email.
	 */
	public void sendReportDailyReservesEmail();

}
