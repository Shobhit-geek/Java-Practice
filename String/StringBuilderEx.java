package String;

// StringBuilder is a mutable (changeable) sequence of characters in Java.
// Unlike String, which is immutable, a StringBuilder object can be modified without creating new objects.
public class StringBuilderEx{
    public static void main(String[] args) {
        String s = "hello";
        s = s + " world"; // creates NEW string object
        // Every modification creates a new object → slow, especially in loops.
        System.out.println(s);

        StringBuilder sb = new StringBuilder("Shobhit");

        // Append: Adds to the end of the StringBuilder
        // Syntax: sb.append(value);
        sb.append(" Raj");
        System.out.println(sb);

        // Insert: Inserts at a specific position
        // Syntax: sb.insert(index, value);
        sb.insert(0, "infy");
        System.out.println(sb);

        // Replace: Replaces characters in a specified range
        // Syntax: sb.replace(startIndex, endIndex, value);
        sb.replace(0, 4, "Infosys");
        System.out.println(sb);

        // Delete: Removes characters in a specified range
        // Syntax: sb.delete(startIndex, endIndex);
        sb.delete(0, 7);
        System.out.println(sb);

        // Reverse: Reverses the sequence of characters
        // Syntax: sb.reverse();
        sb.reverse();
        System.out.println(sb);

        // Capacity: Returns the current capacity of the StringBuilder
        // Syntax: sb.capacity();
        System.out.println("Capacity: " + sb.capacity());

        // EnsureCapacity: Ensures the capacity is at least the specified minimum
        // Syntax: sb.ensureCapacity(minCapacity);
        sb.ensureCapacity(50);
        System.out.println("New Capacity: " + sb.capacity());

        // Length: Returns the number of characters in the StringBuilder
        // Syntax: sb.length();
        System.out.println("Length: " + sb.length());

        // CharAt: Returns the character at the specified index
        // Syntax: sb.charAt(index);
        System.out.println("Character at index 2: " + sb.charAt(2));

        // Substring: Returns a substring from the specified range
        // Syntax: sb.substring(startIndex, endIndex);
        System.out.println("Substring (1, 4): " + sb.substring(1, 4));
    }
}

// When to Use What?
// ✔ Use String when:
// 1. You have few concatenations
// 2. String won’t change much

// ✔ Use StringBuilder when:
// 1. You need high performance
// 2. You build strings in loops
// 3. Single-threaded code

// ✔ Use StringBuffer when:
// 1. You need thread-safe operations

// StringBuilder sb = new StringBuilder();
// Default capacity = 16 characters
// If exceeded → capacity increases dynamically:
// Formula: newCapacity = (oldCapacity * 2) + 2