public class Bus {

    private String busNumber;
    private String source;
    private String destination;
    private int capacity;
    private int bookedSeats;

    public Bus(String busNumber, String source, String destination, int capacity) {
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void bookSeat() {
        bookedSeats++;
    }

    public void cancelSeat() {
        if (bookedSeats > 0)
            bookedSeats--;
    }

    public int getAvailableSeats() {
        return capacity - bookedSeats;
    }

    @Override
    public String toString() {
        return "Bus Number : " + busNumber +
                "\nSource : " + source +
                "\nDestination : " + destination +
                "\nCapacity : " + capacity +
                "\nBooked Seats : " + bookedSeats +
                "\nAvailable Seats : " + getAvailableSeats();
    }
}