package Collections.MapInterface.Others;

import Oops.interfaces;

public class concurrentHashMAp {
    // ✅ 2️⃣ ConcurrentHashMap

    // ✔ What it is
    // Modern, high-performance thread-safe map.
    // Introduced in Java 5.
    // Replaces Hashtable.
    // Very fast because uses Lock Striping / Bucket-Level Locking (not full map lock).

    // ✔ Internal Working (Important for Interview)

        // Older versions (JDK 7):
        // Divided into segments, each segment locked separately.

        // Newer versions (JDK 8+):

        // No segments.
        // Uses:
        // CAS operations (Compare-And-Swap)
        // Synchronized blocks only on specific bins
        // TreeNodes (red-black tree) for high-collision buckets
        // This makes it extremely fast.

    // ✔ Null Rule
        // ❌ No null key
        // ❌ No null value

    // Reason: In multi-threaded environment it's impossible to differentiate:
    // null meaning "key not found"
    // null meaning "value is null"

    // ✔ Iteration Type
    // Fail-safe
    // (iterators don’t throw ConcurrentModificationException)
    // Because CHM reads from an internal copy during iteration.

    // ****It implements Serializable, ConcurrentMap<K,​ V>, Map<K,​ V> interfaces and 
    // extends  AbstractMap<K, ​V> class.

    // ✔ Example
    // ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    // map.put("A", 10);
    // map.put("B", 20);
    // map.putIfAbsent("C", 30);

    // map.forEach((k, v) -> System.out.println(k + " = " + v));

    // ✔ When to Use?

    // Multi-threaded applications
    // High concurrency systems
    // Real-time applications
    // Web servers, caching, live data access
}
