package com.cacib.eurc.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ApplicationDelegatorExceptionHandler implements ExceptionMapper<ApplicationDelegatorException> {

	public Response toResponse(ApplicationDelegatorException exception) {
		Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
 
        return Response.status(status).header("exception", exception.getMessage()).build();
	}
	
}