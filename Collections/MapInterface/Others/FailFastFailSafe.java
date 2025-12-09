package Collections.MapInterface.Others;

public class FailFastFailSafe {

    // 🚦 Fail-Fast vs Fail-Safe Iterators
    // This is one of the most important concepts in Collections + Multi-threading interviews.

    // ✅ 1️⃣ What is a Fail-Fast Iterator?

    // A fail-fast iterator immediately throws an exception if you modify the collection structurally while iterating.
    // Structural Modification =
        // 👉 add
        // 👉 remove
        // 👉 clear
        // 👉 resize
        // 👉 rehash

    // ✔ Behavior
        // If the collection is modified while iterating, it throws:
            // java.util.ConcurrentModificationException

    // ✔ Why does this happen?

    // Fail-fast collections maintain a variable called: 
    // modCount

        // Every structural change increases modCount.
        // Iterator stores a snapshot of modCount as expectedModCount.
        // If both become different → modification detected → throw exception.

    // ✔ Collections that are Fail-Fast

        // ArrayList
        // LinkedList
        // HashMap
        // HashSet
        // TreeMap
        // TreeSet

    // Basically all normal collections in java.util package.

    // ✔ Example (throws exception)
    // List<Integer> list = new ArrayList<>();
    // list.add(1); list.add(2); list.add(3);

    // for(Integer num : list){
    //     list.add(4); // ❌ structural modification
    // }
    // 👉 Will throw ConcurrentModificationException


    // ✅ 2️⃣ What is a Fail-Safe Iterator?

    // A fail-safe iterator does NOT throw any exception even if the collection is modified while iterating.

    // ✔ Why?
    // They operate on a shallow copy of the collection.

    // Meaning:
    // ➡ The iterator sees the old snapshot
    // ➡ Modifications happen on the actual collection
    // ➡ Iterator is never affected

    // ✔ Collections that are Fail-Safe

        // ConcurrentHashMap
        // CopyOnWriteArrayList
        // CopyOnWriteArraySet
    // These are from java.util.concurrent package.

    // ✔ Example (NO exception)
    // ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

    // map.put(1, "A");
    // map.put(2, "B");

    // for(Integer key : map.keySet()){
    //     map.put(3, "C");  // ✔ Allowed
    // }

    // 👉 No exception
    // 👉 Because iterator used a separate internal copy

}
