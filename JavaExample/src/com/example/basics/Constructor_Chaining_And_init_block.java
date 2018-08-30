package com.example.basics;

class Temp
{
	// block to be executed before any constructor.
	// every time when new object is created this block will executed.
	// this block will not executed when we call constructor using this() keyword.
	{
		System.out.println("init block");
	}

	// no-arg constructor
	Temp()
	{
		System.out.println("default");
	}

	// constructor with one argument
    Temp(int x)
    {
	// invokes default constructor
	this();
	System.out.println(x);
    }
 
    // constructor with two argument
    Temp(int x, int y)
    {
	// invokes constructor with one argument
	this(5);
	System.out.println(x * y);
    }

	public static void main(String[] args)
	{
		// Object creation by calling no-argument 
		// constructor.
		new Temp();

        System.out.println("");
        
		// Object creation by calling parameterized 
		// constructor with one parameter.
		new Temp(8, 10);
	}
}
