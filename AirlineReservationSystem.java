import java.util.List;
import java.util.Scanner;

public class AirlineReservationSystem {

    public static void main(String[] args) {
        AirlineService airlineService = new AirlineService();

        // Initialize some sample flights
        Flight flight1 = new Flight("ABC123", "New York", "Los Angeles", 150);
        Flight flight2 = new Flight("XYZ456", "San Francisco", "Chicago", 120);

        airlineService.addFlight(flight1);
        airlineService.addFlight(flight2);

        // Display available flights initially
        System.out.println("Available Flights:");
        displayFlights(airlineService.getAllFlights());

        // Simulate user input and reservation booking
        Scanner scanner = new Scanner(System.in);

        // Book a flight based on user input
        System.out.print("\nEnter Passenger Name: ");
        String passengerName = scanner.nextLine();

        System.out.print("Enter Flight Number to Book: ");
        String flightNumber = scanner.nextLine();

        Flight selectedFlight = findFlight(airlineService.getAllFlights(), flightNumber);

        if (selectedFlight != null) {
            Reservation reservation = new Reservation(passengerName, selectedFlight);
            airlineService.makeReservation(reservation);

            System.out.println("\nReservation Successful!");
            System.out.println("Your Reservation:");
            System.out.println(reservation.getPassengerName() + " - Flight " + reservation.getFlight().getFlightNumber());

            // Display updated reservations
            System.out.println("\nUpdated Reservations:");
            displayReservations(airlineService.getAllReservations());
        } else {
            System.out.println("\nFlight not found. Please enter a valid flight number.");
        }

        scanner.close();
    }

    private static Flight findFlight(List<Flight> flights, String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    private static void displayFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight.getFlightNumber() + " - " + flight.getDeparture() +
                    " to " + flight.getDestination() + ", Seats Available: " + flight.getSeatsAvailable());
        }
    }

    private static void displayReservations(List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            System.out.println(reservation.getPassengerName() + " - Flight " +
                    reservation.getFlight().getFlightNumber());
        }
    }
}
