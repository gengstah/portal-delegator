package com.cacib.eurc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cacib.eurc.service.LogService;
import com.cacib.eurc.service.impl.LogServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public LogService logService() {
		return new LogServiceImpl();
	}
	
}