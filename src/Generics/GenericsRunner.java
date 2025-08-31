package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// generic class
class Response<T>{
    boolean success;
    T data;

    Response(T data, boolean success){
        this.data = data;
        this.success = success;
    }

    // generic method
    static <T> void printResponse(Response<T> res){
        System.out.println(res);
    }

    /*  During compile time the type will be erased so this method becomes same as printResponse(Response<T> res)
        So it will give compile error
    static void printResponse(Response<Integer> res){
        System.out.println(res);
    }
     */

    public String toString(){
        return String.valueOf(success) + " " + data.toString();
    }
}

public class GenericsRunner {
    public static <T> void printList(List<T> lis){
        for(T i : lis){
            System.out.println(i.getClass());
            System.out.println(i.toString());
        }
    }

    public static void printListWild(List<?> lis){
        for(Object i : lis){
            System.out.println(i.getClass());
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args){
        Response<Integer> res1 = new Response<>(100,false);
        Response<String> res2 = new Response<>("apple",true);
        Response.printResponse(res1);
        Response.printResponse(res2);

        System.out.println(res1.getClass() == res2.getClass()); // true

        System.out.println(res1 instanceof Response);
        System.out.println(res1 instanceof Response<Integer>);
        // following will not compile as jvm knows at compile time that res1 is of <Integer>
        //System.out.println(res1 instanceof Response<String>);


        //List<Object> list1 = new ArrayList<String>(); // will not compile as Generics are invariant
        // String is subtype of Object => does not mean List<String> is subtype of List<Object>

        List<?> list2 = new ArrayList<String>(List.of("a","b","c"));
        List<?> list3 = Arrays.asList("a","b","c");

        //list2.add("d"); // compile error as type information is removed from list2

        printList(list2);  // only what was already present in list can be accessed and null can be added

        printListWild(list2);
        // in the print the elements will still print their class as String as the Object inside the list is of String.
        // i.e the object inside knows its type
        // But compiler does not know what object types the list will accept so you cannot add more elements
    }
}
