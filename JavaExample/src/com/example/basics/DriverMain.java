package com.example.basics;

/**
 * This program shows the way to create SingleTon class using a private constructor and
 * a static method that returns a instance of the SingleTOn class.
 * @author anand.tiwari
 *
 */
class SingleTon {
	
    public static SingleTon single = null;

    public String msg = null;  
    
    /**
     * Nothing
     */
    private SingleTon() {
    	msg = "I am inside SingleTon Class Constructor.";
    }
    
    /**
     * Nothing
     * @return SingleTon Instance
     */
    public static SingleTon getInstance() {
    	
    	if(single == null) {
    	    single = new SingleTon();
    	}
    	
    	return single;
    }

}

public class DriverMain {
	
    /**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
    	
    	SingleTon x = SingleTon.getInstance();
    	System.out.println("\nFirst Object x.msg :" + x.msg);
    	
    	SingleTon y = SingleTon.getInstance();
    	System.out.println("\nSecond Object y.msg :" + y.msg);
    	
    	x.msg = (y.msg).toUpperCase();
    	System.out.println("\nFirst Object x.msg :" + x.msg);
    	System.out.println("\nSecond Object y.msg :" + y.msg);
    	
    	SingleTon z = SingleTon.getInstance();
    	System.out.println("\nThird Object z.msg :" + z.msg);
    	
    }
	
}
