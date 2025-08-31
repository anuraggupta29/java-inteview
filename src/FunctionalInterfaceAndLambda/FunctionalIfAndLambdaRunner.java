package FunctionalInterfaceAndLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.*;

class OddChecker implements Predicate<Integer>{
    public boolean test(Integer n){
        return n%2==1;
    }
}

class Pair implements Comparable<Pair>{
    String key;
    Integer value;

    Pair(String s, Integer v){
        key = s;
        value = v;
    }

    // Order based on smaller key first, then smaller value
    public int compareTo(Pair p){
        int x = this.key.compareTo(p.key);
        if(x==0){
            return this.value-p.value;
        }
        return x;
    }

    public String toString(){
        return key + " " + value;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair p1, Pair p2){
        int x = p1.key.compareTo(p2.key);
        if(x==0){
            return p2.value-p1.value;
        }
        return -x;
    }
}


class NumberCounterThread implements Runnable{
    public void run(){
        for(int i=0; i<100; i++) System.out.print(i + " ");
        System.out.println();
    }
}

class NumberCounterWithSumThread implements Callable<Integer>{
    public Integer call(){
        int s = 0;
        for(int i=0; i<100; i++){
            s += i;
            System.out.print(i + " ");
        }
        System.out.println();
        return s;
    }
}

public class FunctionalIfAndLambdaRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(0,9,4,6,5,2,8,7,1,3);

        List<Integer> listodd = list.stream().filter(new OddChecker()).toList();
        System.out.println(listodd);

        List<Pair> pairlist = new ArrayList<>();
        pairlist.add(new Pair("a", 10));
        pairlist.add(new Pair("a", 5));
        pairlist.add(new Pair("b", 10));
        pairlist.add(new Pair("b", 5));

        pairlist.sort(null);
        System.out.println(pairlist);

        pairlist.sort(new PairComparator());
        System.out.println(pairlist);

        Thread t = new Thread(new NumberCounterThread());
        t.start();
        t.join();

        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> res = es.submit(new NumberCounterWithSumThread());

        System.out.println(res.get());
        es.close();



        // ========== LAMBDAS

        List<String> strs = Arrays.asList("a","aa","aaa","aaaa","aaaaa");

        // function
        Function<String,Integer> stoLen = (s) -> s.length();

        for(String s: strs){
            System.out.println(stoLen.apply(s));
        }

        // consumer
        Consumer<String> lenPrint = (s)-> System.out.println(s.toUpperCase());
        strs.stream().forEach(lenPrint);

        //BinaryOperator
        BinaryOperator<Integer> sum = (a,b)-> a+b;

        //BiFunction
        BiFunction<Integer,String,Integer> sumofstrLen = (a,b) -> a+b.length();

        System.out.println(list.stream().reduce(0,sum));

        System.out.println(strs.stream().reduce(0,sumofstrLen,(a,b)->a+b));
    }
}
