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
	 * This method will compute all the permutation of given String.
	 * 
	 * @param string
	 *            whose permutation needed.
	 * @return ArrayList contain all Permutation.
	 */
	public ArrayList<String> findPossiblePermutation(String string) {
		
		int stringLength = string.length();
		String[] strings = string.split("");
		
		for (int i = 0; i < stringLength; i++) {

			String str = strings[i];
			String temp = "";
			for (int j = 0; j < stringLength; j++) {
				
				if (strings[i] != strings[j]) {
					temp += strings[j];
				}
			}
			
			String newStr = str + temp;
			String[] temps = temp.split("");
			String newTemp = str + swapString(temps[0], temps[1]);
			
			arrayList.add(newStr);
			arrayList.add(newTemp);
		}
		logger.info(arrayList);
		return arrayList;
	}
	
	/**
	 * This method will swap character and return string.
	 * @param c1 character 1.
	 * @param c2 character 2.
	 * @return String c1 + c2.
	 */
	public String swapString(String c1, String c2) {
		String temp = c1;
		c1 = c2;
		c2 = temp;
		return c1 + c2;
	}
	
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
