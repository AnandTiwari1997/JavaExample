package com.example.basics;

import org.apache.log4j.Logger;

/**
 * This program show the user-defined exception.
 * @author anand.tiwari
 *
 */
public class EmptyArrayListException extends Exception{
	
	private static Logger logger = Logger.getLogger(MyArrayList.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -5684223208137742991L;

	/**
	 * default constructor.
	 */
	public EmptyArrayListException() {
		System.out.println("ArrayList is not Initialized.");
	}
	
	/**
	 * Parameterized Constructor.
	 * @param message
	 */
	public EmptyArrayListException(String message) {
		logger.error("Exception Occured {} " + message);
		System.out.println(message);
	}

}
