package com.example.basics;

public class Test
{
    // This is static variable.
    // It does not require object for access.
    // It's value is same for all objects.
    static int x = 11;
    
    // This is Instance variable.
    // It require object for access.
    // Its value is different for different object.
    private int y = 33;
    
    /**
     * 
     * @param x
     */
    public void setX(int x) {
        // x passed in the argument is a local variable.
        // It is not accessible outside this function.
        // this() keyword is used to differentiate between class and local variable.
        Test.x = x;
    }
    
    /**
     * 
     * @return test.x
     */
    public int getX() {
        return Test.x;
    }
 
    /**
     * 
     * @param y
     */
    public void setY(int y) {
        // y passed in the argument is a local variable.
        // It is not accessible outside this function.
        // this() keyword is used to differentiate between instance and local variable.
        this.y = y;
    }
    
    /**
     * 
     * @return this.y
     */
    public int getY() {
        return this.y;
    }
 
    /**
     * 
     * @param args
     */
    public static void main(String args[])
    {
        Test t1 = new Test();
        Test t2 = new Test();
        
        t1.setX(44);
        t1.setY(11);
        
        t2.setX(55);
        t2.setY(22);

 
        System.out.println("Test.x: " + Test.x);
        System.out.println("t1.x: " + t1.getX());
        System.out.println("t1.y: " + t1.getY());
        System.out.println("t2.x: " + t2.getX());
        System.out.println("t2.y: " + t2.getY());
    }
}
