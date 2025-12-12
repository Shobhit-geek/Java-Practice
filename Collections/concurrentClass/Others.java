package Collections.concurrentClass;

import java.util.concurrent.ConcurrentSkipListMap;

public class Others {
    // 📌What is ConcurrentLinkedQueue?

    // A non-blocking,thread-safe,
    //     unbounded queue
    //     based on
    //     a lock-free (CAS) algorithm.

    // Located in: java.util.concurrent

    // Uses linked nodes internally, not an array.

    // 🧩Internals (How It Works)

    // Uses:
    // CAS operations (Atomic operations) to update head and tail
    // Linked list nodes (Node<E> with volatile fields)
    // No locks → avoids blocking threads

    // Operations:

    // add() → inserts at tail using CAS
    // poll() → removes from head using CAS

    // This makes it very fast for concurrent producers & consumers.

    // 📌 Characteristics
    // 1️⃣ Non-blocking, lock-free

    // Unlike BlockingQueue, this does not block on empty or full queue.
    // If queue is empty → poll() returns null, immediately.

    // 2️⃣ Unbounded
    // Grows until memory is exhausted.

    // 3️⃣ High scalability
    // Ideal for highly concurrent producers & consumers.
    
    // 4️⃣ No locking anywhere
    // No intrinsic locks, no synchronized blocks → uses CAS everywhere.

    // 🎯 When to Use ConcurrentLinkedQueue

    // Perfect for:
    // Log gathering pipeline
    // Task submission queues (non-priority)
    // Event dispatch queues
    // Multithreaded message passing
    // High-throughput systems

    // 🛑 When NOT to Use It

    // ❌ When you need blocking behavior (take() waiting for an item)
    // → Use LinkedBlockingQueue.

    // ❌ When you need bounded capacity
    // → Use ArrayBlockingQueue.

    // ❌ When ordering must be strict with heavy removals
    // → Removals inside the queue are expensive (due to traversal).

    // 🧪 Example (Very Interview-Friendly)
    // ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

    // // Producer
    // queue.add("task1");
    // queue.add("task2");

    // // Consumer
    // System.out.println(queue.poll()); // task1
    // System.out.println(queue.poll()); // task2
    // System.out.println(queue.poll()); // null (non-blocking)

    // 🧵 Multi-thread Example
    // ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

    // // Producer thread
    // new Thread(() -> {
    //     for (int i = 0; i < 5; i++) {
    //         queue.add(i);
    //     }
    // }).start();

    // // Consumer thread
    // new Thread(() -> {
    //     while (true) {
    //         Integer val = queue.poll();
    //         if (val != null) System.out.println("Consumed: " + val);
    //     }
    // }).start();

    // 🔥 Frequently Asked Interview Questions
    // 1️⃣ Is ConcurrentLinkedQueue blocking?
    // No. It is non-blocking, uses CAS.

    // 2️⃣ Which algorithm does it use?
    // Michael-Scott lock-free queue algorithm.

    // 3️⃣ Does it ever lock?
    // No. Only atomic operations (CAS).

    // 4️⃣ What happens if queue is empty?

    // poll() → returns null
    // peek() → returns null

    // 5️⃣ Is it faster than BlockingQueue?
    // Yes for concurrent throughput, but no blocking support.

    // 6️⃣ Is it FIFO?
    // Yes,strictly FIFO (linked list based).

    // 📌 Why CAS Is Used in ConcurrentLinkedQueue?

    // Because multiple threads try to update:
    // Head pointer
    // Tail pointer

    // Instead of locking, the queue does:
    // If tail is still same as before,
    //     update tail to new node (CAS)
    // Else
    //     retry

    // This avoids thread blocking → fast & scalable.


    // 🌟 Summary for Interviews

    // Lock-free
    // Uses CAS
    // Unbounded FIFO queue
    // Non-blocking
    // Very fast in multi-threaded environments
    // Best for producer-consumer where blocking isn't required

    //--------------------------***************************************

    //🚀 ConcurrentSkipListMap — Java’s Concurrent Sorted Map

    // ConcurrentSkipListMap<K, V> is:

    // ✔ A thread-safe
    // ✔ Sorted (like TreeMap)
    // ✔ Non-blocking / lock-free
    // ✔ High-performance
    // ✔ Based on Skip List (not Red-Black Tree)

    // 🔥 1. What is a Skip List? (Super Simple Explanation)

    // A Skip List is like multiple linked lists layered on top of each other:

    // Level 3:     10 --------- 30 --------- 50
    // Level 2:     10 ---- 20 ---- 30 ---- 40 ---- 50
    // Level 1:     10  15  20  25  30  35  40  45  50
    // Level 0:     (All elements)

    // High levels skip many elements → faster search O(logN).
    // Think of it like:
    // 📚 Multilevel shortcuts in a building.
    // You skip floors to reach faster.

    // 🔥 2. Why Java Uses Skip List Instead of Tree (like TreeMap)?

    // Because Skip Lists support concurrency better:

    // No global lock
    // Only small parts of list are updated
    // Allows multiple threads to read/write simultaneously
    // Very scalable
    // TreeMap uses locking, so multi-threaded performance is poor.

    // 🔥 3. Key Features of ConcurrentSkipListMap
    // ✔ Sorted Map
    // Always maintains sorted natural order (Comparable) or custom Comparator.

    // ✔ Lock-Free Reads
    // Reads happen without locking.

    // ✔ Concurrent Writes
    // Multiple threads can insert/remove at same time.

    // ✔ NavigableMap operations
    // Supports:
    // ceilingKey(), floorKey(), higherKey(), lowerKey()
    // headMap(), tailMap(), subMap()

    // 🔥 9. Internal Working Summary (Easy Words)

    // When you do put(key, value):
    
    // Map finds correct position by skipping levels → fast scan
    // CAS is used to insert node atomically
    // New node may be promoted to upper levels (probability 1/2)
    // No locking → super fast for multi-threading

    // | Feature              | TreeMap            | ConcurrentHashMap     | ConcurrentSkipListMap |
    // | -------------------- | ------------------ | --------------------- | --------------------- |
    // | Thread-safety        | ❌ No               | ✔ Yes                 | ✔ Yes                 |
    // | Maintains order      | ✔ Yes              | ❌ No                  | ✔ Yes                 |
    // | Underlying structure | Red-Black Tree     | Hash Table + Segments | Skip List             |
    // | Concurrency          | Low                | High                  | Medium-High           |
    // | Sorting              | Natural/Comparator | No                    | Natural/Comparator    |

}
