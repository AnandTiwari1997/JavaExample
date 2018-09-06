package com.example.basics;

/**
 * This program show the following concepts like:
 * 	Method Overloading,
 * 	Decision Making Statements
 * 
 * @author anand.tiwari
 *
 */
public class DecisionMaking {

    /**
     * @param A
     * @param B
     */
    public void makeDecision(int A, int B) {
		
        if(A > B) {
            System.out.println("A is elder than B.\n");
        } else {
            System.out.println("A is younger than B.\n");
        }
		
        if (A > 18) {
    	    System.out.println("A is Eligible to Vote.\n");
        }

        if( B > 18) {
            System.out.println("B is Eligible to Vote.\n");
        }                         
	
    }
		
    /**
     * 
     * @param A
     * @param B
     * @param C
     */
    public void makeDecision(int A, int B, int C) {

    	if(A > B) {
    	    if (A > C) {
    	    	System.out.println("A is elder than Both.\n");
    	    }
    	} else if(B > C){
    	    System.out.println("B is elder than Both.\n");
    	} else {
            System.out.println("C is elder than Both.\n");
    	}
		
    	if (A > 18) {
    	    System.out.println("A is Eligible to Vote.\n");
    	}
		
    	if( B > 18) {
    	    System.out.println("B is Eligible to Vote.\n");
    	}
		
    	if( C > 18) {
    	    System.out.println("C is Eligible to Vote.\n");
    	}
			
    }
	
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
		
    	DecisionMaking decisionMaking = new DecisionMaking();
    	decisionMaking.makeDecision(20, 21);
    	System.out.println();
    	decisionMaking.makeDecision(20, 21, 18);
		
    }
 
}
