package com.example.basics;

/**
 * This program show how we can return multiple value of same or different data types.
 * @author anand.tiwari
 *
 */
class Structure {
    float sub;
    int mul;
    double div;
    
    /**
     * 
     * @param sub
     * @param mul
     * @param div
     */
    public Structure(float sub, int mul, double div) {
    	this.sub = sub;
    	this.mul = mul;
    	this.div = div;
    }
}

public class MultipleValueReturn {

    /**
	 * 
	 * @param a
	 * @param b
	 * @return Structure
	 */
    public Structure getDifferentDataTypereturn(int a, int b) {
    	return new Structure((a - b), a*b, (double)a / b);
		
    }
    
    /**
     * @param a
     * @param b
     * @return []
     */
    public int[] getMultiplereturnSameType(int a, int b) {
    	int[] ans = new int[2];
    	ans[0] = a + b;
    	ans[1] = a - b;
    	return ans;
    }
    
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
    	
    	MultipleValueReturn multipleValueReturn = new MultipleValueReturn();
    	Structure structure = multipleValueReturn.getDifferentDataTypereturn(10,  15);
    	System.out.println("Different types return values : ");
    	System.out.println("Float return type : " + structure.sub);
    	System.out.println("Integer return type : " + structure.mul);
    	System.out.println("Double return type : " + structure.div);
    	System.out.println();
    	
    	int[] returnValues = new int[2];
    	returnValues = multipleValueReturn.getMultiplereturnSameType(10,  15);
    	System.out.println("Same Type return values : ");
    	System.out.println("Integer return value 1 : " + returnValues[0]);
    	System.out.println("Integer return value 2 : " + returnValues[1]);
    	
    }

}
