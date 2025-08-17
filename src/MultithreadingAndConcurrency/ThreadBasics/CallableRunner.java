package MultithreadingAndConcurrency.ThreadBasics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class NumberCounterCallable implements Callable<Integer> {
    public Integer call(){
        int sum=0;
        for(int i=0; i<=10; i++){
            System.out.println("Callable : " + i);
            sum += i;
        }
        return sum;
    }
}


public class CallableRunner {

    public static void main(String[] args) throws Exception{

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Integer> result = service.submit(new NumberCounterCallable()); // Thread execution will begin here if free threads available in pool

        // Any task here will execute in parallel
        for(int i=0; i<=10; i++) System.out.println("Main thread : " + i);


        int res = result.get();
        // when you get the result, if result is already there you will get it immediately
        // else program waits here till execution of the thread is complete

        System.out.println("Callable Result : " + res);

        service.close();




          // Program will wait here

    }
}
