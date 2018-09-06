package com.example.basics;

/**
 * This program shows the abstraction concept.
 * 
 * @author anand.tiwari
 *
 */

abstract class Shape {
	
    private String color;
	
    /**
	 * abstract method
	 * @return area
	 */
    abstract double area();
    
    /**
     * 
     * @param color
     */
    public void setColor(String color) {
    	this.color = color;
    }
    
    /**
     * 
     * @return color
     */
    public String getColor() {
    	return this.color;
    }
    
    /**
     * abstract method
     * @return string
     */
    abstract public String toString();
	
}


class Circle extends Shape {
	
    private double radius;
    static final double pi = 3.14;
    
    /**
     * constructor
     * @param radius
     */
    public Circle(double radius) {
    	this.radius = radius;
    }

    @Override
	public double area() {
    	return pi * this.radius * this.radius;
    }

    @Override
	public String toString() {
    	return "\nArea of circle is " + area() + " and Color of the circle is " + super.getColor();
    }
	
}


class Square extends Shape {
	
    private double side;

    /**
     * Constructor
     * @param side
     */
    public Square(double side) {
    	super();
    	this.side = side;
    }

    @Override
	double area() {
        return this.side * this.side;
    }

    @Override
	public String toString() {
        return "\nArea of Square is " + area() + " and Color of Square is " + super.getColor();
    }

}


public class Abstraction {

    /**
	 * @param args
	 */
    public static void main(String[] args) {
    	
    	Circle circle = new Circle(20);
    	circle.setColor("Red");
    	System.out.println(circle);
    	
    	Shape shape = new Circle(12);
    	System.out.println(shape);
    	
    	Square square = new Square(10);
    	square.setColor("Black");
    	System.out.println(square);
    	
    	Shape shape2 = new Square(15);
    	System.out.println(shape2);
    	
    }

}
