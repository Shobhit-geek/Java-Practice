package Collections.MapInterface.Others;

public class weakhashMap {

    // ✅ 3️⃣ WeakHashMap
    // ✔ What it is

    // A special map where keys are stored as WeakReference.
    // Meaning:
    // ➡ If a key has no strong reference outside the map,
    // ➡ Garbage Collector will automatically delete the entry from the map.

    // ✔ Internal Working

    // Uses WeakReference internally.
    // When GC runs:
        // Keys with no external reference = collected
        // Corresponding entry removed
    // This helps prevent memory leaks.

    // ✔ Null Rule

    // ✔ Allows null key
    // ✔ Allows null value

    // ✔ Iteration Type
    // Fail-fast (like HashMap)

    // ✔ Example
    // WeakHashMap<Object, String> map = new WeakHashMap<>();

    // Object key1 = new Object();
    // map.put(key1, "value1");

    // System.out.println(map); // shows entry

    // key1 = null; // remove strong reference
    // System.gc(); // suggest GC

    // Thread.sleep(1000);
    // System.out.println(map); // entry removed automatically

    // ✔ When to Use?

    // Caching systems
    // Listeners / callbacks
    // Automatically removing unused keys
    // Prevent memory leaks when keys are large objects
}

// ✅ Difference Table 

// | Feature            | Hashtable    | ConcurrentHashMap    | WeakHashMap                    |
// | ------------------ | ------------ | -------------------- | ------------------------------ |
// | Thread-safe        | ✔ Yes (slow) | ✔ Yes (fast)         | ❌ No                           |
// | Null allowed?      | ❌ No         | ❌ No                 | ✔ Yes                          |
// | Iteration          | Fail-fast    | Fail-safe            | Fail-fast                      |
// | Performance        | Worst        | Best                 | Normal                         |
// | Internal structure | Hash buckets | CAS + buckets + tree | WeakReference buckets          |
// | Auto remove keys   | ❌ No         | ❌ No                 | ✔ Yes (GC removes unused keys) |
// | Use case           | Legacy       | Multi-threaded apps  | Caching / memory-sensitive     |
