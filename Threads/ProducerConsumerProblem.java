package Threads;

class SharedResource{
    Boolean isItemAvailable = false;
    public synchronized void addItem(){
        isItemAvailable = true;
        System.out.println("Inside AddItem: "+Thread.currentThread().getName());
        // Wakes up all threads that are waiting on this object's monitor. 
        notifyAll();
    }

    public synchronized void consumeItem() {
        while(!isItemAvailable){
            try{
                System.out.println("From Consumed Item"+ Thread.currentThread().getName());
                // Causes the current thread to wait until it is awakened, typically by being notified or interrupted.
                wait();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        isItemAvailable = false;
        System.out.println("Item consumed by: " + Thread.currentThread().getName());
    }
}
class ProduceTask implements Runnable{
    SharedResource srs;
    ProduceTask(SharedResource rs){
        this.srs = rs;
    }
    @Override
    public void run() {
        System.out.println("Produce Thread"+ Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
            srs.addItem();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class ConsumeTask implements Runnable {
    SharedResource srs;
    ConsumeTask(SharedResource rs){
        this.srs = rs;
    }

    @Override
    public void run() {
        System.out.println("Consumer Thread" + Thread.currentThread().getName());
        try {
            srs.consumeItem();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
public class ProducerConsumerProblem {

    public static void main(String[] args) {
        SharedResource sr = new SharedResource();
        
        ProduceTask pt = new ProduceTask(sr);
        Thread pth = new Thread(pt);
        ConsumeTask ct = new ConsumeTask(sr);
        Thread cth = new Thread(ct);
        pth.start();
        cth.start();

    }
}
