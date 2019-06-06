package com.practices.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;


/**
 * The Class SoapConfig.
 */
@EnableWs
@Configuration
public class SoapConfig extends WsConfigurerAdapter {

	/**
	 * Message dispatcher servlet.
	 *
	 * @param applicationContext the application context
	 * @return the servlet registration bean
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
	    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	    servlet.setApplicationContext(applicationContext);
	    servlet.setTransformWsdlLocations(true);
	    return new ServletRegistrationBean(servlet, "/ws/*");
	}

	/**
	 * Default wsdl 11 definition.
	 *
	 * @param infoPersonSchema the info person schema
	 * @return the default wsdl 11 definition
	 */
	@Bean(name = "infoPersonWsdl")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema infoPersonSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("InfoPersonPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace("http://localhost.com/spring_practices");
		wsdl11Definition.setSchema(infoPersonSchema);
		return wsdl11Definition;
	}

	/**
	 * Info person schema.
	 *
	 * @return the xsd schema
	 */
	@Bean
	public XsdSchema infoPersonSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/xsd/infoPerson.xsd"));
	}

}
