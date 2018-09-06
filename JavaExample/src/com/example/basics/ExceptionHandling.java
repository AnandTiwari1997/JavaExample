package com.example.basics;


/**
 * This program show various methods for Exception Handling.
 * @author anand.tiwari
 *
 */
public class ExceptionHandling {
	
    private String Money = null;
	
    /**
	 * 
	 * @param a
	 * @param b
	 * @return divide
	 */
    public double divideAndCompute(double a, double b) {
    	if ((a/b) == Double.POSITIVE_INFINITY || (a/b) == Double.NEGATIVE_INFINITY) {
            // throw can be used to explicitly throw the exception.
            // we use throw where are likely chances of occurring of exception.
            // it mostly used to throw custom exception
            throw new ArithmeticException("Divide By Zero Exception Occur.");
    	}
    	return (a/b);
    }
    
    /**
     * 
     * @return Money
     * @throws NullPointerException
     */ 
    // throws will signify that this method may throw one of the exception listed here
    public String getMyMoneyYouNigga() throws NullPointerException{
    	return Money;
    }

    /**
	 * Main Method
	 * @param args
	 */
    public static void main(String[] args) {
    	ExceptionHandling exceptionHandling = new ExceptionHandling();
    	// Divide by Zero Exception will Occur because I throw it.
    	//System.out.println(exceptionHandling.divideAndCompute(1, 0));
    	
    	
    	
    	// try-catch block is mostly used way to handle the exception.
    	// using this we can handle as many exception we want using many catch block.
    	// Only matching exception catch block will be executed.
    	// Code to handle the exception will be written inside catch block.
    	// we can also combine finally block with try-catch. Statement of finally block
    	// will be executed in any how condition.
    	
    	try {
            //System.out.println(exceptionHandling.divideAndCompute(1,  0));
            System.out.println(exceptionHandling.getMyMoneyYouNigga());
    	} catch (ArithmeticException e) {
            e.printStackTrace();
    	} catch (NullPointerException e) {
            e.printStackTrace();
    	} finally {
            System.out.println("Sorry for the Inconvenience.");
    	}
    	
    }

}
