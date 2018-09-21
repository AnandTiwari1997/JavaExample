package com.impetus.innerclass;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.impetus.exception.InvalidNumber;
import com.impetus.reflection.FindPrivateMember;

/**
 * A Call class which will call on the entered number. It will implement
 * Anonymous Class.
 * 
 * @author anand.tiwari
 *
 */
public class Call {

	/**
	 * Some Private and Static declaration.
	 */
	private static final Logger LOGGER = Logger.getLogger(FindPrivateMember.class);
	private static Scanner scanner = new Scanner(System.in);

	public static final int TEN = 10;

	/**
	 * default Constructor.
	 */
	public Call() {
	}

	/**
	 * Parameterized Constructor.
	 * 
	 * @param calling
	 *            instance of the Calling Interface.
	 * @param number
	 *            number to call.
	 */
	public Call(Calling calling, String number) {
		calling.calling(number);
	}

	/**
	 * method to make calls.
	 * 
	 * @param number
	 *            number to call.
	 */
	public void makeCall(String number) {
		LOGGER.info("Calling...");
	}
	
	/**
	 * Get Instance of the interface.
	 * @return interface instance.
	 */
	public static Calling getInstance() {
		return new Calling() {
			
			@Override
			public void calling(String number) {
				LOGGER.info("Calling from Interface Overrided method " + number);
				
			}
		};
	}
	
	/**
	 * This method create an anonymous class, a lambda expression and a anonymous class of same class.
	 * @param number number to call
	 */
	public void callAnonymous(String number) {
		try {
			if (number.length() == TEN && Pattern.matches("[0-9]+", number)) {

				// Anonymous class to create instance of the interface.
				new Call(getInstance(), number);

				// Lambda Expression.
				new Call(nmber -> LOGGER.info("Calling from Lambda Expression " + nmber), number);

				// Anonymous class to override an existing method.
				Call call2 = new Call() {

					@Override
					public void makeCall(String number) {
						LOGGER.info("Calling from Class Overrided method " + number);
					}
				};
				call2.makeCall(number);

			} else {
				throw new InvalidNumber("Please check the number you have dialed.");
			}
		} catch (InvalidNumber e) {
			LOGGER.error(e.getMessage());
			Throwable se = new Throwable();
			se.initCause(e);
			LOGGER.error(se.getCause());
		} catch (NullPointerException e) {
			LOGGER.error("Input: " + number + ", Expected Phone Number.");
		}
	}


	/**
	 * Main Method.
	 * 
	 * @param args
	 *            Some arguments.
	 */
	public static void main(String[] args) {

		LOGGER.info("Enter the number to call : ");

		Call call = new Call();
		final String number = scanner.next();
		call.callAnonymous(number);

	}

}
