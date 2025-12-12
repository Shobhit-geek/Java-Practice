package Collections.concurrentClass;

public class copyonwriteArrayList {
    
    // ✅ 1. CopyOnWriteArrayList — Most Important Interview Points
    // 📌 What is CopyOnWriteArrayList?

    // A thread-safe variant of ArrayList where every write operation (add, set, remove) creates a new copy of the underlying array.

    // 🔧 How it Works Internally
    // When you modify the list:

    // It performs:

    // copy = Arrays.copyOf(oldArray)
    // copy[index] = newValue
    // array = copy  // atomic volatile write

    // Readers always see a consistent snapshot.
    // Writers make a full copy → slow for frequent writes.
    // No locking for read, only for write, using ReentrantLock.

    // 🎯 When to Use CopyOnWriteArrayList (Real-world scenarios)

    // Use when:
    // Reads are 95–99%, writes are very rare

    // Example:

    // List of system events listeners
    // List of frequently-read config items
    // Caches that rarely update
    // Observer patterns

    // 🛑 When NOT to Use It

    // ❌ When writes are frequent
    // ❌ When list size is large (copy is expensive)
    // ❌ Realtime applications (due to copying cost)

    // | Feature             | CopyOnWriteArrayList       | SynchronizedList            |
    // | ------------------- | -------------------------- | --------------------------- |
    // | Read performance    | ⭐ Very high                | ❌ Slow (lock on every read) |
    // | Write performance   | ❌ Slow (copy entire array) | Medium                      |
    // | Fail-safe iterator? | **Yes**                    | ❌ No                        |
    // | Concurrent reads?   | **Yes**                    | No                          |

    // 🧷 Fail-Safe Iterator

    // Iterator does NOT throw ConcurrentModificationException.
    // Because it iterates over a snapshot array, not the live array.

    // 🧪 Small Example (Very Interview-Friendly Code)
    // CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    // list.add("A");
    // list.add("B");

    // // Snapshot iterator – will not throw CME
    // for(String s : list) {
    //     System.out.println(s);
    //     list.add("C"); // Allowed!
    // }
    // System.out.println(list);


    // Output:

    // A
    // B
    // [A, B, C, C]


    // Why?
    // Because iterator uses old snapshot → ["A", "B"].

    // 🎤 Frequently Asked Interview Questions

    // 1️⃣ Why does CopyOnWriteArrayList not throw ConcurrentModificationException?
    // Because iterator works on a snapshot, not on the live array.

    // 2️⃣ What is the main drawback of CopyOnWriteArrayList?
    // High memory + CPU usage for write operations.

    // 3️⃣ Is CopyOnWriteArrayList good for write-heavy systems?
    // No, only for read-heavy systems.

    // 4️⃣ Does CopyOnWriteArrayList allow null values?
    // Yes, it allows null (unlike ConcurrentHashMap).

    // 5️⃣ Is it ordered?
    // Yes, keeps insertion order (same as ArrayList).

}
