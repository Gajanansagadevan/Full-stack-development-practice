import java.util.ArrayList;
import java.util.Scanner;

public class BusReservationSystem {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Bus> buses = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println(" BUS RESERVATION SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Update Bus Capacity");
            System.out.println("4. Delete Bus");
            System.out.println("5. Search Bus");
            System.out.println("6. Book Ticket");
            System.out.println("7. View Bookings");
            System.out.println("8. Cancel Booking");
            System.out.println("9. Exit");
            System.out.print("Enter Choice : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addBus();
                    break;

                case 2:
                    viewBuses();
                    break;

                case 3:
                    updateBus();
                    break;

                case 4:
                    deleteBus();
                    break;

                case 5:
                    searchBus();
                    break;

                case 6:
                    bookTicket();
                    break;

                case 7:
                    viewBookings();
                    break;

                case 8:
                    cancelBooking();
                    break;

                case 9:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 9);

    }

    static void addBus() {

        System.out.print("Bus Number : ");
        String number = scanner.nextLine();

        if (findBus(number) != null) {
            System.out.println("Bus already exists.");
            return;
        }

        System.out.print("Source : ");
        String source = scanner.nextLine();

        System.out.print("Destination : ");
        String destination = scanner.nextLine();

        System.out.print("Capacity : ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        buses.add(new Bus(number, source, destination, capacity));

        System.out.println("Bus Added Successfully.");
    }

    static void viewBuses() {

        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }

        for (Bus bus : buses) {
            System.out.println("-------------------------");
            System.out.println(bus);
        }
    }

    static void updateBus() {

        System.out.print("Enter Bus Number : ");
        String number = scanner.nextLine();

        Bus bus = findBus(number);

        if (bus == null) {
            System.out.println("Bus Not Found.");
            return;
        }

        System.out.print("New Capacity : ");
        int cap = scanner.nextInt();
        scanner.nextLine();

        if (cap < bus.getBookedSeats()) {
            System.out.println("Capacity cannot be less than booked seats.");
            return;
        }

        bus.setCapacity(cap);

        System.out.println("Capacity Updated.");
    }

    static void deleteBus() {

        System.out.print("Enter Bus Number : ");
        String number = scanner.nextLine();

        Bus bus = findBus(number);

        if (bus == null) {
            System.out.println("Bus Not Found.");
            return;
        }

        buses.remove(bus);

        bookings.removeIf(b -> b.getBus().getBusNumber().equals(number));

        System.out.println("Bus Deleted Successfully.");
    }

    static void searchBus() {

        System.out.print("Enter Bus Number : ");
        String number = scanner.nextLine();

        Bus bus = findBus(number);

        if (bus == null)
            System.out.println("Bus Not Found.");
        else
            System.out.println(bus);
    }

    static void bookTicket() {

        System.out.print("Passenger ID : ");
        String id = scanner.nextLine();

        if (findBooking(id) != null) {
            System.out.println("Passenger ID already exists.");
            return;
        }

        System.out.print("Passenger Name : ");
        String name = scanner.nextLine();

        System.out.print("Bus Number : ");
        String number = scanner.nextLine();

        Bus bus = findBus(number);

        if (bus == null) {
            System.out.println("Bus Not Found.");
            return;
        }

        if (bus.getAvailableSeats() == 0) {
            System.out.println("No Seats Available.");
            return;
        }

        bus.bookSeat();

        bookings.add(new Booking(id, name, bus));

        System.out.println("Ticket Booked Successfully.");
    }

    static void viewBookings() {

        if (bookings.isEmpty()) {
            System.out.println("No Bookings Found.");
            return;
        }

        for (Booking booking : bookings) {
            System.out.println("---------------------------");
            System.out.println(booking);
        }
    }

    static void cancelBooking() {

        System.out.print("Passenger ID : ");
        String id = scanner.nextLine();

        Booking booking = findBooking(id);

        if (booking == null) {
            System.out.println("Booking Not Found.");
            return;
        }

        booking.getBus().cancelSeat();

        bookings.remove(booking);

        System.out.println("Booking Cancelled Successfully.");
    }

    static Bus findBus(String busNumber) {

        for (Bus bus : buses) {

            if (bus.getBusNumber().equalsIgnoreCase(busNumber))
                return bus;

        }

        return null;
    }

    static Booking findBooking(String passengerId) {

        for (Booking booking : bookings) {

            if (booking.getPassengerId().equalsIgnoreCase(passengerId))
                return booking;

        }

        return null;
    }
}