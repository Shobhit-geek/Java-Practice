package Collections.SetInterface.TreeSet;

import java.util.*;

/*
=========================================================
✅ TreeSet - THEORY (INTERVIEW READY)
=========================================================

1️⃣ TreeSet implements NavigableSet → SortedSet → Set.
2️⃣ It STORES elements in SORTED ORDER automatically.
3️⃣ It does NOT allow DUPLICATES.
4️⃣ It does NOT allow NULL values.
5️⃣ Internally it uses:
    ✅ Red-Black Tree (Self-balancing BST)
6️⃣ Sorting happens based on:
    ✅ Comparable (Natural Order)
    ✅ Comparator (Custom Order)
7️⃣ Performance:
    ❌ Slower than HashSet and LinkedHashSet

✅ Best Use Case:
- When you need UNIQUE + SORTED data
- Example:
    ✅ Leaderboard scores
    ✅ Sorted IDs
    ✅ Ranking systems
*/

public class Introduction {
    public static void main(String[] args) {

        // ✅ 1. Creating TreeSet (Natural Sorting)
        TreeSet<Integer> set = new TreeSet<>();

        // ✅ 2. Adding elements
        set.add(40);
        set.add(10);
        set.add(30);
        set.add(20);
        set.add(10); // ❌ Duplicate (ignored)

        // ❌ set.add(null); // ❌ ERROR → TreeSet does NOT allow null

        // ✅ Automatically sorted
        System.out.println("After adding elements: " + set);
        // Output: [10, 20, 30, 40]

        // ✅ 3. Size
        System.out.println("Size: " + set.size());

        // ✅ 4. Searching
        System.out.println("Contains 20? " + set.contains(20));
        System.out.println("Contains 99? " + set.contains(99));

        // ✅ 5. Removing elements
        set.remove(30);
        System.out.println("After removal: " + set);

        // ✅ 6. Iterating using Iterator
        System.out.println("Using Iterator:");
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // ✅ 7. Using for-each
        System.out.println("Using for-each:");
        for (Integer num : set) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ✅ 8. First & Last elements
        System.out.println("First element: " + set.first());
        System.out.println("Last element: " + set.last());

        // ✅ 9. Lower, Higher, Floor, Ceiling (VERY IMPORTANT)
        System.out.println("Lower than 25: " + set.lower(25)); // < 25
        System.out.println("Higher than 25: " + set.higher(25)); // > 25
        System.out.println("Floor of 20: " + set.floor(20)); // <= 20
        System.out.println("Ceiling of 20: " + set.ceiling(20)); // >= 20

        // ✅ 10. Poll operations
        System.out.println("Poll First: " + set.pollFirst());
        System.out.println("Poll Last: " + set.pollLast());
        System.out.println("After polling: " + set);

        // ✅ 11. Adding multiple elements using addAll()
        TreeSet<Integer> extraSet = new TreeSet<>();
        extraSet.add(100);
        extraSet.add(200);

        set.addAll(extraSet);
        System.out.println("After addAll(): " + set);

        // ✅ 12. Retain only common elements
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(20);
        set2.add(200);

        set.retainAll(set2);
        System.out.println("After retainAll(): " + set);

        // ✅ 13. Convert TreeSet to List
        List<Integer> list = new ArrayList<>(set);
        System.out.println("Converted to List: " + list);

        // ✅ 14. Convert TreeSet to Array
        Integer[] arr = set.toArray(new Integer[0]);
        System.out.println("Converted to Array: " + Arrays.toString(arr));

        // ✅ 15. Clear TreeSet
        set.clear();
        System.out.println("After clear(): " + set);
    }
}

// ✅ IMPORTANT INTERVIEW SUMMARY

// |Method         |Use               |
// |---------------|------------------|
// |`add()`        |Add element       |
// |`remove()`     | Remove element   |
// | `contains()`  | Search           |
// | `first()`     | Smallest element |
// | `last()`      | Largest element  |
// | `lower()`     | Just smaller     |
// | `higher()`    | Just greater     |
// | `floor()`     | ≤ value          |
// | `ceiling()`   | ≥ value          |
// | `pollFirst()` | Remove smallest  |
// | `pollLast()`  | Remove largest   |
// | `addAll()`    | Merge            |
// | `retainAll()` | Common elements  |
// | `clear()`     | Remove all       |

// ✅ LinkedHashSet vs TreeSet

// | Feature   | LinkedHashSet    | TreeSet           |
// | --------- | ---------------  | --------------    |
// | Duplicate | ❌               | ❌               |
// | Order     | ✅ Insertion     | ✅ Sorted        |
// | Null      | ✅ One           | ❌ Not allowed   |
// | Speed     | ⚡ Fast          | 🐢 Slower        |
// | Internal  | Hashtable + DLL  | Red-Black Tree    |
