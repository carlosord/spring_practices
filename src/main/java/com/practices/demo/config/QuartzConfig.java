package com.practices.demo.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practices.demo.service.impl.QuartzServiceImpl;

@Configuration
public class QuartzConfig {

	@Bean
	public JobDetail jobEmail() {
		return JobBuilder.newJob(QuartzServiceImpl.class).withIdentity("sendEmailJob").storeDurably().build();
	}

	@Bean
	public Trigger emailTrigger(JobDetail jobADetails) {

		return TriggerBuilder.newTrigger().forJob(jobADetails)

				.withIdentity("sendEmailTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0/30 0/1 * 1/1 * ? *")).build();
		//.withIdentity("sendEmailTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0 20 * * ? *")).build(); TODOS LOS DIAS A LAS 20:00h
	}

}
