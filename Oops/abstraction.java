package Oops;

public class abstraction {
    public static void main(String[] args) {

        // Creating an object of Circle (child class)
        // Even though Shape is the parent, we cannot create its object
        // because it is an ABSTRACT CLASS.
        Circle circle = new Circle();
        circle.draw(); // Calling abstract method implementation
        circle.print(); // Calling normal method from abstract class
    }
}

// ---------------------------------------------------------------
// THEORY OF ABSTRACTION
// ---------------------------------------------------------------
//
// Abstraction = Hiding implementation details and exposing only the essentials.
// It focuses on *what to do*, not *how to do*.
//
// WHY USE ABSTRACTION?
// - To reduce complexity of the system
// - To write cleaner, structured code
// - To force subclasses to provide specific implementations
// - To avoid duplicate code in every subclass
//
// HOW ABSTRACTION IS ACHIEVED?
// - Using ABSTRACT CLASSES (0–100% abstraction)
// - Using INTERFACES (100% abstraction)
//
// ---------------------------------------------------------------
// IMPORTANT RULES OF ABSTRACT CLASS
// ---------------------------------------------------------------
// ✔ An abstract class can have BOTH abstract and normal methods
// ✔ You cannot instantiate an abstract class (cannot create its object)
// ✔ A child class MUST implement all abstract methods
// ✔ Abstract method cannot have a body (no curly braces)
// ✔ Abstract methods must be overridden in child class
// ✔ Constructors ARE allowed in abstract class (but cannot be used to create
// object)
// ✔ Abstract class can have variables, methods, constructors, blocks
// ✔ Access modifier of overridden abstract method CANNOT be reduced
// Example: if parent method is 'protected', child cannot make it 'private'
// ❌ Abstract class cannot be marked as final (final prevents inheritance)
// ❌ Abstract method cannot be private (child must override it)
// ---------------------------------------------------------------

abstract class Shape {

    // Abstract method: must be implemented by all child classes
    abstract void draw();

    // Concrete (normal) method: optional for child classes to override
    public void print() {
        System.out.println("I am from Shape Class");
    }
}

// ---------------------------------------------------------------
// CHILD CLASS 1: Circle
// ---------------------------------------------------------------
// This class MUST implement the abstract method `draw()` of Shape
class Circle extends Shape {

    // IMPLEMENTATION of the abstract method
    void draw() {
        System.out.println("Drawing a circle!!");
    }

    // NOTE:
    // We cannot define draw() as private because:
    // Abstract methods always have at least protected/public visibility.
    // Reducing visibility breaks overriding rules (compile error).
}

// ---------------------------------------------------------------
// CHILD CLASS 2: Rectangle
// ---------------------------------------------------------------
class Rectangle extends Shape {

    void draw() {
        System.out.println("Drawing a Rectangle!!");
    }

    public void properties() {
        System.out.println("I have length and breadth (unequal sides).");
    }
}
