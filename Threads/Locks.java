package Threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Locks {
    public static void main(String[] args) {
        SharedResource shr = new SharedResource();
        ReadWriteLock rwlock = new ReentrantReadWriteLock();
        Thread th1 = new Thread(() -> shr.ProduceTask(rwlock));
        Thread th2 = new Thread(() -> shr.ConsumeTask(rwlock));
        th1.start();
        th2.start();
    }
}

// SharedResource represents a shared buffer/resource accessed by multiple threads (Producer & Consumer)
class SharedResource {

    // Shared state between threads
    // In Producer–Consumer, this represents whether data is available
    boolean isItemAvailable = false;

    /*
     * Producer Task:
     * - Uses READ LOCK
     * - Multiple threads can acquire read lock simultaneously
     * - Intended for read-only operations
     *
     * NOTE:
     * In real Producer–Consumer, producer should normally use WRITE LOCK because it modifies shared data.
     * This code demonstrates lock behavior, not ideal producer logic.
     */
    public void ProduceTask(ReadWriteLock lock) {

        // Acquires read lock
        // Allows concurrent access if no write lock is held
        lock.readLock().lock();
        System.out.println("ReadLock acquired by: " + Thread.currentThread().getName());

        try {
            // Modifying shared state while holding read lock
            // (Unsafe in real-world usage, but shown for demonstration)
            isItemAvailable = true;

            // Simulate time-consuming operation
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());

        } finally {
            // Read lock must always be released in finally block
            lock.readLock().unlock();
            System.out.println("ReadLock released by: " + Thread.currentThread().getName());
        }
    }

    /*
     * Consumer Task:
     * - Uses WRITE LOCK
     * - Exclusive access: no other read or write lock allowed
     * - Blocks all other threads until released
     */
    public void ConsumeTask(ReadWriteLock rlock) {

        // Acquires write lock
        // Blocks all read and write operations
        rlock.writeLock().lock();
        System.out.println("WriteLock acquired by: " + Thread.currentThread().getName());

        try {
            // Consumes or modifies shared data
            isItemAvailable = true;

            // Simulate processing time
            Thread.sleep(4000);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());

        } finally {
            // Release write lock so other threads can proceed
            rlock.writeLock().unlock();
            System.out.println("WriteLock released by: " + Thread.currentThread().getName());
        }
    }
}


