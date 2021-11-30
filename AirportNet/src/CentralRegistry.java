import java.util.ArrayList;

public class CentralRegistry {

	private static ArrayList<Airport> airports = new ArrayList<Airport>();
	private static ArrayList<Flight> flights = new ArrayList<Flight>();
	
	//Καταχώρηση ενός αεροδρομίου.
	public static void addAirport(Airport anAirport) {
		airports.add(anAirport);
	}
	
	//Καταχώρηση ενός δρομολογίου.
	public static void addFlight(Flight aFlight) {
		flights.add(aFlight);
		aFlight.getAirportA().addDirectlyConnectedAirport(aFlight.getAirportB());
		aFlight.getAirportB().addDirectlyConnectedAirport(aFlight.getAirportA());
		aFlight.getAirportA().addCompany(aFlight.getCompanyName());
		aFlight.getAirportB().addCompany(aFlight.getCompanyName());
	}
	
	//Επιστρέφει το αεροδρόμιο με τις περισσότερες απευθείας συνδέσεις με άλλα αεροδρόμια.
	public static Airport getLargestHub() {
		Airport largestHub = new Airport();
		for (Airport airport: airports) {
			if (airport.getDirectlyConnectedAirportsSize() > largestHub.getDirectlyConnectedAirportsSize())
				largestHub = airport;
		}
		return largestHub;
	}
	
	//Επιστρέφει την πτήση με τη μεγαλύτερη διάρκεια.
	public static Flight getLongestFlight() {
		Flight longestFlight = new Flight();
		longestFlight.setFlightDuration(0);
		for (Flight flight: flights) {
			if (flight.getFlightDuration() > longestFlight.getFlightDuration())
				longestFlight = flight;
		}
		return longestFlight;
	}
	
	
}
