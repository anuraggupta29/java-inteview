package InnerAndAnonymousClass;

// Non-static inner class =====================================
class Car{
    int numWheels = 4;

    class Engine{
        void printNumWheels(int id){
            System.out.println("CAR: non static inner class method printNumWheels : " + numWheels + " id : " + id);
        }
    }

    void test(){
        Engine engine = new Engine();
        engine.printNumWheels(1);
    }
}


// Static inner class ==========================================
class Bike{
    int numWheels = 4;
    static int staticNumWheels = 2;

    // It can only access static parameters and methods of outer class
    static class Engine{
        void printNumWheels(int id){
            //int a = numWheels;  // cannot access numWheels
            System.out.println("BIKE: static inner class method printNumWheels : " + staticNumWheels + " id : " + id);
        }
    }

    void test(){
        Engine engine = new Engine();
        engine.printNumWheels(1);
    }
}



// Local inner class ==============================================
class Truck{
    static int abc = 888;
    void startTruck(){
        int aa = 122;  // this is effectively final as it is never reassigned or updated

        class Engine {
            void startEngine(){
                // aa can be used here as it is effectively final
                System.out.println("TRUCK : startTruck method local class running aa : " + aa + " abc : " + abc);
            }
        }

        Engine engine = new Engine();
        engine.startEngine();
    }
}


// anonymous class ====================================
abstract class Boat{
    abstract void runBoat();
}

abstract class Calculator{
    abstract int operate(int a, int b);
}



public class InnerAndAnonymousClassRunner {
    public static void main(String[] args){

        // Non-static inner class
        // It needs object of outer class to create object of inner class.
        Car car = new Car();
        car.test();

        Car.Engine engine = car.new Engine();
        engine.printNumWheels(2);


        // static inner class
        // It does not need object of Outer class, and can only access static members of outer class
        Bike.Engine bikeEngine = new Bike.Engine();
        bikeEngine.printNumWheels(3);


        // Local inner class
        // The class is defined under a method of another class
        // if the inner class is using some value of the outer method, then that variable must be effectively final
        // i.e either declared as final, or that value is never reassigned or updated.
        // the inner class can access static method of outer class
        Truck truck = new Truck();
        truck.startTruck();



        // anonymous class
        // allows to give implementation to abstract classes/interfaces on the fly

        Boat boat = new Boat(){
            @Override
            void runBoat() {
                System.out.println("Anonymous class Boat : Running boat..");
            }
        };

        //Calculator add = (a,b) -> {return a+b}; // does not work
    }
}
