package ExceptionHandling;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class CustomFileReader implements Closeable{
    public void use(){
        System.out.println("Using resources");
    }

    @Override
    public void close() throws IOException {
        System.out.println("Close method called");
    }
}

public class TryWithResourcesRunner {
    public static void main(String[] args){

        try(
            CustomFileReader cos = new CustomFileReader();  // this will be closed automatically as it implements Closeable
            // can add multiple resources
        ){
            System.out.println("Entered try block");
            cos.use();
            throw new Exception("Random exception for testing");  // it will now go to catch block

        }catch(Exception e){
            System.out.println("Catch block reached");
        }
    }
}
