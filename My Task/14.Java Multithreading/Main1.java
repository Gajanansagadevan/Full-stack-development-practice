// Cab Class
class Cab {

    private boolean available = true;

    // Synchronized Method
    public synchronized void bookCab(String customerName) {

        if (available) {

            System.out.println(customerName + " successfully booked the cab.");

            available = false;

        } else {

            System.out.println(customerName + " failed to book the cab. Cab is already booked.");

        }
    }
}

// Customer Thread Class
class Customer extends Thread {

    private String customerName;
    private Cab cab;

    // Constructor
    public Customer(String customerName, Cab cab) {

        this.customerName = customerName;
        this.cab = cab;
    }

    @Override
    public void run() {

        cab.bookCab(customerName);

    }
}

// Main Class
public class Main1 {

    public static void main(String[] args) {

        // One Shared Cab
        Cab cab = new Cab();

        // Customer Threads
        Customer customer1 = new Customer("Customer 1", cab);
        Customer customer2 = new Customer("Customer 2", cab);
        Customer customer3 = new Customer("Customer 3", cab);

        // Start Threads
        customer1.start();
        customer2.start();
        customer3.start();

    }
}