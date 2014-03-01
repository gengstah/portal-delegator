package com.cacib.eurc.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cacib.eurc.annotation.Production;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.cacib.eurc.dao")
@Production
public class JndiDataConfig extends AbstractDataConfig {
	
	private static final Logger log = LoggerFactory.getLogger(JndiDataConfig.class);
	
	@Override
	@Bean
	public DataSource dataSource() {
		
		DataSource dataSource = null;
		String jndi = "java:comp/env/jdbc/datasource";		
		
		Context ctx;
		try {
			ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
		} catch (NamingException e) { log.warn("Failed to lookup jndi [{}]", jndi); }
		
        return dataSource;
	}
	
}