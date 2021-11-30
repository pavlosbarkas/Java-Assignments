
public class Flight {

	private Airport airportA;
	private Airport airportB;
	private int flightDuration;
	private String companyName;
	
	public Flight(){
		
	}
	
	public Flight(Airport airport1, Airport airport2, int aFlightDuration, String aCompanyName) {
		airportA = airport1;
		airportB = airport2;
		flightDuration = aFlightDuration;
		companyName = aCompanyName;
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
	
}
