package com.example.basics;

import com.example.basics.OuterClass.InnerClassNonStatic;
import com.example.basics.OuterClass.InnerStaticClass;

/**
 * This program will show how static (static nested class) class can be created inside java.
 * @author anand.tiwari
 *
 */
class OuterClass {
	private static String message = "This is an static variable.";
	private String message2 = "This is a non-static variable.";
	
	/**
	 * This is a static nested class.
	 * @author anand.tiwari
	 *
	 */
	static class InnerStaticClass {
		
		/**
		 * An static method.
		 */
		public static void printMessage() {
			System.out.println(message);
		}
	}
	
	/**
	 * This is a non-static nested class or inner class.
	 * @author anand.tiwari
	 *
	 */
	class InnerClassNonStatic {
		
		/**
		 * A non-static method.
		 */
		public void display() {
			System.out.println(message);
			System.out.println(message2);
		}
	}
}


/**
 * Class Containing main method.
 * @author anand.tiwari
 *
 */
public class StaticClass {

	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		//OuterClass.InnerStaticClass innerStaticClass = new OuterClass.InnerStaticClass();
		
		// Static Nested Class can be accessed without Outer Class Reference.
		InnerStaticClass.printMessage();
		
		
		// Inner Class is referenced using the Outer Class reference.
		OuterClass outerClass = new OuterClass();
		InnerClassNonStatic classNonStatic = outerClass.new InnerClassNonStatic();
		
		classNonStatic.display();
	}

}
