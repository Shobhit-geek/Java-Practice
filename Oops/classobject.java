package Oops;
// This program demonstrates the concept of CLASS and OBJECT in Java.

// ✅Why only one class is public?✔
// Rule in Java:

// In one.java file, only one class can be public. And the filename must be the 
// same as the public class name.
// It also explains constructors, the 'this' keyword, and method calling.

public class classobject {
    public static void main(String[] args) {

        // Creating an object of Car class using default constructor
        Car c = new Car();
        // Calling object's method
        c.print();
    }
}

// ------------------------ CAR CLASS ----------------------------
//
// A class is a blueprint/template that defines attributes (variables)
// and behaviors (methods) of an object.
//
// Objects are instances of a class created using the 'new' keyword.

// This is called default access or package-private class.
class Car {

    // ---------------- FIELDS / INSTANCE VARIABLES ----------------
    //
    // These variables store the state (data) of each Car object.
    // 'private' ensures data encapsulation: variables cannot be accessed directly
    // from outside this class.
    private int wheel;
    private int speed;

    // ---------------- DEFAULT CONSTRUCTOR ----------------
    //
    // Constructor is automatically called when an object is created.
    // Purpose: Initialize object variables.
    //
    // This is the no-argument constructor.
    public Car() {
        // 'this' refers to the current object's instance variables.
        this.wheel = 4;
        this.speed = 140;
    }

    // ---------------- PARAMETERIZED CONSTRUCTOR ----------------
    //
    // Used when values should be assigned at the time of object creation.
    // Example: Car c2 = new Car(6, 200);
    //
    public Car(int wheel, int speed) {
        this.wheel = wheel; // assigning argument value to instance variable
        this.speed = speed;
    }

    // ---------------- METHOD TO PRINT DATA ----------------
    //
    // Methods define the behavior/actions of objects.
    // This method prints the values stored in the Car object.
    public void print() {
        System.out.println("Wheel: " + this.wheel);
        System.out.println("Top Speed: " + this.speed);
    }
}
