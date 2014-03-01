package com.cacib.eurc.model;

import java.io.Serializable;

import javax.activation.DataHandler;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Attachment implements Serializable {
	
	private static final long serialVersionUID = -4523689959598288176L;

	private String name;
	
	@XmlMimeType(MediaType.APPLICATION_OCTET_STREAM)
	private DataHandler attachment;
	
	public Attachment() { }
	
	public Attachment(String name) { this.name = name; }
	
	public Attachment(String name, DataHandler attachment) { this.name = name; this.attachment = attachment; }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dataHandler
	 */
	public DataHandler getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment the dataHandler to set
	 */
	/*public void setAttachment(DataHandler attachment) {
		this.attachment = attachment;
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Attachment [name=" + name + "]";
	}
	
}