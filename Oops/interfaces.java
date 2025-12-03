package Oops;
// Main class
public class interfaces {
    public static void main(String[] args) {

        // Creating object of child class
        carExtended car = new carExtended();

        car.accelarate(); // Calling implemented method
        car.horn(); // Calling default method from interface
        car.start(); // Calling implemented method
        car.stopVehicle(); // ✅ Correct way to access private interface method
    }
}

// ✅ Interface
// Interface is used to achieve 100% abstraction
interface vehicle {

    // By default: public + abstract
    void start();

    // ✅ Private method (Java 9+)
    // Can be used ONLY inside this interface
    private void stop() {
        System.out.println("Stopping the vehicle!");
    }

    // ✅ Public method that internally calls private method
    default void stopVehicle() {
        stop(); // calling private method safely
    }

    // ✅ Default method (has method body)
    default void horn() {
        System.out.println("Honk Honk!!");
    }

    void accelarate();
}

// ✅ Abstract class implementing interface
// It is NOT required to implement all methods
abstract class car implements vehicle {

    // Own abstract method
    abstract void wheel();
}

// ✅ Concrete class (fully implemented)
class carExtended extends car {

    // Implementing interface method
    public void start() {
        System.out.println("Starting the vehicle!");
    }

    // Implementing abstract class method
    public void wheel() {
        System.out.println("4 wheels");
    }

    // Implementing interface method
    public void accelarate() {
        System.out.println("Car has nice acceleration");
    }
}

// ✅ Another implementation of interface
class bike implements vehicle {

    public void start() {
        System.out.println("Starting the bike!");
    }

    // ❌ Removed wheel() because bike does NOT extend car
    // ✅ Added horn() override (optional)

    public void horn() {
        System.out.println("Bike horn sound!");
    }

    public void accelarate() {
        System.out.println("Bike has fast acceleration");
    }

    // ✅ Required because interface has private stop()
    // But we access it only through default method
}

// 📘 INTERFACE THEORY (CORE CONCEPTS)
// ✅ What is Interface?

// An interface is a blueprint of a class that contains abstract methods.

// It supports:
// ✔ 100% abstraction
// ✔ Multiple inheritance
// ✔ Standardization
// ✔ Loose coupling

// ✅ What can an Interface have?
// Feature	            Allowed
// Abstract methods	    ✅ Yes
// Default methods	    ✅ Yes
// Static methods	    ✅ Yes
// Private methods (Java 9+)	✅ Yes
// Constructors	        ❌ No
// Instance variables	❌ No

// ✅ Interface Method Rules
// Rule	                Valid?
// void start();	    ✅ Yes
// private void stop();	✅ Yes (Java 9+)
// default void horn()	✅ Yes
// protected void test()	❌ No

// ✅ Why Private Methods in Interface?

// Private methods:
// ✔ Avoid code duplication
// ✔ Used as helper methods
// ✔ Can be called only from: default methods and static methods

// ❌ Cannot be:
// Called from main
// Overridden by classes
// Accessed using object

// ✅ Abstract Class + Interface Together
// abstract class car implements vehicle

// This means:
// ✔ car inherits vehicle behavior
// ✔ car can:
    // leave methods unimplemented
    // add additional behavior (wheel())



// ----------------- ABSTRACT + INTERFACE DEEP DIVE --------------------------------------

// When an abstract class implements an interface, here is exactly what happens:

// ✅ 1. The abstract class is not required to implement all interface methods
// Because the class is abstract, it is allowed to leave some (or all) interface 
// methods unimplemented.

// Example:

// interface Animal {
//     void eat();
//     void sleep();
// }

// abstract class Dog implements Animal {
//     // implements only one method
//     public void eat() {
//         System.out.println("Dog is eating");
//     }

//     // sleep() is not implemented → allowed because Dog is abstract
// }

// No error occurs because Dog is abstract.

// ✅ 2. If a non-abstract subclass extends this abstract class → it must implement remaining methods
// class Puppy extends Dog {
//     public void sleep() {
//         System.out.println("Puppy sleeping");
//     }
// }

// Now everything is implemented → valid.

// ✅ 3. An abstract class can also add its own methods

// Unlike interfaces, abstract class can have:
// Constructors
// Instance variables
// Concrete (normal) methods
// Abstract methods
// Blocks
// Final methods, Static methods, etc.
// So abstract classes can mix interface behavior + their own structure.

// ✅ 4. Why use abstract class + interface together?

// ✔ To provide partial implementation of an interface
// Let the abstract class implement common logic and force subclasses to complete it.
// ✔ To avoid repeating code
// Multiple subclasses share some functionality.
// ✔ To add additional common features
// Interface only contains methods, but abstract class can add fields and constructors.