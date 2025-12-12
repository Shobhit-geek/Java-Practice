package Collections.concurrentClass;

import java.util.Optional;

public class BlockingQueue {
    // 🔥 BlockingQueue (java.util.concurrent.BlockingQueue)
    
    // A BlockingQueue is a thread-safe queue that blocks:
    
    // ✔ When queue is full → producer waits
    // ✔ When queue is empty → consumer waits
    
    // This is ideal for:
    
    // Producer–Consumer problems
    // Multi-threaded pipelines
    // Task scheduling
    // Message passing between threads
    
    // ⭐ PACKAGE
    // import java.util.concurrent.BlockingQueue;
    // import java.util.concurrent.ArrayBlockingQueue;
    
    // 🚀 1. Why BlockingQueue?
    // Because normal queues (like LinkedList, PriorityQueue) are NOT thread-safe.
    
    // BlockingQueue provides:
    
    // Automatic blocking
    // Thread-safe put & take
    // No need for manual wait()/notify()
    // Prevents race conditions
    // Simplifies producer-consumer system
    
    // 🚀 2. BlockingQueue Methods (Important)

    // | Method                        | Behavior                                           |
    // | ----------------------------- | -------------------------------------------------- |
    // | **put(E e)**                  | waits if queue is full (blocks producer)           |
    // | **take()**                    | waits if queue is empty (blocks consumer)          |
    // | **offer(E e)**                | adds element, returns false if full (non-blocking) |
    // | **poll()**                    | returns element or null if empty (non-blocking)    |
    // | **offer(E e, timeout, unit)** | waits for limited time                             |
    // | **poll(timeout, unit)**       | waits for limited time                             |


    // 🚀 3. Implementations of BlockingQueue

    // | Class                     | Description                      |
    // | ------------------------- | -------------------------------- |
    // | **ArrayBlockingQueue**    | Fixed-size array-based queue     |
    // | **LinkedBlockingQueue**   | Optional capacity, linked nodes  |
    // | **PriorityBlockingQueue** | Priority queue with blocking     |
    // | **DelayQueue**            | Stores delayed tasks             |
    // | **SynchronousQueue**      | No capacity: direct handoff      |
    // | **LinkedTransferQueue**   | Highly concurrent transfer queue |

    // For most tasks → use ArrayBlockingQueue or LinkedBlockingQueue.
    
    // 🚀 4. PRODUCER–CONSUMER Example
    
    // This is the most asked interview question.
    
    // ✔ Example using ArrayBlockingQueue
    // import java.util.concurrent.*;
    
    // public class BlockingQueueDemo {
    //     public static void main(String[] args) {
    
    //         BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
    
    //         // Producer Thread
    //         Thread producer = new Thread(() -> {
    //             int value = 1;
    //             try {
    //                 while (true) {
    //                     System.out.println("Producer adding: " + value);
    //                     queue.put(value);   // blocks if queue is full
    //                     value++;
    //                     Thread.sleep(1000);
    //                 }
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         });
    
    //         // Consumer Thread
    //         Thread consumer = new Thread(() -> {
    //             try {
    //                 while (true) {
    //                     int v = queue.take();  // waits if queue empty
    //                     System.out.println("Consumer took: " + v);
    //                     Thread.sleep(1500);
    //                 }
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         });
    
    //         producer.start();
    //         consumer.start();
    //     }
    // }
    
    // ✔ Output (example):
    // Producer adding: 1
    // Consumer took: 1
    // Producer adding: 2
    // Producer adding: 3
    // Consumer took: 2
    // ...

    // Producer waits when queue is full
    // Consumer waits when queue is empty
    
    // No need for synchronized, wait(), or notify()!
    
    // 🚀 5. When to use which BlockingQueue?

    // ✔ ArrayBlockingQueue (Most Common)

    // Fixed capacity
    // High performance  
    // Good for classic producer-consumer
    
    // ✔ LinkedBlockingQueue

    // Unbounded or bounded
    // More throughput
    
    // ✔ PriorityBlockingQueue
    
    // Elements sorted by priority
    // Used for job scheduling
    
    // ✔ DelayQueue
    
    // Tasks delayed until specific time
    // Used in caching, scheduled jobs
    
    // ✔ SynchronousQueue
    
    // No storage
    // Direct hand-off
    // Used in executor frameworks
    
    // 🚀 6. Why BlockingQueue is Interview-Favorite?
    
    // Because it demonstrates:

    // Thread communication
    // Producer-consumer problem
    // Knowledge of java.util.concurrent package
    // Real-world concurrent programming
    // Understanding blocking vs non-blocking behavior
    
    // ⭐ Summary
    
    // A thread-safe queue designed for multithreading.
    // Handles blocking automatically.
    // No need for wait/notify.
    // Supports producer-consumer easily.
}

