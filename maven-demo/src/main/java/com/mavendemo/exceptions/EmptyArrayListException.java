package com.mavendemo.exceptions;

import org.apache.log4j.Logger;

/**
 * This is the User defined Exception which will be called when someone try to
 * perform delete operation on Empty ArrayList.
 * 
 * @author anand.tiwari
 */
public class EmptyArrayListException extends Exception {

	private static final Logger LOGGER = Logger.getLogger(EmptyArrayListException.class);

	/** Constant Version UID. */
	private static final long serialVersionUID = -5684223208137742991L;

	/** default constructor. */
	public EmptyArrayListException() {
		LOGGER.error("Array List is not Inititalized");
	}

	/**
	 * Parameterized Constructor.
	 * 
	 * @param message
	 *            that is to be print on the logger.
	 */
	public EmptyArrayListException(String message) {
		LOGGER.error("Exception Occured {} " + message);
	}

}
