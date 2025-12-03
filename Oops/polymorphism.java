package Oops;

// ------------------------------------------------------------
// POLYMORPHISM IN JAVA - THEORY + CONCEPTS
// ------------------------------------------------------------
//
// POLYMORPHISM = "Many Forms"
// A single action behaves differently based on the object.
//
// Example idea:
// - Animal makes sound → Dog barks, Cat meows, Cow moos
// - Shape draws → Circle draws circle, Rectangle draws rectangle
//
// ------------------------------------------------------------
// TYPES OF POLYMORPHISM IN JAVA
// ------------------------------------------------------------
//
// 1️⃣ COMPILE-TIME POLYMORPHISM (Method Overloading)
// ------------------------------------------------------------
// - Same method name, different parameters
// - Decided by compiler, hence "compile-time"
// - Example: print(int), print(double), print(String)
// - Faster because resolved during compilation
//
// Rules for Method Overloading:
// ✔ Different type of parameters OR
// ✔ Different number of parameters OR
// ✔ Different order of parameters
// ✘ Return type alone cannot be different
//
// 2️⃣ RUNTIME POLYMORPHISM (Method Overriding)
// ------------------------------------------------------------
// - Same method name & same parameters in parent and child class
// - Resolved at runtime based on actual object
// - Example:
//       Animal a = new Dog();
//       a.sound();   // Calls Dog's sound() not Animal's
//
// Rules for Method Overriding:
// ✔ Must have same method signature
// ✔ Access modifier cannot be reduced (public → protected ❌)
// ✔ Only inherited methods can be overridden
// ✔ Constructors cannot be overridden
// ✔ Final methods cannot be overridden
//
// ------------------------------------------------------------
// WHY POLYMORPHISM IS IMPORTANT?
// ------------------------------------------------------------
// ✔ Supports flexibility and reusability
// ✔ Enables dynamic behavior (runtime polymorphism)
// ✔ Reduces code duplication
// ✔ Helps in achieving clean and scalable OOP design
//
// ------------------------------------------------------------
// WHEN TO USE POLYMORPHISM?
// ------------------------------------------------------------
// ✔ When different classes must show different results for same method
// ✔ When parent reference must call child class overridden method
// ✔ When designing frameworks/libraries
//
// ------------------------------------------------------------

public class polymorphism {
    public static void main(String[] args) {

        // OVERLOADING EXAMPLE

        // Creating object of class 'overloading'
        overloading ol = new overloading();

        // Calling add(int, int)
        System.out.println("addition of 2 numbers: " + ol.add(2, 3));

        // Calling add(double, double)
        System.out.println("addition of 2 numbers: " + ol.add(2.123, 3.334));

        // Calling add(int, int, int)
        System.out.println("addition of 2 numbers: " + ol.add(2, 3, 4));

        // OVERRIDING EXAMPLE

        // Parent class reference and object
        Animal animal = new Animal();
        animal.speak(); // Calls Animal class method

        // Child class object
        cat cat = new cat();
        cat.speak(); // Calls overridden method in cat class
    }
}

// ===========================
// METHOD OVERLOADING EXAMPLE
// ===========================
class overloading {

    // Method 1: takes two int arguments
    public int add(int a, int b) {
        return a + b;
    }

    // Method 2: same name but different parameter type (double)
    public double add(double a, double b) {
        return a + b;
    }

    // Method 3: same name but different number of parameters
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

// ===========================
// METHOD OVERRIDING EXAMPLE
// ===========================
class Animal {

    // Parent class method
    public void speak() {
        System.out.println("Animal makes sound");
    }
}

// Child class overriding speak()
class cat extends Animal {
    @Override
    public void speak() {
        System.out.println("cat makes meow sound");
    }
}

// Another child class overriding speak()
class Dog extends Animal {
    @Override
    public void speak() {
        System.out.println("Dog makes bark sound");
    }
}

// ------------------------------------------------------------
// METHOD DISPATCH IN JAVA
// ------------------------------------------------------------
//
// Method Dispatch = How Java decides WHICH method to call.
//
// ------------------------------------------------------------
// 1️⃣ STATIC METHOD DISPATCH (Compile-Time Dispatch)
// ------------------------------------------------------------
// - Happens at compile time
// - Used in METHOD OVERLOADING
// - Decision based on METHOD SIGNATURE + PARAMETER TYPE
// - Reference type is important
//
// Example:
//
// class Calculator {
// void add(int a, int b) {
// System.out.println("Int version");
// }
//
// void add(double a, double b) {
// System.out.println("Double version");
// }
// }
//
// public static void main(String[] args) {
// Calculator c = new Calculator();
// c.add(10, 20); // Calls add(int,int) → decided at compile-time
// c.add(10.5, 20.7); // Calls add(double,double) → compile-time
// }
//
// ------------------------------------------------------------
// 2️⃣ DYNAMIC METHOD DISPATCH (Run-Time Dispatch)
// ------------------------------------------------------------
// - Happens at RUN-TIME
// - Used in METHOD OVERRIDING
// - Decision is based on OBJECT TYPE (not reference type)
// - Core of runtime polymorphism
//
// Example:
//
// class Animal {
// void sound() { System.out.println("Animal sound"); }
// }
//
// class Dog extends Animal {
// void sound() { System.out.println("Dog barks"); }
// }
//
// public static void main(String[] args) {
// Animal a = new Dog(); // Reference = Animal, Object = Dog
// a.sound(); // Calls Dog's sound() → decided at runtime
// }
//
// ------------------------------------------------------------
// SUMMARY:
// Compile-time (static) → Overloading
// Runtime (dynamic) → Overriding
//
// ------------------------------------------------------------
