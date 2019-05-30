package com.practices.demo.service.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practices.demo.service.MailService;

/**
 * The Class QuartzServiceImpl.
 */
@Service
public class QuartzServiceImpl implements Job {

	/** The mail service. */
	@Autowired
	private MailService mailService;

	/**
	 * Execute.
	 *
	 * @param context the context
	 * @throws JobExecutionException the job execution exception
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		mailService.sendDailyEmail();

	}

}
