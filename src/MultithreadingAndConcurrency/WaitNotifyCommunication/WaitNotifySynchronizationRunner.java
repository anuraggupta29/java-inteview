package MultithreadingAndConcurrency.WaitNotifyCommunication;

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {
    boolean produce = true;
    Queue<Integer> queue = new LinkedList<>();

    public synchronized void produce() throws InterruptedException {
        for(int i=1; i<=100; i++){
            while(!produce){  // wait while other thread is consuming
                wait();
            }
            System.out.println("Produced : " + i);
            queue.offer(i);
            if(i%5==0){
                produce = false;
                notify();
            }
        }
    }

    public synchronized void consume() throws InterruptedException {
        for(int i=1; i<=100; i++){
            while(produce){  // wait while other thread is producing
                wait();
            }
            int num = queue.poll();
            System.out.println("Consumed : " + num);

            if(i%5==0){
                produce = true;
                notify();
            }
        }
    }
}

// Implemented consumer as class
class QueueConsumer implements Runnable {
    SharedQueue queue;
    QueueConsumer(SharedQueue queue){
        this.queue = queue;
    }

    public void run(){
        try{
            queue.consume();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class WaitNotifySynchronizationRunner {

    public static void main(String[] args) throws Exception {

        SharedQueue queue = new SharedQueue();

        // Implemented producer as lambda expression
        Runnable queueProducer = () -> {
            try {
                queue.produce();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        };

        Thread producerThread = new Thread(queueProducer);
        Thread consumerThread = new Thread(new QueueConsumer(queue));

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Execution Complete");
    }

}
