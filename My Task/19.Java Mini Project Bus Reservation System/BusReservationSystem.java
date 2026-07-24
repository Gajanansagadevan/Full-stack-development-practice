import java.util.ArrayList;
import java.util.Scanner;

public class BusReservationSystem {

    static ArrayList<Bus> buses = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== BUS RESERVATION SYSTEM =====");
            System.out.println("1. Add Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Update Bus Capacity");
            System.out.println("4. Delete Bus");
            System.out.println("5. Book Ticket");
            System.out.println("6. View All Bookings");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBus();
                    break;

                case 2:
                    viewBuses();
                    break;

                case 3:
                    updateCapacity();
                    break;

                case 4:
                    deleteBus();
                    break;

                case 5:
                    bookTicket();
                    break;

                case 6:
                    viewBookings();
                    break;

                case 7:
                    cancelBooking();
                    break;

                case 8:
                    System.out.println("Thank You...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    static void addBus() {

        System.out.print("Bus ID : ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Bus Name : ");
        String name = sc.nextLine();

        System.out.print("Route : ");
        String route = sc.nextLine();

        System.out.print("Capacity : ");
        int cap = sc.nextInt();

        buses.add(new Bus(id, name, route, cap));

        System.out.println("Bus Added Successfully.");
    }

    static void viewBuses() {

        if (buses.isEmpty()) {
            System.out.println("No buses available.");
            return;
        }

        for (Bus b : buses)
            b.display();
    }

    static void updateCapacity() {

        System.out.print("Enter Bus ID : ");
        int id = sc.nextInt();

        for (Bus b : buses) {

            if (b.getBusId() == id) {

                System.out.print("New Capacity : ");
                int cap = sc.nextInt();

                b.setCapacity(cap);

                System.out.println("Capacity Updated.");

                return;
            }
        }

        System.out.println("Bus Not Found.");
    }

    static void deleteBus() {

        System.out.print("Enter Bus ID : ");
        int id = sc.nextInt();

        for (Bus b : buses) {

            if (b.getBusId() == id) {

                buses.remove(b);

                System.out.println("Bus Deleted.");

                return;
            }
        }

        System.out.println("Bus Not Found.");
    }

    static void bookTicket() {

        System.out.print("Booking ID : ");
        int bookingId = sc.nextInt();

        sc.nextLine();

        System.out.print("Passenger Name : ");
        String name = sc.nextLine();

        System.out.print("Bus ID : ");
        int busId = sc.nextInt();

        for (Bus b : buses) {

            if (b.getBusId() == busId) {

                if (b.getAvailableSeats() > 0) {

                    b.bookSeat();

                    bookings.add(new Booking(bookingId, name, busId));

                    System.out.println("Booking Successful.");

                } else {

                    System.out.println("No Seats Available.");
                }

                return;
            }
        }

        System.out.println("Bus Not Found.");
    }

    static void viewBookings() {

        if (bookings.isEmpty()) {

            System.out.println("No Bookings.");

            return;
        }

        for (Booking b : bookings)
            b.display();
    }

    static void cancelBooking() {

        System.out.print("Booking ID : ");
        int id = sc.nextInt();

        for (Booking bk : bookings) {

            if (bk.getBookingId() == id) {

                for (Bus bus : buses) {

                    if (bus.getBusId() == bk.getBusId()) {

                        bus.cancelSeat();

                        break;
                    }
                }

                bookings.remove(bk);

                System.out.println("Booking Cancelled.");

                return;
            }
        }

        System.out.println("Booking Not Found.");
    }
}