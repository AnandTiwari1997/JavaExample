package com.example.basics;

import java.util.Date;

/**
 * This program shows the usage of class Object methods and how we can override them for our purpose.
 * @author anand.tiwari
 *
 */
public class ObjectClass implements Cloneable {
	
    @Override
    public String toString() {
    	return "This Overided toString() method.";
    }
    
    @Override
    public int hashCode() {
    	System.out.println("This is Overided hashCode() method.");
    	return (int) new Date().getTime();	
    }
    
    @Override
    public boolean equals(Object object) {
    	System.out.println("This is Overided equals() method.");
    	if(object == this) {
            return true;
    	}
    	
    	if(object instanceof ObjectClass) {
            return true;
    	}else {
            return false;
    	}
    }
    
    @Override
    public void finalize() {
    	System.out.println("This is the Overided finalize() method.");
    }
    
    @Override
    public ObjectClass clone() throws CloneNotSupportedException {
    	System.out.println("This is Overided clone() method.");
    	ObjectClass objectClass = this;
    	return objectClass;
    }
    
    /**
	 * 
	 */
    public static void main(String[] args) {
    	
    	try {
    		
            ObjectClass objectClass = new ObjectClass();
            System.out.println(objectClass);
            System.out.println(objectClass.hashCode());
            ObjectClass objectClass2 = (ObjectClass) objectClass.clone();
            System.out.println(objectClass.equals(objectClass2));
            System.gc();
            
    	} catch (CloneNotSupportedException e) {
            e.printStackTrace();
    	}
    }


}
