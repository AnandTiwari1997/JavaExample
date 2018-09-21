package com.impetus.exception;

import org.apache.log4j.Logger;

import com.impetus.reflection.FindPrivateMember;

/**
 * User defined Exception class to throw exception when user entered wrong
 * Mobile number.
 * 
 * @author anand.tiwari
 *
 */
public class InvalidNumber extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Some Private and Static declaration.
	 */
	private static final Logger LOGGER = Logger.getLogger(FindPrivateMember.class);
	
	/**
	 * Default Constructor. 
	 */
	public InvalidNumber() {
		super();
	}

	/**
	 * Parameterized Constructor.
	 * @param message to print.
	 */
	public InvalidNumber(String message) {
		super(message);
	}

}
