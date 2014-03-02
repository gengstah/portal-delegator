package com.cacib.eurc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.cacib.eurc.delegator.ApplicationDelegator;
import com.cacib.eurc.delegator.impl.ApplicationDelegatorImpl;

@Configuration
@ImportResource("classpath:server.xml")
public class WebServiceConfig {
	
	@Bean
	public ApplicationDelegator applicationDelegator() {
		return new ApplicationDelegatorImpl();
	}
	
}