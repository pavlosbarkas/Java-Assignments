
public class Flight {

	private Airport airportA;
	private Airport airportB;
	private int flightDuration;
	private String companyName;
	
	public Flight(){
		
	}
	
	public Flight(Airport airportA, Airport airportB, int flightDuration, String companyName) {
		this.airportA = airportA;
		this.airportB = airportB;
		this.flightDuration = flightDuration;
		this.companyName = companyName;
	}

	public Airport getAirportA() {
		return airportA;
	}

	public Airport getAirportB() {
		return airportB;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
	}

	public int getFlightDuration() {
		return flightDuration;
	}

	public String toString() {
		return ("Flight operated by " + this.getCompanyName() + ", duration " + this.getFlightDuration() + " minutes.");
	}
}
