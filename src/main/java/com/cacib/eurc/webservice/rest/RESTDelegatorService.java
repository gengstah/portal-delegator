package com.cacib.eurc.webservice.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cacib.eurc.delegator.ApplicationDelegator;
import com.cacib.eurc.exception.ApplicationDelegatorException;
import com.cacib.eurc.model.DelegatorRequest;
import com.cacib.eurc.model.DelegatorResponse;

@Path("/")
public interface RESTDelegatorService extends ApplicationDelegator {
	
	@POST
	@Consumes(MediaType.TEXT_XML)
	@Produces(MediaType.TEXT_XML)
	@Path("/execute")
	DelegatorResponse executeRequest(DelegatorRequest request) throws ApplicationDelegatorException;
	
}