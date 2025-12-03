package Oops;
// ----------------------------------------------
// Inheritance Example in Java
// ----------------------------------------------
// THEORY:
// Inheritance allows one class (child/subclass) to acquire the 
// properties and behaviors (methods/variables) of another class 
// (parent/superclass).
//
// BENEFITS OF INHERITANCE:
// 1. Code reusability
// 2. Reduces duplication
// 3. Supports method overriding (runtime polymorphism)
// 4. Helps build hierarchical class structures
//
// ----------------------------------------------------------
// INHERITANCE IN JAVA
// ----------------------------------------------------------
// TYPES OF INHERITANCE SUPPORTED IN JAVA (through classes):
// 1. Single Inheritance
// 2. Multilevel Inheritance
// 3. Hierarchical Inheritance
//
// NOT SUPPORTED:
// ❌ Multiple inheritance using classes (Diamond problem)
//   → Can be achieved using interfaces
//
// This file contains examples of:
// - Your original single inheritance (Dog → Animal)
// - Multilevel inheritance (BabyDog extends Dog)
// - Hierarchical inheritance (Cat and Dog both extend Animal)
// ----------------------------------------------------------

public class inheritance {
    public static void main(String[] args) {

        System.out.println("=== Single Inheritance Example ===");
        Dog dog = new Dog();
        dog.Bark();                // Child class method
        dog.Eating("Dog");         // Inherited method from Animal

        System.out.println("\n=== Multilevel Inheritance Example ===");
        BabyDog bd = new BabyDog();
        bd.Weep();                 // BabyDog method
        bd.Bark();                 // Inherited from Dog
        bd.Eating("BabyDog");      // Inherited from Animal

        System.out.println("\n=== Hierarchical Inheritance Example ===");
        Cat cat = new Cat();
        cat.Meow();                // Cat method
        cat.Eating("Cat");         // Inherited from Animal
    }
}

// ----------------------------------------------------------
// PARENT CLASS (Super Class)
// ----------------------------------------------------------
class Animal {
    public void Eating(String animal) {
        System.out.println(animal + " is eating..");
    }
}

// ----------------------------------------------------------
// SINGLE INHERITANCE EXAMPLE
// Dog extends Animal → one parent, one child
// ----------------------------------------------------------
class Dog extends Animal {
    public void Bark() {
        System.out.println("Dog barks!!");
    }
}

// ----------------------------------------------------------
// MULTILEVEL INHERITANCE EXAMPLE
// BabyDog → Dog → Animal (3-level chain)
// ----------------------------------------------------------
class BabyDog extends Dog {
    public void Weep() {
        System.out.println("BabyDog is weeping..");
    }
}

// ----------------------------------------------------------
// HIERARCHICAL INHERITANCE EXAMPLE
// Cat and Dog BOTH extend Animal
// ----------------------------------------------------------
class Cat extends Animal {
    public void Meow() {
        System.out.println("Cat meows!!");
    }
}
