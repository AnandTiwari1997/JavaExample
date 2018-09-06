package com.mavendemo.impl;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * This program shows the usage of class Object methods and how we can override
 * them for our purpose.
 * 
 * @author anand.tiwari
 */
public class ObjectClass implements Cloneable {

	private static Logger logger = Logger.getLogger(ObjectClass.class);

	@Override
	public String toString() {
		return "This Overided toString() method.";
	}

	@Override
	public int hashCode() {
		logger.info("This is Overided hashCode() method.");
		return (int) new Date().getTime();
	}

	@Override
	public boolean equals(Object otherObject) {
		logger.info("This is Overided equals() method.");
		if (this == otherObject) {
			return true;
		}

		if (otherObject == null)
			return false;

		if (getClass() != otherObject.getClass())
			return false;

		return otherObject instanceof ObjectClass;
	}

}
