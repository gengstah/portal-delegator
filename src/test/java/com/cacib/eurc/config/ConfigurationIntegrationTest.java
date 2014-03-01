package com.cacib.eurc.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

import com.cacib.eurc.delegator.ApplicationDelegator;
import com.cacib.eurc.service.LogService;

public class ConfigurationIntegrationTest {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigurationIntegrationTest.class);
	
	private AnnotationConfigApplicationContext ctx;
	
	@Before
	public void init() {
		ctx = new AnnotationConfigApplicationContext();
	}
	
	@After
	public void after() {
		ctx.close();
	}
	
	@Test
	public void dataConfigTest() {
		ctx.getEnvironment().setActiveProfiles("development");
		ctx.register(StandaloneDataConfig.class);
		ctx.refresh();
		
		log.debug("Getting DataSource");
		ctx.getBean(DataSource.class);
		
		log.debug("Getting EntityManagerFactoryBean");
		ctx.getBean(EntityManagerFactory.class);
		
		log.debug("Getting TransactionManager");
		ctx.getBean(PlatformTransactionManager.class);
	}
	
	@Test
	public void serviceTest() {
		ctx.getEnvironment().setActiveProfiles("development");
		ctx.register(StandaloneDataConfig.class);
		ctx.register(ServiceConfig.class);
		ctx.refresh();
		
		ctx.getBean(LogService.class);
	}
	
	@Test
	public void webServiceConfigTest() {
		ctx.register(WebServiceConfig.class);
		ctx.refresh();
		
		ctx.getBean("applicationDelegator", ApplicationDelegator.class);
	}
	
}