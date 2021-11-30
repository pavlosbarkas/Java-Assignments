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
	
	//Επιστρέφει το αεροδρόμιο που υπάρχει σε μια πόλη.
	//Αν δεν υπάρχει τότε επιστρέφει null.
	public static Airport getAirport(String cityName) {
		for (Airport airport: airports) {
			if (airport.getCityLocated().equals(cityName)) {
				return airport;
			}
		}
		return null;
	}

	//Λεπτομέρεις για τις απευθείας πτήσεις (αν υπάρχουν) μεταξύ δύο αεροδρομίων.
	public static ArrayList<String> getDirectFlightsDetails(Airport a, Airport b) {
		ArrayList<String> details = new ArrayList<>();
		int counter = 1;
		if (a.isDirectlyConnectedTo(b)) {
			details.add("DIRECT FLIGHTS DETAILS:");
			for (Flight flight: flights) {
				if (flight.getAirportA().equals(a) && flight.getAirportB().equals(b)) {
					details.add("[" + String.valueOf(counter) + "] " +flight.toString());
					counter++;
				}
			}
		}else details.add("There are no direct flights!");
		return details;
	}

	//Λεπτομέρειες για το ενδιάμεσο αεροδρόμιο (αν υπάρχει) μεταξύ δύο αεροδρομίων.
	public static ArrayList<String> getInDirectFlightsDetails(Airport a, Airport b) {
		ArrayList<String> details = new ArrayList<>();
		int counter = 1;
		if (a.isInDirectlyConnectedTo(b)) {
			details.add("INDIRECT FLIGHTS THROUGH:");
			for (Airport airport: airports) {
				if (a.isDirectlyConnectedTo(airport) && airport.isDirectlyConnectedTo(b)){
					details.add("[" + String.valueOf(counter) + "] " + airport.getCityLocated() + ", " + airport.getCode() + " airport");
					counter++;
				}
			}
		}else details.add("There are no indirect flights!");
		return details;
	}
	
}
