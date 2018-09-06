package com.example.basics;
class JBT {
	
    /**
	 * DEFAULT CONSTRUCTOR
	 */
    JBT() {
    	this("HELLO"); //we can call a constructor from another constructor by using this as first statement.
    	System.out.println("Inside Default Constructor");
    	this.methodOne(); //can call method using this from any statement inside constructor
    	this.methodTwo(); //can call any number of methods from using this keyword.

    	/*
		This tells that constructor chaining is possible only when we use this keyword as first statement 
		but for the methods this does not holds we can call methods using this from any statements.
    	 */
    }
  
    /**
     * Parameterized constructor
     * @param someValue
     */
    JBT(String someValue) {
    	//this(); There should be at-least be one constructor without the this() keyword
    	//cannot call constructor recursively.
    	System.out.println("Inside Paramatrized Constructor having value " + someValue);
    }
  
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
    	JBT obj = new JBT();
    	obj.methodTwo();
    }
  
    /**
     * methodOne
     */
    void methodOne(){
    	//this("HELLO"); cannot call constructor from a method
    	System.out.println("Inside Method ONE");
    	this.methodTwo(); // but we can call methods recursively 
    }
    
    /**
     * METHODtWO
     */
    void methodTwo(){
    	this.methodOne();// same as calling methodOne()
    	System.out.println("Inside Method TWO");
    
    }
  
}