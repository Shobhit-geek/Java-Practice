package Collections.MapInterface.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

// 📘 1. What is LinkedHashMap?
// LinkedHashMap is a HashMap that maintains insertion order.

// ✔ Features:

// Maintains insertion order
// Stores key–value pairs
// Allows one null key and multiple null values

// Based on:
    // Hash table (fast access)
    // Doubly Linked List (order)

// 🧠 2. Internal Working (Easy Explanation)

// HashMap stores data like:
// Bucket → Node(key, value, next)

// LinkedHashMap adds:
// Doubly Linked List:
// head <-> node1 <-> node2 <-> node3 <-> tail
// 👉 So entries remain in the same order they were inserted.

public class Introduction {

    // |Operation         |Meaning                 |
    // |------------------|------------------------|
    // |put(k, v)         | Insert key-value       |
    // | get(k)           | Retrieve value         |
    // | remove(k)        | Remove entry           |
    // | containsKey(k)   | Key exists or not      |
    // | containsValue(v) | Value exists or not    |
    // | size()           | Count entries          |
    // | clear()          | Remove all             |
    // | keySet()         | Get all keys           |
    // | values()         | Get all values         |
    // | entrySet()       | Get (key, value) pairs |

    public static void main(String[] args) {

        // Creating LinkedHashMap
        // Maintains insertion order
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();

        // 1️⃣ put() → Insert elements
        lhm.put(10, "Apple");
        lhm.put(20, "Banana");
        lhm.put(30, "Mango");
        lhm.put(40, "Orange");
        lhm.put(null, "NullKey"); // allowed
        lhm.put(50, null);        // null values allowed

        System.out.println("LinkedHashMap: " + lhm);

        // 2️⃣ get() → Retrieve value for a key
        System.out.println("Value of key 20: " + lhm.get(20));

        // 3️⃣ containsKey() & containsValue()
        System.out.println("Contains key 30? " + lhm.containsKey(30));
        System.out.println("Contains value 'Banana'? " + lhm.containsValue("Banana"));

        // 4️⃣ remove() → Remove key
        lhm.remove(30);
        System.out.println("After removing key 30: " + lhm);

        // 5️⃣ size()
        System.out.println("Size: " + lhm.size());

        // 6️⃣ keySet() → All keys
        System.out.println("Keys: " + lhm.keySet());

        // 7️⃣ values() → All values
        System.out.println("Values: " + lhm.values());

        // 8️⃣ entrySet() → Iterate using entries
        // how we are iterating over map like that we can iterate over linkedhashmap
        System.out.println("\nIteration using entrySet:");
        for (Map.Entry<Integer, String> entry : lhm.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 9️⃣ clear() → Remove everything
        lhm.clear();
        System.out.println("\nAfter clear(): " + lhm);
    }
}
