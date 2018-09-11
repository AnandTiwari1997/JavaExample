package com.mavendemo.impl;

import java.io.Serializable;

/**
 * A singleTon Design Pattern.
 * @author Anand Tiwari
 *
 */
public class SingleTonClass implements Serializable{
	
	/**
	 * Static null instance of the SingleTonClass.
	 */
	public static SingleTonClass singleTonClass = null;

	/**
	 * Private Constructor.
	 */
	private SingleTonClass() {
		
	}
	
	/**
	 * Static method that return Object or instance of the SingleTonClass.
	 * @return instance of the SingleTonClass.
	 */
	public static SingleTonClass getInstance() {
		if (singleTonClass == null) {
			singleTonClass = new SingleTonClass();
		}
		
		return singleTonClass;
	}
}
