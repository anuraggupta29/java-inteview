package OOPS;

interface Calculator{
    int add(int a, int b);
    static int multiply(int a, int b){
        return a*b;
    }
    default int subtract(int a, int b){
        return a-b;
    }

    public boolean equals(Object o); // no need to implements, takes from object class
}

public class OopsRunner {
    public static void main(String[] args){

    }
}
