package com.cacib.eurc.config;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.cacib.eurc.exception.ApplicationDelegatorExceptionHandler;
import com.cacib.eurc.webservice.rest.RESTDelegatorService;
import com.cacib.eurc.webservice.soap.SOAPDelegatorService;

@Configuration
@ImportResource("classpath:client.xml")
public class WebServiceClientConfig {
	
	@Bean
	public ApplicationDelegatorExceptionHandler applicationDelegatorExceptionHandler() {
		return new ApplicationDelegatorExceptionHandler();
	}
	
	/*@Bean
	public RESTDelegatorService restDelegatorClient() {
		
		List<Object> providers = new ArrayList<Object>();
		//providers.add(getJacksonJsonProvider());
		providers.add(applicationDelegatorExceptionHandler());
		
		return JAXRSClientFactory.create("http://localhost:8080/delegator/api/rest", RESTDelegatorService.class, providers);
	}
	
	@Bean
	public SOAPDelegatorService soapDelegatorService() {
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	    factory.setServiceClass(SOAPDelegatorService.class);
	    factory.setAddress("http://localhost:8080/delegator/api/soap");
	    
	    return (SOAPDelegatorService) factory.create();
	}*/
	
}