package Threads;

// 2ways to create thread

// way-1 by impleenting runnable interface
// This class implements Runnable, which represents a task that can run in a thread
class MultiThreading implements Runnable {

    // run() contains the code that will execute in a separate thread
    @Override
    public void run() {
        // Prints the name of the thread that is currently executing this code
        System.out.println(Thread.currentThread().getName());
    }
}

//way2 by extending ThreadClass

class NewThreding extends Thread{
    @Override
    public void run() {
        System.out.println("Thread Running: "+Thread.currentThread().getName());
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        System.out.println("current Thread: " + Thread.currentThread().getName());

        // Creating an object of Runnable implementation (task)
        MultiThreading mlth = new MultiThreading();

        // Creating a Thread object and passing the Runnable task to it
        Thread thread = new Thread(mlth);

        // Starts a new thread and internally calls run() in a separate thread
        thread.start();
        System.out.println("current Thread: " + Thread.currentThread().getName());

        NewThreding nth = new NewThreding();
        nth.start();
        System.out.println("Line42: "+Thread.currentThread().getName());

    }
}

/*
 * start():
 * - Creates a NEW thread
 * - JVM allocates a separate call stack
 * - Internally calls run() in a new thread
 * - Executes concurrently with the main thread
 */
// thread.start();

/*
 * run():
 * - DOES NOT create a new thread
 * - Executes like a normal method call
 * - Runs on the CURRENT thread (main thread here)
 *
 * If you replace start() with run(),
 * the output will always be "main"
 */
// thread.run(); // Uncomment to see the difference