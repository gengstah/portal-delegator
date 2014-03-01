package com.cacib.eurc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DelegatorResponse")
public class DelegatorResponse implements Serializable {
	
	private static final long serialVersionUID = 3133668665353213113L;

	private String id;
	
	private String applicationCode;
	
	private String message;
	
	private List<Field> fields;
	
	public DelegatorResponse() { }
	
	public DelegatorResponse(String id) { this.id = id; }
	
	public DelegatorResponse(String id, String applicationCode) { 
		this.id = id;
		this.applicationCode = applicationCode;
	}
	
	public DelegatorResponse(String id, String applicationCode, String message) {
		this.id = id;
		this.applicationCode = applicationCode;
		this.message = message;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the applicationCode
	 */
	public String getApplicationCode() {
		return applicationCode;
	}

	/**
	 * @param applicationCode the applicationCode to set
	 */
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the fields
	 */
	public List<Field> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	
	/**
	 * 
	 * @param field The field to be added
	 * @return The list of fields
	 */
	public List<Field> addField(Field field) {
		if(fields == null) fields = new ArrayList<Field>();
		fields.add(field);
		
		return fields;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DelegatorResponse [id=" + id + ", applicationCode="
				+ applicationCode + ", message=" + message + ", fields="
				+ fields + "]";
	}
	
}