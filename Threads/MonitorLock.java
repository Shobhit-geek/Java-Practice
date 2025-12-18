package Threads;

public class MonitorLock {

    // Monitor Lock: When a thread enters a synchronized method, it acquires the monitor 
    // lock for that object. Other threads must wait until the lock is released.
    // synchronized method → thread must acquire 'this' object's monitor lock
    public synchronized void task1() {
        try {
            // Thread enters task1 and acquires monitor lock of MonitorLock object
            System.out.println("inside Task1");

            // Thread sleeps but DOES NOT release the lock
            // Other synchronized methods/blocks on the same object are blocked
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Lock is released automatically when method exits
    }

    // Non-synchronized method
    public void task2() {
        // This line can execute even if another thread holds the monitor lock
        System.out.println("inside Task2");

        // synchronized block → explicitly acquiring monitor lock on 'this'
        synchronized (this) {
            // Thread must wait here if lock is already held by another thread
            System.out.println("Task2, from synchronized");
        }
        // Lock released after exiting synchronized block
    }
    
    // Another synchronized method → also uses the SAME monitor lock ('this')
    public synchronized void task3() {
        System.out.println("inside Task3");
    }

    public static void main(String[] args) {
        // Example Flow:

        // 1. Thread th1 calls ml.task1() → acquires lock
        // 2. Prints "inside Task1"
        // 3. Sleeps for 1 second (still holding lock)
        // 4. If another thread tries ml.task2(), it waits until Thread th1 releases the lock

        MonitorLock ml = new MonitorLock();

        // Thread 1 acquires monitor lock via synchronized method
        Thread th1 = new Thread(() -> ml.task1());
        th1.start();

        // Thread 2 tries to enter synchronized block on same object
        Thread th2 = new Thread(() -> ml.task2());
        th2.start();

        // Thread 3 tries to enter another synchronized method
        Thread th3 = new Thread(() -> ml.task3());
        th3.start();
        
        // main thread waits until th3 finishes due to join
        try {
            th3.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // till user thread-life, daemon thread life is there. And it will run parallely to user thread.
        Thread t = new Thread(() -> System.out.println("Daemon"));
        t.setDaemon(true);
        t.start();

        // Executed by main thread after th3 completes
        System.out.println("fwrwrweer");
    }
}


// 📌 The Code
// Thread th1 = new Thread(() -> ml.task1());

// 🔍 What is happening here?
// 1️⃣ Thread constructor expects a Runnable
// public Thread(Runnable target)

// So inside new Thread( ... ) Java expects something like: () -> void

// 2️⃣ Runnable is a Functional Interface
// @FunctionalInterface
// public interface Runnable {
//     void run();
// }

// Since it has only one abstract method, we can use lambda expression.

// 3️⃣ Lambda Expression Explained
// () -> ml.task1()   ,Means:

// () → no arguments
// -> → lambda arrow
// ml.task1() → code to execute inside run()

// This is equivalent to:

// Runnable r = new Runnable() {
//     @Override
//     public void run() {
//         ml.task1();
//     }
// };

// Or shorter:
// Runnable r = () -> ml.task1();

// 4️⃣ Final Flow
// Thread th1 = new Thread(() -> ml.task1());
// th1.start();

// What happens:

// JVM creates a new thread
// New thread calls run()
// run() executes ml.task1()