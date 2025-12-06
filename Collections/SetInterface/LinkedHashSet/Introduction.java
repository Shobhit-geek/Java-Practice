package Collections.SetInterface.LinkedHashSet;

import java.util.*;

/*
    =========================================================
    ✅ LinkedHashSet
    =========================================================

    1️⃣ LinkedHashSet is a child class of HashSet.
    2️⃣ It removes DUPLICATES like HashSet.
    3️⃣ It MAINTAINS INSERTION ORDER (unlike HashSet).
    4️⃣ It allows only ONE null value.
    5️⃣ Internally it uses:
        - HashTable for storage
        - Doubly Linked List for order

    ✅ Best Use Case:
    When you want UNIQUE data + ORDER must be preserved.
    Example:
    - Browser history
    - Removing duplicate words from a sentence
    - Unique ID tracking in order
*/
public class Introduction {
    public static void main(String[] args) {

        // ✅ 1. Creating LinkedHashSet
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        // ✅ 2. Adding elements
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(10);   // ❌ Duplicate (will be ignored)
        set.add(40);
        set.add(null); // ✅ One null allowed
        set.add(null); // ❌ Second null ignored

        // ✅ Insertion order is preserved
        System.out.println("After adding elements: " + set);
        // Output: [10, 20, 30, 40, null]

        // ✅ 3. Size of LinkedHashSet
        System.out.println("Size: " + set.size());

        // ✅ 4. Checking element existence
        System.out.println("Contains 20? " + set.contains(20));
        System.out.println("Contains 99? " + set.contains(99));

        // ✅ 5. Removing elements
        set.remove(30);      // removes specific element
        set.remove(null);    // removes null

        System.out.println("After removal: " + set);

        // ✅ 6. Iterating using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // ✅ 7. Iterating using For-Each loop
        System.out.println("Iterating using for-each:");
        for (Integer num : set) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ✅ 8. Checking if empty
        System.out.println("Is set empty? " + set.isEmpty());

        // ✅ 9. Converting LinkedHashSet to ArrayList
        List<Integer> list = new ArrayList<>(set);
        System.out.println("Converted to ArrayList: " + list);

        // ✅ 10. Converting LinkedHashSet to Array
        Integer[] arr = set.toArray(new Integer[0]);
        System.out.println("Converted to Array: " + Arrays.toString(arr));

        // ✅ 11. Adding multiple elements using addAll()
        LinkedHashSet<Integer> extraSet = new LinkedHashSet<>();
        extraSet.add(100);
        extraSet.add(200);

        set.addAll(extraSet);   // merges both sets
        System.out.println("After addAll(): " + set);

        // ✅ 12. Retain only common elements
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        set2.add(10);
        set2.add(200);

        set.retainAll(set2);   // keeps only common values
        System.out.println("After retainAll(): " + set);

        // ✅ 13. Clear all elements
        set.clear();
        System.out.println("After clear(): " + set);
    }
}

// ✅ IMPORTANT INTERVIEW SUMMARY
// |   Operation      |   Method               |
// |------------------|------------------------|
// |Add element       |`add()`                 |
// | Remove element   | `remove()`             |
// | Search           | `contains()`           |
// | Size             | `size()`               |
// | Multiple add     | `addAll()`             |
// | Common elements  | `retainAll()`          |
// | Remove all       | `clear()`              |
// | Convert to list  | `new ArrayList<>(set)` |
// | Convert to array | `toArray()`            |
