package com.practices.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * The Class Config.
 */
@Configuration
public class Config {
	
	/**
	 * Layout dialect.
	 *
	 * @return the layout dialect
	 */
	@Bean
	public LayoutDialect layoutDialect() {
	    return new LayoutDialect();
	}

}
