package SealedAndFinalClass;

// final class ================================================
final class Animal{}
// class Dog extends Animal{}   // cannot be extended gives compile error


// Sealed class ===============================================
sealed class Vehicle permits Car,Bike,Boat{
    void runVehicle(){
        System.out.println(this.getClass().getSimpleName() + " is running");
    }
}

// sealed class cannot be extended by classes which are not permitted
//class Truck extends Vehicle{}

// Note** Whichever class is permitted must be declared sealed, non-sealed, or final

// sealed class can be extended by final class
final class Boat extends Vehicle{}

// sealed class can be extended by non-sealed class
non-sealed class Bike extends Vehicle{}

// non-sealed class can be extended by any class. (So now BmwBike has access to runVehicle() method!!!!)
class BmwBike extends Bike{}

// If a sealed class extends another sealed class it does not need to specify permits
sealed class Car extends Vehicle{}

// sealed class can be extended by non-sealed class
non-sealed class SuvCar extends Car{}

// non-sealed class can be extended by any class.
class MahindraSuvCar extends SuvCar{}


public class SealedAndFinalClassRunner {

    public static void main(String[] args){
        Vehicle vehicle = new Vehicle();
        vehicle.runVehicle();

        vehicle = new Boat();
        vehicle.runVehicle();

        vehicle = new Bike();
        vehicle.runVehicle();

        vehicle = new BmwBike();
        vehicle.runVehicle();

        vehicle = new Car();
        vehicle.runVehicle();

        vehicle = new SuvCar();
        vehicle.runVehicle();

        vehicle = new MahindraSuvCar();
        vehicle.runVehicle();
    }
}
