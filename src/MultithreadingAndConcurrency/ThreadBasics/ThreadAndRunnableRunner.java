package MultithreadingAndConcurrency.ThreadBasics;

class NumberCounterThread extends Thread{
    public void run(){
        for(int i=0; i<=10; i++) System.out.println("Thread : " + i);
    }
}

class NumberCounterRunnable implements Runnable{
    public void run(){
        for(int i=0; i<=10; i++) System.out.println("Runnable : " + i);
    }
}



public class ThreadAndRunnableRunner {
    public static void main(String[] args) throws Exception{
        Thread thread = new NumberCounterThread();
        Thread runnable = new Thread(new NumberCounterRunnable());  // Thread accept runnable

        thread.start();  // this thread will start execution in parallel
        runnable.start();  // this thread will start execution in parallel

        // main thread will also execute in parallel
        for(int i=0; i<=10; i++) System.out.println("Main thread : " + i);


        thread.join(); // .join() makes main thread to wait for this thread to finish before going further
        runnable.join();

        // some operations
    }
}
