package com.mavendemo.impl;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * This class will Perform Permutation.
 * 
 * @author Anand Tiwari
 *
 */
public class Permutation {
	
	private static Logger logger = Logger.getLogger(Permutation.class);

	private ArrayList<String> arrayList = new ArrayList<String>();
	
	/**
	 * 
	 * @param str
	 */
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	/**
	 * 
	 * @param prefix
	 * @param str
	 */
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) logger.info(prefix);
	    else {
	        for (int i = 0; i < n; i++) {
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}

}
