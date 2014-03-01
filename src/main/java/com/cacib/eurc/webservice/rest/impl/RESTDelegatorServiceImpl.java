package com.cacib.eurc.webservice.rest.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cacib.eurc.delegator.ApplicationDelegator;
import com.cacib.eurc.exception.ApplicationDelegatorException;
import com.cacib.eurc.model.DelegatorRequest;
import com.cacib.eurc.model.DelegatorResponse;
import com.cacib.eurc.webservice.rest.RESTDelegatorService;

public class RESTDelegatorServiceImpl implements RESTDelegatorService {
	
	private static final Logger log = LoggerFactory.getLogger(RESTDelegatorService.class);
	
	@Inject private ApplicationDelegator applicationDelegator;
	
	public DelegatorResponse executeRequest(DelegatorRequest request) throws ApplicationDelegatorException {
		log.info("Executing a request from a REST client");
		log.debug("{}", request);
		
		log.info("Saving the request");
		// save request to database
		
		DelegatorResponse response = applicationDelegator.executeRequest(request);
		
		log.info("Saving the response");
		// save response to database
		
		return response;
	}

}