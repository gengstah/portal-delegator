package com.cacib.eurc.delegator.impl;

import com.cacib.eurc.delegator.ApplicationDelegator;
import com.cacib.eurc.exception.ApplicationDelegatorException;
import com.cacib.eurc.model.DelegatorRequest;
import com.cacib.eurc.model.DelegatorResponse;

public class ApplicationDelegatorImpl implements ApplicationDelegator {

	public DelegatorResponse executeRequest(DelegatorRequest request) throws ApplicationDelegatorException {
		return new DelegatorResponse("GENG.27.1", "GENG", "Successfully saved!");
	}
	
}