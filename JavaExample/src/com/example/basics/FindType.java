package com.example.basics;

/**
 * This program shows different types of datatypes.
 * @author anand.tiwari
 *
 */
class GetType {
	
    /**
	 * 
	 * @param object
	 * @return String
	 */
    public String type(Object object) {
        String className = object.getClass().getSimpleName();
        return className;
    }
    
    /**
     * 
     * @param object
     * @return object
     */
    public Object size(Object object) {
        if(object instanceof Integer) {
            return 4;
        } else if(object instanceof Character) {
            return 2;
        } else if(object instanceof String) {
            return 2;
        } else if(object instanceof Float) {
            return 4;
        } else if(object instanceof Double) {
            return 8;
        } else {
            return "UnDefined";
        }
    }
}

public class FindType {
    
    /**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
		
    	Object a = "3.0";
		
    	GetType getType = new GetType();
		
    	System.out.println("Value of a = " + a + " and type of a is " + getType.type(a) + " and size in the memory is " + getType.size(a) + " bytes.");
    }
}
