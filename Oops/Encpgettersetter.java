package Oops;

/*
*These concepts aim to implement real-world entities in programs. (4 pillars of oops)
--Encapsulation
--Inheritance
--Abstraction
--Polymorphism

 * -------------------- ENCAPSULATION THEORY --------------------
 * Encapsulation means:
 * 1. Binding (grouping) data (variables) and methods together inside a class.
 * 2. Keeping variables PRIVATE so that they cannot be accessed directly.
 * 3. Providing PUBLIC GETTER and SETTER methods to control access.
 * 1. Binding (grouping) data (variables) and methods together inside a class.
 * 2. Keeping variables PRIVATE so that they cannot be accessed directly.
 * 3. Providing PUBLIC GETTER and SETTER methods to control access.
 * 
 * Why Encapsulation?
 * ✔ Data protection (no direct modification)
 * ✔ Control over how data is changed (via setter)
 * ✔ Helps in maintaining code security and readability
 *
 * Example:
 * - Animal class has two private fields: type, speak
 * - They cannot be accessed directly from outside
 * - They can be accessed only through methods: setValue() and getValue()
 *
 * This is the main purpose of Encapsulation in OOP.
 * --------------------------------------------------------------
 */

public class Encpgettersetter {

    public static void main(String[] args) {

        // Step 1: Create object of Animal class
        // This allocates memory and allows access to its public methods
        Animal animal = new Animal();

        // Step 2: Use setter method to assign values
        // We cannot do animal.type = "Cow"; because 'type' is private
        animal.setValue("Cow", "Moo");

        // Step 3: Use getter method to retrieve values
        // getValue() returns a formatted string
        System.out.println(animal.getValue());
    }
}

// ------------------- ANIMAL CLASS (Encapsulated) -------------------
class Animal {

    // Step A: Private variables (DATA HIDING)
    // These cannot be accessed directly outside this class
    private String type;
    private String speak;

    // Step B: PUBLIC Setter method
    // Purpose: To provide controlled way to MODIFY variable values
    public void setValue(String type, String speak) {

        // 'this' refers to the current object’s variables
        this.type = type;
        this.speak = speak;
    }

    // Step C: PUBLIC Getter method
    // Purpose: To provide controlled way to READ variable values
    public String getValue() {

        // Returning a formatted message
        return "The Animal is: " + this.type + " and its language is: " + this.speak;
    }
}
