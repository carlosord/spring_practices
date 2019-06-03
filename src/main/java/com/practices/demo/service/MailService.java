package com.practices.demo.service;

import com.practices.demo.model.Person;

/**
 * The Interface MailService.
 */
public interface MailService {

	/**
	 * Send confirm reserve email.
	 *
	 * @param p the p
	 */
	public void sendConfirmReserveEmail(Person p);

	/**
	 * Send report daily reserves email.
	 */
	public void sendReportDailyReservesEmail();

}
