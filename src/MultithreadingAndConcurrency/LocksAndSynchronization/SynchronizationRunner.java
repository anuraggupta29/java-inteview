package MultithreadingAndConcurrency.LocksAndSynchronization;

class BankAccountHandler {
    int fromUserId;
    int toUserId;
    int balance;
    static String bankname = "SBI";
    static int bankCode = 101010;

    // static methods acquire class level lock (all static methods share same lock)
    // if some thread is executing getBankName, another thread cannot execute bankCode as they share same lock
    // another thread can execute pay() or getBalance() as it has different lock (object level lock)
    synchronized static String getBankname(){
        return bankname;
    }


    static synchronized int bankCode(){
        return bankCode;
    }


    // all non static methods aquire object level lock
    // all non static methods of the same object use the same lock
    // if some thread is executing pay(), another thread cannot execute getBalance as they share the same lock.
    // another thread can execute getBankName() or bankCode() as it has different lock (class level lock)
    synchronized void pay(int amount){
        // deduct from fromUserId
        // credit to toUserId
    }


    synchronized int getBalance(){
        return balance;
    }


    void settleCreditCardBill(){

        // come operation all threads can access

        synchronized (this){
            // this block puts a lock on this object
            // so all synchronized object methods cannot be accessed till this execution is complete
            // non synchronized methods and static synchronized methods can be accessed
            // some operations
        }

        synchronized (BankAccountHandler.class){
            // this block puts a lock on this class
            // so all static synchronized methods cannot be accessed till this execution is complete
            // non synchronized methods and object synchronized methods can be accessed
            // some operations
        }
    }

}

public class SynchronizationRunner {
    public static void main(String[] args){

    }
}
