package Collections.Enumeration;

public class Theory {
// 🔥 ENUMERATION in Java

// Enumeration is a legacy iterator used in older collection classes like:
    // Vector
    // Hashtable
    // Stack (because it extends Vector)

// It is part of the java.util package.

// ⭐ 1. Why was Enumeration created?
// Before Java 1.2 (before Collections Framework), Java had only:
    // Vector
    // Hashtable
    // Stack

// To iterate them, Java introduced Enumeration.
// Later:
    // We got Iterator
    // Then ListIterator

// But Enumeration still exists for backward compatibility.

// ⭐ 2. Enumeration Methods
// Method	                    Description
// boolean hasMoreElements()	checks if more elements exist
// E nextElement()	            returns the next element

// ⭐ 3. Enumeration Example with Vector

// import java.util.*;

// public class EnumDemo {
//     public static void main(String[] args) {
//         Vector<Integer> v = new Vector<>();

//         v.add(10);
//         v.add(20);
//         v.add(30);

//         Enumeration<Integer> en = v.elements();

//         while (en.hasMoreElements()) {
//             System.out.println(en.nextElement());
//         }
//     }
// }

// ⭐ 4. Enumeration with Hashtable

// Hashtable<Integer, String> map = new Hashtable<>();
// map.put(1, "A");
// map.put(2, "B");

// Enumeration<Integer> keys = map.keys();

// while (keys.hasMoreElements()) {
//     Integer key = keys.nextElement();
//     System.out.println(key + " = " + map.get(key));
// }

// ⭐ 5. Enumeration vs Iterator

// | Feature                            | Enumeration       | Iterator                      |
// | ---------------------------------- | ----------------- | ----------------------------- |
// | Introduced in                      | Java 1.0          | Java 1.2                      |
// | Modify collection while iterating? | ❌ No              | ✔ remove() allowed            |
// | Methods                            | 2                 | 3 (hasNext, next, remove)     |
// | Fail-Fast?                         | ❌ No              | ✔ Yes                         |
// | Used with                          | Vector, Hashtable | All modern collections        |
// | Replacement?                       | YES               | Iterator replaces Enumeration |

// ⭐ 6. Why Enumeration is NOT used today?

// ❌ Cannot remove elements
// ❌ Cannot detect ConcurrentModificationException
// ❌ Only works on legacy classes
// ❌ Too limited

// Modern Java uses:

    // Iterator
    // ListIterator
    // Enhanced for-loop (for-each)
    // Streams

// Enumeration is only used for:

    // Reading Vector, Hashtable in old codebases
    // Network APIs (like NetworkInterface enumeration)
}
