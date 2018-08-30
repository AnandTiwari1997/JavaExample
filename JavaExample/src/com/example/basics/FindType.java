package com.example.basics;

class GetType {
    public String type(Object object) {
        String className = object.getClass().getSimpleName();
        return className;
        
    }
    
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
    
	public static void main (String[] args) {
		
		Object a = "3.0";
		
		GetType getType = new GetType();
		
		System.out.println("Value of a = " + a + " and type of a is " + getType.type(a) + " and size in the memory is " + getType.size(a) + " bytes.");
	}
}
