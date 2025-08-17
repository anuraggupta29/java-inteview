package MultithreadingAndConcurrency.LocksAndSynchronization;

import java.util.concurrent.locks.ReentrantLock;

class BankAccountController {
    int fromUserId;
    int toUserId;
    int balance;
    static String bankname = "SBI";
    static int bankCode = 101010;
    ReentrantLock objectlock = new ReentrantLock();
    static ReentrantLock classlock = new ReentrantLock();

    // static methods acquire class level lock (all static methods share same lock)
    // if some thread is executing getBankName, another thread cannot execute bankCode as they share same lock
    // another thread can execute pay() or getBalance() as it has different lock (object level lock)
    static String getBankname(){
        classlock.lock();
        try{
            return bankname;
        }
        finally{
            classlock.unlock();
        }
    }

    static int bankCode(){
        classlock.lock();
        try{
            return bankCode;
        }
        finally{
            classlock.unlock();
        }
    }


    // all non static methods acquire object level lock
    // all non static methods of the same object use the same lock
    // if some thread is executing pay(), another thread cannot execute getBalance as they share the same lock.
    // another thread can execute getBankName() or bankCode() as it has different lock (class level lock)
    void pay(int amount){
        objectlock.lock();
        try{
            // deduct from fromUserId
            // credit to toUserId
        }
        finally{
            objectlock.unlock();
        }

    }


    int getBalance(){
        objectlock.lock();
        try{
            return balance;
        }
        finally{
            objectlock.unlock();
        }
    }


    void settleCreditCardBill(){

        // come operation all threads can access

        objectlock.lock();
            // this block puts a lock on this object
            // so all synchronized object methods cannot be accessed till this execution is complete
            // non synchronized methods and static synchronized methods can be accessed
            // some operations
        objectlock.unlock();


        classlock.lock();
            // this block puts a lock on this class
            // so all static synchronized methods cannot be accessed till this execution is complete
            // non synchronized methods and object synchronized methods can be accessed
            // some operations
        classlock.unlock();
    }

}

public class ReentrantLockRunner {
    public static void main(String[] args){

    }
}
