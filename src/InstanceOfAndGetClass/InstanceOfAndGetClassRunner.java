package InstanceOfAndGetClass;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

class Animal {}

class Dog extends Animal{}
class Cat extends Animal{}

public class InstanceOfAndGetClassRunner {
    public static void main(String[] args){

        Animal animal1 = new Dog();
        System.out.println("Is an Animal : " + (animal1 instanceof Animal));
        System.out.println("Is a Dog     : " + (animal1 instanceof Dog));
        System.out.println("Is an Object : " + (animal1 instanceof Object));
        System.out.println("Is a Cat     : " + (animal1 instanceof Cat));

        System.out.println("\nExample 2");
        Dog dog1 = new Dog();

        System.out.println("Is a Dog     : " + (dog1 instanceof Dog));
        System.out.println("Is an Animal : " + (dog1 instanceof Animal));
        System.out.println("Is an Object : " + (dog1 instanceof Object));

        // this will not compile At compile time, the Java compiler can prove that a Dog can never be a Cat.
        //System.out.println("Is an Object : " + (dog1 instanceof Cat));

        System.out.println("\nExample 2");
        Dog dog2 = null;

        System.out.println("Is a Dog     : " + (dog2 instanceof Dog));
        System.out.println("Is an Animal : " + (dog2 instanceof Animal));
        System.out.println("Is an Object : " + (dog2 instanceof Object));


        //======= GetClass================================

        System.out.println("\n\n\n\nGetClass Example");
        System.out.println(animal1.getClass());
        System.out.println(dog1.getClass());
        System.out.println(dog1.getClass().getSimpleName());

        if(animal1.getClass() == Animal.class){    // getClass() does not care about parent class or reference class
            // will not enter
            System.out.println("GetClass : Its a animal!");
        }
        else if (animal1.getClass() == Dog.class){  // getClass() return only the class of actual runtime object
            System.out.println("GetClass : Its a Dog!");
        }
        // System.out.println(dog2.getClass());  // will give nullPointerException

    }
}
