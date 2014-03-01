package com.cacib.eurc.exception;

public class ApplicationDelegatorException extends Exception {
	
	private static final long serialVersionUID = -419813320905985068L;

	private String details;
	
	public ApplicationDelegatorException(String reason, String details) {
		super(reason);
		this.details = details;
	}
	
	public String getFaultInfo() { return details; }

}