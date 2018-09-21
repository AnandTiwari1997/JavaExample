package com.impetus.exception;

/**
 * This is user defined exception class for invalid string length.
 * @author anand.tiwari
 *
 */
public class InvalidLength extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default Constructor.
	 */
	public InvalidLength() {
		super();
	}
	
	/**
	 * Parameterized Constructor.
	 * @param message message to print.
	 */
	public InvalidLength(String message) {
		super(message);
	}
}
