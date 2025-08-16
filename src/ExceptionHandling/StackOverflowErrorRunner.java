package ExceptionHandling;

public class StackOverflowErrorRunner {

    static void recursive(){ // it will run infinitely and stack will overflow or heap memory will be full
        String a = "1111111111111111111111111111111";
        recursive();
    }

    public static void main(String[] args){

        try{
            System.out.println("try block reached");
            recursive(); // will cause stack overflow
        }
        catch(Exception e){
            System.out.println("exception catch block reached!");
            System.out.println(e.getCause());
        } catch (Error e) {
            // stackOverFlow is an error not an exception so, if JVM recovers it will come here
            System.out.println("Error catch block reached!");
            System.out.println(e.getStackTrace());
        }
        finally {
            // finally may or may not execute for errors there is no guarantee
            System.out.println("Finally block reached!");
        }
    }
}
