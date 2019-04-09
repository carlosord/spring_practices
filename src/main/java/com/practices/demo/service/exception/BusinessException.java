package com.practices.demo.service.exception;

/**
 * The Class BusinessException.
 */
public class BusinessException extends Exception {

	/** Serial version ID. */
	private static final long serialVersionUID = -8294390050869924558L;
	
	/** The field. */
	private final String field;

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
	
}
