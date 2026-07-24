import java.util.ArrayList;

public class Bus {

    private int busId;
    private String busName;
    private String route;
    private int capacity;
    private int availableSeats;

    public Bus(int busId, String busName, String route, int capacity) {
        this.busId = busId;
        this.busName = busName;
        this.route = route;
        this.capacity = capacity;
        this.availableSeats = capacity;
    }

    public int getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public String getRoute() {
        return route;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void bookSeat() {
        availableSeats--;
    }

    public void cancelSeat() {
        availableSeats++;
    }

    public void display() {
        System.out.println("--------------------------------");
        System.out.println("Bus ID : " + busId);
        System.out.println("Bus Name : " + busName);
        System.out.println("Route : " + route);
        System.out.println("Capacity : " + capacity);
        System.out.println("Available Seats : " + availableSeats);
    }
}
