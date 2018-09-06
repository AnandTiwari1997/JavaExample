package com.example.basics;

/**
 * This program show how to create default and static method inside the Interface.
 * After java 8, we can provide body to method inside interface by using default keyword.
 * default method provide BackWard Comparability.
 * @author anand.tiwari
 *
 */
interface TestInterface {
	
    /**
	 * abstract method
	 */
    public void show();
	
    /**
     * default method
     */
    default void display() {
    	System.out.println("Inside the default method TestInterface.");
    }
    
    /**
     * static method
     */
    static void display2() {
    	System.out.println("Inside the static method TestInterface.");
    }
}

public class Main implements TestInterface {

    @Override
	public void show() {
    	System.out.println("Implimenting abstract method from TestInterface.");
    }
    
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
    	Main main = new Main();
    	main.show();
    	main.display();
    	TestInterface.display2();
    }
	
}
