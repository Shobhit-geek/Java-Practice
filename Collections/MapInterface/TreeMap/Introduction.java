package Collections.MapInterface.TreeMap;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

// 🔷 1. What is TreeMap?

// TreeMap is a Map implementation based on Red-Black Tree (self-balancing BST).

// ✔ Stores key–value pairs
// ✔ Sorts keys in ascending order by default
// ✔ No null key allowed (but null values allowed)
// ✔ Slower than HashMap/LinkedHashMap
// ✔ Guarantees sorted order

// 🔷 2. Internal Working

// TreeMap uses Red-Black Tree, which is a self-balancing BST.

// When you insert a key:
    // It is placed in BST order
    // Balancing rotations happen automatically
    // Ensures O(log n) time for: put, get, remove

// 🔷 3. When to Use TreeMap?

// Use TreeMap when:

// ✔ You need sorted keys
// ✔ You want range operations
// ✔ You want floor/ceiling functions
// ✔ You need navigation (higher key, lower key)

// | Method         | Description      |
// | -------------- | ---------------- |
// | put(k,v)       | Insert key-value |
// | get(k)         | Retrieve value   |
// | remove(k)      | Remove key       |
// | containsKey(k) | Search           |
// | firstKey()     | Minimum key      |
// | lastKey()      | Maximum key      |
// | higherKey(k)   | Next greater key |
// | lowerKey(k)    | Next smaller key |
// | ceilingKey(k)  | ≥ key            |
// | floorKey(k)    | ≤ key            |
// | keySet()       | Sorted keys      |
// | entrySet()     | Sorted entries   |


public class Introduction {

    public static void main(String[] args) {

        TreeMap<Integer, String> tm = new TreeMap<>();

        // 1️⃣ put() – inserts in sorted order
        tm.put(50, "Apple");
        tm.put(10, "Banana");
        tm.put(30, "Cherry");
        tm.put(20, "Dates");
        tm.put(40, "Mango");

        System.out.println("TreeMap: " + tm);

        // 2️⃣ get()
        System.out.println("Value for key 20: " + tm.get(20));

        // 3️⃣ firstKey(), lastKey()
        System.out.println("Smallest Key: " + tm.firstKey());
        System.out.println("Largest Key: " + tm.lastKey());

        // 4️⃣ higherKey(), lowerKey()
        System.out.println("Key just greater than 30: " + tm.higherKey(30));
        System.out.println("Key just smaller than 30: " + tm.lowerKey(30));

        // 5️⃣ ceilingKey(), floorKey()
        System.out.println("Ceiling key of 25: " + tm.ceilingKey(25));
        System.out.println("Floor key of 25: " + tm.floorKey(25));

        // 6️⃣ Iteration (sorted order)
        System.out.println("\nIterating TreeMap:");
        for (Map.Entry<Integer, String> entry : tm.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 🎯 6. Custom Comparator TreeMap
        // Sort keys in descending order:

        // TreeMap<Integer, String> tm = new TreeMap<>(Collections.reverseOrder());
        // tm.put(10, "A");
        // tm.put(20, "B");
        // tm.put(30, "C");

        // System.out.println(tm);

        // Output: {30=C, 20=B, 10=A}
    }
}
