package com.cacib.eurc.delegator;

import com.cacib.eurc.exception.ApplicationDelegatorException;
import com.cacib.eurc.model.DelegatorRequest;
import com.cacib.eurc.model.DelegatorResponse;

public interface ApplicationDelegator {
	
	DelegatorResponse executeRequest(DelegatorRequest request) throws ApplicationDelegatorException;
	
}