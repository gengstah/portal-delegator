package com.cacib.eurc.model;

import java.io.Serializable;

public class Field implements Serializable {
	
	private static final long serialVersionUID = 844106615728119895L;

	private String key;
	
	private String value;
	
	public Field() { }
	
	public Field(String key, String value) { this.key = key; this.value = value; }

	/**
	 * @return the name
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param name the name to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Field [name=" + key + ", value=" + value + "]";
	}
	
}