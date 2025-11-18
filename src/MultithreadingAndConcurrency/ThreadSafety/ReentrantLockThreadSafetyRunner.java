package MultithreadingAndConcurrency.ThreadSafety;


import java.util.concurrent.locks.ReentrantLock;

// Used inner class in this example although not required

public class ReentrantLockThreadSafetyRunner {
    static class Counter{
        public int count=0;
        public void increment(){
            count += 1;
        }
    }

    static class ReentrantCounter extends Counter {
        ReentrantLock objectlock = new ReentrantLock();
        public void increment(){
            objectlock.lock();
            count += 1;
            objectlock.unlock();
        }
    }

    static class IncrementerRunnable implements Runnable{
        Counter counter;
        IncrementerRunnable(Counter counter){
            this.counter = counter;
        }
        public void run(){
            // incremented 100 times
            for(int i=0; i<100; i++) counter.increment();
        }
    }


    public static void main(String[] args) throws Exception{
        Counter counter = new Counter();
        IncrementerRunnable runnable = new IncrementerRunnable(counter);

        // 1000 threads doing same task
        // => 1000 threads each doing 100 increments => 100000 operation
        // but final value may not be 100000 at the end
        for(int i=0; i<1000; i++){
            (new Thread(runnable)).start();
        }

        // Since we are not calling .join (as we are not storing the thread reference)
        // we will wait for sometime in main thread (so all threads finish)
        Thread.sleep(5000);  // 5 seconds

        System.out.println("Count is : " + counter.count);  // count may not be 100000


        // now pass a counter which has synchronized methods
        counter = new ReentrantCounter();
        runnable = new IncrementerRunnable(counter);

        for(int i=0; i<100; i++){
            (new Thread(runnable)).start();
        }

        Thread.sleep(5000);  // 5 seconds
        System.out.println("Synchronized Count is : " + counter.count);  // count will be 100000
    }
}
