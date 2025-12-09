package Collections.MapInterface.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// ✅1 ️What is a HashMap?
// A HashMap stores data in key–value pairs.

// ✅2 ️Key Features of HashMap(INTERVIEW READY)
// | Feature              | Supported            |
// | -------------------- | -------------------  |
// | Duplicate Keys       | ❌ Not allowed       |
// | Duplicate Values     | ✅ Allowed           |
// | Order Maintained     | ❌ No                |
// | One Null Key         | ✅ Allowed           |
// | Multiple Null Values | ✅ Allowed           |
// | Thread Safe          | ❌ No                |
// | Performance          | 🔥 Very Fast (O(1))  |

public class Introduction {
    public static void main(String[] args) {
        // ✅ 1. Create HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // ✅ 2. Add elements (put)
        map.put(1, "Ram");
        map.put(2, "Raj");
        map.put(3, "Ritesh");

        // ✅ 3. Duplicate key (overwrites old value)
        map.put(4, "Sonali");
        map.put(4, "Shruti");

        // ✅ 4. One null key allowed
        map.put(null, "abc");
        map.put(null, "xyz"); // This will not reflect in the map

        // ✅ 5. Multiple null values allowed
        map.put(5, null);
        map.put(6, null);

        System.out.println(map);

        // ✅ 6. Get value using key
        System.out.println("Getting value of some key: " + map.get(3));
        // ✅ 7. Check key exists or not
        System.out.println("Checking if key exists or not: "+ map.containsKey(1));
        // ✅ 8. Check value exists or not
        System.out.println("Checking if value exxists in map or not: "+ map.containsValue("Shruti"));
        
        // ✅ 9. Remove element
        map.remove(5);
        System.out.println("After remove: " + map);

        // ✅ 10. Size
        System.out.println("Size: " + map.size());

        // ✅ 11. Check empty
        System.out.println("Is empty? " + map.isEmpty());

        // ✅ 12. Clear map - remove all the elements
        // map.clear();
        // System.out.println("After clear: " + map);
        
        // Iterating over the map

        //1. Using entrySet() ✅✅ ✅ MOST IMPORTANT
        for(Map.Entry<Integer, String> i: map.entrySet()){
            System.out.println("Key: "+i.getKey()+", Value: "+i.getValue());
        }

        //2. using Iterator
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> e = it.next();
            System.out.println("Key = " + e.getKey() + 
                                ", Value = " + e.getValue());
        }

        //3. Using values() (Only values)
        // for (String value : map.values()) {
        //     System.out.println(value);
        // }

        // 4. Using keySet()
        // for (Integer key : map.keySet()) {
        //     System.out.println(key + " -> " + map.get(key));
        // }

    }
}

// ✅ 6️⃣ HashMap vs HashSet

// | HashMap                | HashSet               |
// | ---------------------- | ------------------    |
// | Stores key–value       | Stores only values    |
// | put(k, v)              | add(v)                |
// | Duplicate keys ❌       | Duplicate values ❌ |
// | Multiple null values ✅ | One null only ✅    |

//--------------------*******--------------------

// ✅ 1️⃣ What is a HashMap Internally?

// Internally, a HashMap is:

// ✅ An ARRAY OF BUCKETS
// Each bucket stores:
// → Either a LinkedList of entries (before Java 8)
// → Or a Red-Black Tree (after Java 8, when chain is long)

// Each entry is a Node:

// Node {
//    int hash;
//    K key;
//    V value;
//    Node next;
// }

// ✅ 2️⃣ What Happens When You Do:
// map.put("India", 140);

// Java performs these exact internal steps:

// 🔹 STEP 1: hashCode() is called
// int hash = "India".hashCode();

// Example:
// "India".hashCode() → 70793495  (random-looking number)

// 🔹 STEP 2: Bucket Index Is Calculated

// Formula: index = (n - 1) & hash
// Where:
// n = size of array (default = 16)
// hash = hashCode value

// Example:

// index = (16 - 1) & 70793495
// index = 15 & 70793495
// index = 7  (example)

// ✅ So data goes into: bucket[7]

// 🔹 STEP 3: Store Entry in Bucket

// If bucket is empty:
// bucket[7] → [ India=140 ]

// ✅ 3️⃣ Collision (MOST IMPORTANT CONCEPT)

// Now insert:
// map.put("China", 150);

// If: "China".hashCode() → SAME index 7

// ✅ This is called a COLLISION.

// Then structure becomes:
// bucket[7] → [ India=140 ] → [ China=150 ]

// This uses: SINGLY LINKED LIST

// ✅ 4️⃣ How Duplicate Keys Are Detected

// Now you do: map.put("India", 142);

// Java checks:
// 1️⃣ hashCode() → same bucket
// 2️⃣ equals() → compares key with existing keys

// If: key.equals(existingKey) == true

// ✅ Then: Old value is REPLACED

// Result:
// bucket[7] → [ India=142 ] → [ China=150 ]

// ❗ This is why both hashCode() and equals() MUST be overridden together.

// ✅ 5️⃣ Java 8 Improvement — Treeification 🌳

// If too many collisions in one bucket:

// LinkedList length > 8  ✅
// AND
// Total capacity ≥ 64    ✅

// Then Java converts:  LinkedList → Red-Black Tree

// So structure becomes:
// bucket[7] → 🌳 Balanced Tree

// ✅ Why?
// Lookup time improves from:
// O(n) → O(log n)

// ✅ 6️⃣ Resizing (Rehashing) — VERY IMPORTANT

// Default values:

// Property	Value
// Initial Capacity	16
// Load Factor	0.75

// Resize condition:
// If size ≥ (capacity × loadFactor)

// Example:
// 16 × 0.75 = 12

// At 13th insertion:
// HashMap RESIZES → 32

// Then:
// ✅ ALL elements are rehashed and redistributed.

// ✅ 7️⃣ FULL INTERNAL FLOW IN ONE VIEW
// put(key, value)
//      ↓
// hashCode() of key
//      ↓
// index = (n-1) & hash
//      ↓
// Check bucket[index]
//      ↓
// If empty → insert
// If not empty → equals() check
//      ↓
// If same key → replace value
// If different → add to list / tree
//      ↓
// If size > threshold → resize

// ✅ 8️⃣ ASCII DIAGRAM (FINAL PICTURE)
// Before Collision:
// Index 0 → null
// Index 1 → null
// Index 2 → null
// Index 3 → [A=10]
// Index 4 → null
// Index 5 → [B=20]
// Index 6 → null
// Index 7 → [India=140]

// After Collision:
// Index 7 → [India=140] → [China=150] → [USA=130]

// After Treeification (Java 8+):
// Index 7 → 🌳 Red-Black Tree
//              India=140
//             /         \
//         China=150    USA=130

// ✅ 9️⃣ Why equals() & hashCode() Are CRITICAL

// If you don’t override them properly:

// ❌ Duplicate keys will be stored
// ❌ HashMap lookup will fail
// ❌ Data corruption can happen

// ✅ Rule:
// If two objects are equal using equals(), they MUST have the same hashCode().

// ✅ 10. Interview One-Liners (Must Memorize)

// ✅ HashMap uses hashing technique
// ✅ Data is stored in array of buckets
// ✅ Collisions are handled using:

// LinkedList (before Java 8)
// Red-Black Tree (after Java 8)

// ✅ Time Complexity:

// Average → O(1)
// Worst    → O(n)
// Tree     → O(log n)

// ✅ Resizing happens when:
// size > capacity × 0.75

// Fail-Fast vs Fail-Safe
