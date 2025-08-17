package MultithreadingAndConcurrency.LocksAndSynchronization;

class Car{
    Driver driver;
    synchronized void connectToDriverPhone() throws InterruptedException {
        System.out.println("Car : Connecting to driver Phone");

        Thread.sleep(1000); // Sleep so both threads can enter critical section

        driver.connectPhone();
        System.out.println("Car : Connected to phone");
    }

    synchronized void start(){
        System.out.println("Car : Starting car");
    }
}

class Driver{
    Car car;

    synchronized void connectPhone(){
        System.out.println("Driver : connect to phone");
    }

    synchronized void startCar() throws InterruptedException {
        System.out.println("Driver : start the car");

        Thread.sleep(1000);  // Sleep so both threads can enter critical section

        car.start();
        System.out.println("Driver : car started");
    }
}

public class DeadlockRunner {

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        Driver driver = new Driver();
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
