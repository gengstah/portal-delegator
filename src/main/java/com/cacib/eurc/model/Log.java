package com.cacib.eurc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOG")
public class Log implements Serializable {
	
	private static final long serialVersionUID = 8525078358222672442L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="API")
	private String api;
	
	@Column(name="MESSAGE_DIRECTION")
	private String messageDirection;
	
	@Column(name="MESSAGE_EXCHANGE_ID")
	private Long messageExchangeId;
	
	@Column(name="APP_CODE")
	private String applicationCode;
	
	@Column(name="DATA")
	private String data;
	
	@Column(name="CREATION_DATE")
	private Date creationDate;
	
	public Log() { }
	
	public void prePersist() {
		creationDate = new Date();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the api
	 */
	public String getApi() {
		return api;
	}

	/**
	 * @param api the api to set
	 */
	public void setApi(String api) {
		this.api = api;
	}

	/**
	 * @return the messageType
	 */
	public String getMessageDirection() {
		return messageDirection;
	}

	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageDirection(String messageType) {
		this.messageDirection = messageType;
	}

	/**
	 * @return the messageExchangeId
	 */
	public Long getMessageExchangeId() {
		return messageExchangeId;
	}

	/**
	 * @param messageExchangeId the messageExchangeId to set
	 */
	public void setMessageExchangeId(Long messageExchangeId) {
		this.messageExchangeId = messageExchangeId;
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
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Log [id=" + id + ", api=" + api + ", messageType="
				+ messageDirection + ", messageExchangeId=" + messageExchangeId
				+ ", applicationCode=" + applicationCode + ", data=" + data
				+ ", creationDate=" + creationDate + "]";
	}
		
}