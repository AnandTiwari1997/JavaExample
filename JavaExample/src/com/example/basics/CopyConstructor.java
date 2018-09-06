package com.example.basics;

/**
 * This Program shows the usage of Constructor as Copy Constructor.
 * @author anand.tiwari
 *
 */
public class CopyConstructor {
	
    private int re, im;
	
    /**
     * Parameterized Constructor
	 * Nothing
	 */
    public CopyConstructor(int re, int im) {
    	this.re = re;
    	this.im = im;
    }
	
    /**
	 * Copy Constructor
	 * @param cp
	 */
    CopyConstructor(CopyConstructor cp) {
    	this.re = cp.re;
    	this.im = cp.im;
    }

    /**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {

    	CopyConstructor cp = new CopyConstructor(10,  15);
    	CopyConstructor cp2 = new CopyConstructor(cp);
    	CopyConstructor cp3 = cp2;
    	System.out.println(cp2.im + " - " + cp2.re);
    	System.out.println(cp3.im + " - " + cp3.re);
    	
    }

}
