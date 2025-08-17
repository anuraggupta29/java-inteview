package MultithreadingAndConcurrency.LocksAndSynchronization;

// Deadlock prevention by lock ordering
// Decide the order in which locks need to be acquired based on hashcode
// So each object will acquire lock in same order, so deadlock will be prevented.

class Car2{
    Driver2 driver;
    void connectToDriverPhone() throws InterruptedException {
        Object first,second;
        if(this.hashCode() < driver.hashCode()){
            first = this;
            second = driver;
        }
        else{
            first = driver;
            second = this;
        }

        synchronized (first){
            Thread.sleep(500);
            synchronized (second){
                System.out.println("Car : Connecting to driver Phone");

                Thread.sleep(500);

                driver.connectPhone();
                System.out.println("Car : Connected to phone");
            }
        }
    }

    synchronized void start(){
        System.out.println("Car : Starting car");
    }
}

class Driver2{
    Car2 car;

    synchronized void connectPhone(){
        System.out.println("Driver : connect to phone");
    }

    void startCar() throws InterruptedException {
        Object first,second;
        if(this.hashCode() < car.hashCode()){
            first = this;
            second = car;
        }
        else{
            first = car;
            second = this;
        }

        synchronized (first){
            Thread.sleep(500);
            synchronized (second) {
                System.out.println("Driver : start the car");

                Thread.sleep(500);

                car.start();
                System.out.println("Driver : car started");
            }
        }
    }
}

public class DeadlockPreventionRunner {

    public static void main(String[] args) throws InterruptedException {
        Car2 car = new Car2();
        Driver2 driver = new Driver2();
        car.driver = driver;
        driver.car = car;

        Runnable connectToDriverPhone = () -> {
            try {
                car.connectToDriverPhone();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Runnable startCar = () -> {
            try {
                driver.startCar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        // Both threads will try to call the synchronized methods of other object from
        // a synchronized method of current object. So both will be in a deadlock

        Thread connectPhoneThread = new Thread(connectToDriverPhone);
        Thread startCarThread = new Thread(startCar);

        connectPhoneThread.start();
        startCarThread.start();

        connectPhoneThread.join();
        startCarThread.join();

        System.out.println("Execution ends");
    }
}
