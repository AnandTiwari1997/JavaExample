package com.example.basics;

class BaseStaticfamily {
	
    public static int b;
    
    /**
     * Nothing
     */
    static void functionA() {
    	System.out.println("\nInside Base Static Method");
    	b = b + 1;
    	System.out.println("a in static method := " + b);
    }
	
	
}

public class StaticFamily extends BaseStaticfamily{
	
    public static int a;
	
    static {
    	System.out.println("\nInside Static Block");
    	a = a + 1;
    	System.out.println("a in static block := " + a);
    }
    
    /**
     * Nothing
     */
    static void functionA() {
    	System.out.println("\nInside Derived Static Method");
    	a = a + 1;
    	System.out.println("a in static method := " + a);
    }

    /**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {

    	//StaticFamily staticFamily = new StaticFamily();
    	//BaseStaticfamily baseStaticfamily = new StaticFamily();
    	StaticFamily.functionA();
    }

}
