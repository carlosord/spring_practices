package com.practices.demo.business;

public class BusinessException extends Exception{

	private static final long serialVersionUID = 1L;


	private String field;

	/**
	 * Instantiates a new business exception.
	 *
	 * @param message the message
	 * @param field the field
	 */
	public BusinessException(String message, String field) {
		super(message);
		this.field = field;
	}

	/**
	 * Gets the field.
	 *
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * Sets the field.
	 *
	 * @param field the new field
	 */
	public void setField(String field) {
		this.field = field;
	}

}