package com.example.basics;

/**
 * This program shows the use of Loops.
 * @author anand.tiwari
 *
 */
public class Loops {
	
    private int globalSum;
	
    /**
     * Nothing
     */
    public void runWhile() {
		
    	int localSum = 0;
		
    	while(localSum != globalSum) {
            localSum = localSum + 1;
    	}
		
    	System.out.println(localSum);
		
    }
	
    /**
     * Nothing
     */
    public void runDoWhile() {
		
        int localSum = 0;
		
        do {
            localSum = localSum + 1;
        }while(localSum != globalSum);
		
        System.out.println(localSum);
		
    }
	
    /**
     * Nothing
     */
    public void runFor() {
		
    	int localSum = 0;
		
    	for(; localSum != globalSum; localSum++);
		
    	System.out.println(localSum);
		
    }
	
    /**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
		
    	Loops loops = new Loops();
    	loops.globalSum = 10;
		
    	loops.runDoWhile();
    	loops.runWhile();
    	loops.runFor();
		
    }

}
