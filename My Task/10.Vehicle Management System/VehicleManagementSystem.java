// Abstract Class
abstract class Vehicle {

    // Abstract methods
    abstract void start();

    abstract void stop();
}

// Interface
interface FuelEfficiency {

    void calculateMileage();
}

// Car Class
class Car extends Vehicle implements FuelEfficiency {

    @Override
    void start() {
        System.out.println("Car is starting...");
    }

    @Override
    void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public void calculateMileage() {
        System.out.println("Car Mileage: 18 km/l");
    }
}

// Bike Class
class Bike extends Vehicle implements FuelEfficiency {

    @Override
    void start() {
        System.out.println("Bike is starting...");
    }

    @Override
    void stop() {
        System.out.println("Bike is stopping...");
    }

    @Override
    public void calculateMileage() {
        System.out.println("Bike Mileage: 45 km/l");
    }
}

// Main Class
public class VehicleManagementSystem {

    public static void main(String[] args) {

        System.out.println("===== Car Details =====");
        Car car = new Car();
        car.start();
        car.stop();
        car.calculateMileage();

        System.out.println();

        System.out.println("===== Bike Details =====");
        Bike bike = new Bike();
        bike.start();
        bike.stop();
        bike.calculateMileage();
    }
}