package com.cacib.eurc.webservice.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.cacib.eurc.delegator.ApplicationDelegator;
import com.cacib.eurc.exception.ApplicationDelegatorException;
import com.cacib.eurc.model.DelegatorRequest;
import com.cacib.eurc.model.DelegatorResponse;

@WebService
public interface SOAPDelegatorService extends ApplicationDelegator {
	
	@WebMethod(operationName="execute")
	DelegatorResponse executeRequest(DelegatorRequest request) throws ApplicationDelegatorException;
	
}