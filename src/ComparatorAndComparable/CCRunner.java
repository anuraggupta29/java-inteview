package ComparatorAndComparable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person implements Comparable<Person>{
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String name;
    public int id;

    Person(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public int compareTo(Person o) {
        return this.id-o.id;
    }
}

public class CCRunner {

    public static void main(String[] args){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Anurag", 20));
        persons.add(new Person("Hement", 10));

        persons.sort(null); // will use the defined comparable
        System.out.println(persons);

        Comparator<Person> cmp = (p1,p2) -> p1.name.compareTo(p2.name);

        persons.sort(cmp);
        System.out.println(persons);


        // Difference

        // Comparable -> implemented by the class, provides the default comparison strategy

        // Comparator -> create a separate class or lambda which provides strategy to compare 2 objects of any type
        // multiple different strategy can be created and passed where to be used.

    }
}
