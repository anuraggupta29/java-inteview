package Streams;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsRunner {
    public static void main(String[] args){

        List<Integer> nums = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9));

        System.out.println("Filter ODD numbers");
        List<Integer> odd = nums.stream().filter(a -> (a&1)==1).toList();
        System.out.println(odd);
        nums.stream().filter(a -> (a&1)==1).forEach(a-> System.out.println(a));

        Integer count = (int) nums.stream().filter(a -> (a&1)==1).count();


        System.out.println("Take only distinct elements");
        List<Integer> dup = new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9,2,2,3,3,4));

        List<Integer> withoutdup = dup.stream().distinct().toList();
        System.out.println(withoutdup);


        System.out.println("Get Max element");
        Integer max = nums.stream().max((a,b)->a-b).get();

        System.out.println("Max value : + " + max);

        Integer sum = nums.stream().mapToInt(a->a.intValue()).sum();
        System.out.println("Sum value : " + sum);


        List<Integer> unsorted_list = new ArrayList<>(List.of(1,7,3,6,5,9,0,2));

        // sorted in reverse
        List<Integer> sorted = unsorted_list.stream().sorted((a,b)->b-a).toList();


        // Get longest string
        List<String> strings = new ArrayList<>(List.of("a","ab","abc","abcd","abcde"));
        String longest = strings.stream().max((a,b)->a.length()-b.length()).get();

        System.out.println("Longest string : " + longest);


        // Operations using reduce

        int sum2 = nums.stream().reduce(0, (a,b)->a+b);
        int product = nums.stream().skip(1).reduce(1,(a,b)->a*b);
        int min1 = nums.stream().reduce(Integer.MAX_VALUE, (a,b)->(a>b)?b:a);
        int max1 = nums.stream().reduce(Integer.MIN_VALUE, (a,b)->(a<b)?b:a);

        System.out.printf("Result : %d %d %d %d\n",sum2,product,min1,max1);

        // get longest string using reduce

        String longest2 = strings.stream().reduce("",(a,b)->a.length()<b.length()?b:a);

        System.out.println(longest2);


        // Map, get list of length of string length and sort it in descending order

        List<Integer> stringLength = strings.stream().map(a -> a.length()).sorted((a,b)->b-a).toList();

        System.out.println(stringLength);

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );


        // FlatMap
        List<String> res = nestedList.stream().flatMap(a -> a.stream()).toList();
        System.out.println(res);

        List<String> nestedList2 = Arrays.asList("a p p l e","p i e");

        String x = nestedList2.stream().flatMap(a -> Arrays.stream(a.split(" "))).reduce("",(a, b)->a+b);
        String y = nestedList2.
                stream().
                flatMap(a -> Arrays.stream(a.split(" ")))
                .reduce(new StringBuilder(),
                        (builder, s)->builder.append(s),
                        (s1,s2)->s1.append(s2))
                .toString();
        System.out.println(x + " " + y);



        // Collect
        class Person{
            String name;
            int age;
            Person(String name, int age){
                this.name = name;
                this.age = age;
            }
        }

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        Map<String, Integer> map = people.stream().collect(Collectors.toMap(p -> p.name, p ->p.age));
        System.out.println(map);







    }
}
