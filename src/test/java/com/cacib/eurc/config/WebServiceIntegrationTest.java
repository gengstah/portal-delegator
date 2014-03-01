package com.cacib.eurc.config;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cacib.eurc.exception.ApplicationDelegatorException;
import com.cacib.eurc.model.Attachment;
import com.cacib.eurc.model.Field;
import com.cacib.eurc.model.DelegatorRequest;
import com.cacib.eurc.webservice.rest.RESTDelegatorService;
import com.cacib.eurc.webservice.soap.SOAPDelegatorService;

public class WebServiceIntegrationTest {
	
	private static final Logger log = LoggerFactory.getLogger(WebServiceIntegrationTest.class);
	
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
	public void webServiceClientTest() throws ApplicationDelegatorException {
		
		//ctx.register(WebServiceConfig.class);
		ctx.register(WebServiceClientConfig.class);
		ctx.refresh();
		
		log.debug("Creating the web service clients");
		RESTDelegatorService restDelegatorService = ctx.getBean("restDelegatorService", RESTDelegatorService.class);
		SOAPDelegatorService soapDelegatorService = ctx.getBean("soapDelegatorService", SOAPDelegatorService.class);
		enableMTOM(soapDelegatorService);
		
		DelegatorRequest request = createRequest();
		
		log.debug("{}", restDelegatorService.executeRequest(request));
		log.debug("{}", soapDelegatorService.executeRequest(request));
		
	}

	private void enableMTOM(SOAPDelegatorService soapDelegatorService) {
		BindingProvider bp = (BindingProvider) soapDelegatorService;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);
	}

	private DelegatorRequest createRequest() {
		
		DelegatorRequest request = new DelegatorRequest("GENG");
		
		request.addField(new Field("data", "GENG"));
		DataSource source = new FileDataSource(new File("pom.xml"));
		request.addAttachment(new Attachment("pom.xml", new DataHandler(source)));
		
		return request;
	}
	
}