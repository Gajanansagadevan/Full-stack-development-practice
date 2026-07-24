public class Booking {

    private int bookingId;
    private String passengerName;
    private int busId;

    public Booking(int bookingId, String passengerName, int busId) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.busId = busId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getBusId() {
        return busId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void display() {
        System.out.println("---------------------------");
        System.out.println("Booking ID : " + bookingId);
        System.out.println("Passenger : " + passengerName);
        System.out.println("Bus ID : " + busId);
    }
}