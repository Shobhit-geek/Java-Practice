package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceEx {
    
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 5, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));
        for(int i=1; i<10;i++){
            
        }
    }
}
