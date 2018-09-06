package com.example.basics;

/**
 * This program shows the use of wrapper class in swapping the objects of same class.
 * Wrapper class solution works even if the user class doesn’t have access to
 * members of the class whose objects are to be swapped.
 * @author anand.tiwari
 *
 */
class Car {

    private int model;
    private int nmber;
	
    /**
     * 
     * @param model
     * @param nmber
     */
    public Car(int model, int nmber) {
    	this.model = model;
    	this.nmber = nmber;
    }

    @Override
    public String toString() {
    	return "Car Number : " + this.nmber + " and Model Number : " + this.model;
    	
    }
}

class CarWrapper {
    Car c;
	
    /**
     * 
     * @param c
     */
    public CarWrapper(Car c) {
    	this.c = c;
    }
}

public class ObjectSwap {
	
    /**
	 * 
	 * @param cw1
	 * @param cw2
	 */
    public void swapObject(CarWrapper cw1, CarWrapper cw2) {
    	Car temp = cw1.c;
    	cw1.c = cw2.c;
    	cw2.c = temp;
    }

    /**
	 * 
	 * @param args
	 */
    public static void main(String[] args) { 
    	Car car1 = new Car(100, 1);
    	Car car2 = new Car(200, 2);
    	CarWrapper cw1 = new CarWrapper(car1);
    	CarWrapper cw2 = new CarWrapper(car2);
    	
    	ObjectSwap objectSwap = new ObjectSwap();
    	objectSwap.swapObject(cw1, cw2);
    	
    	System.out.println(cw1.c);
    	System.out.println(cw2.c);
    }

}
