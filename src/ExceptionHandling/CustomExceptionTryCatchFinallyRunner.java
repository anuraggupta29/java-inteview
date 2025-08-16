package ExceptionHandling;

public class CustomExceptionTryCatchFinallyRunner {
    public static void main(String[] args){
        User user = new User("anurag", "1234", 10);
        boolean closeConnection = false;
        try{
            // need to handle exception else wont compile
            System.out.println(user.getOrderCnt("anurag","1234"));  // this is correct so no exception

            System.out.println(user.getOrderCnt("anurag","1111"));  // exception will happen here

            closeConnection = true;
        }
        catch(CredentialException e){
            System.out.println("Reached catch block!");
            System.out.println(e.getMessage());
            return;   // return is here but finally will still execute
        }
        finally {
            closeConnection = true;
            System.out.println("Finally block prints whether an exception occurs or not");
            System.out.println("It executes even if there is return statement in try or catch block!!!");
        }

        // will not execute as there is return in catch block and we will always enter catch block
        // but finally block will still be executed!!!!!
        System.out.println("last line of function");
    }
}
