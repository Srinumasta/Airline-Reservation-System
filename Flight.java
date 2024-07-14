public class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private int seatsAvailable;

    public Flight(String flightNumber, String departure, String destination, int seatsAvailable) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }
}
