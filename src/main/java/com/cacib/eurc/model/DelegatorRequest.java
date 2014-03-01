package com.cacib.eurc.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DelegatorRequest")
public class DelegatorRequest implements Serializable {
	
	private static final long serialVersionUID = -2971709133531957485L;

	private String applicationCode;
	
	private List<Field> fields;
	
	private List<Attachment> attachments;
	
	public DelegatorRequest() { }
	
	public DelegatorRequest(String applicationCode) { this.applicationCode = applicationCode; }

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

	/**
	 * @return the attachments
	 */
	public List<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
	
	public List<Attachment> addAttachment(Attachment attachment) {
		if(attachments == null) attachments = new ArrayList<Attachment>();
		attachments.add(attachment);
		
		return attachments;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DelegatorRequest [applicationCode=" + applicationCode
				+ ", fields=" + fields + ", attachments=" + attachments + "]";
	}
	
}