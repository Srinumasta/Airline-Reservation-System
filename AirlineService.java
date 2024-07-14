import java.util.ArrayList;
import java.util.List;

public class AirlineService {
    private List<Flight> flights;
    private List<Reservation> reservations;

    public AirlineService() {
        flights = new ArrayList<>();
        reservations = new ArrayList<>();
    }

    public List<Flight> getAllFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
        // Reduce available seats for the booked flight
        Flight bookedFlight = reservation.getFlight();
        bookedFlight.setSeatsAvailable(bookedFlight.getSeatsAvailable() - 1);
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
