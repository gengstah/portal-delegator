package com.cacib.eurc.config;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	
	private static final String NAMESPACE = "http://soap.webservice.eurc.cacib.com/";
    private static final QName SERVICE_QNAME = new QName(NAMESPACE, "SOAPDelegatorService");
	
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
	//@Ignore
	public void webServiceClientTest() throws ApplicationDelegatorException, IOException {
		
		//ctx.register(WebServiceConfig.class);
		ctx.register(WebServiceClientConfig.class);
		ctx.refresh();
		
		log.debug("Creating the web service clients");
		//RESTDelegatorService restDelegatorService = ctx.getBean("restDelegatorClient", RESTDelegatorService.class);
		//SOAPDelegatorService soapDelegatorService = (SOAPDelegatorService) ctx.getBean("soapDelegatorClient");
		
		//URL wsdl = new URL("https://localhost:8443/delegator/api/soap?wsdl");
		SpringBusFactory bf = new SpringBusFactory();
        URL busFile = WebServiceIntegrationTest.class.getResource("/client.xml");

        Bus bus = bf.createBus(busFile.toString());
        SpringBusFactory.setDefaultBus(bus);
        SpringBusFactory.setThreadDefaultBus(bus);
        
		URL wsdl = WebServiceIntegrationTest.class.getResource("/wsdl/delegator.wsdl");
		Service service = Service.create(wsdl, SERVICE_QNAME);
		QName portQName = new QName(NAMESPACE, "SOAPDelegatorServicePort");
		
		SOAPDelegatorService soapDelegatorService = service.getPort(portQName, SOAPDelegatorService.class);
		//enableMTOM(soapDelegatorService);
		
		DelegatorRequest request = createRequest();
		
		//log.debug("{}", restDelegatorService.executeRequest(request));
		log.debug("{}", soapDelegatorService.executeRequest(request));
		
		((java.io.Closeable)soapDelegatorService).close();
        //bus.shutdown(true);
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