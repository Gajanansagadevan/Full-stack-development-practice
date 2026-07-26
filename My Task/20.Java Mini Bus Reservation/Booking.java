public class Booking {

    private String passengerId;
    private String passengerName;
    private Bus bus;

    public Booking(String passengerId, String passengerName, Bus bus) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.bus = bus;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Bus getBus() {
        return bus;
    }

    @Override
    public String toString() {
        return "Passenger ID : " + passengerId +
                "\nPassenger Name : " + passengerName +
                "\nBus Number : " + bus.getBusNumber() +
                "\nSource : " + bus.getSource() +
                "\nDestination : " + bus.getDestination();
    }
}