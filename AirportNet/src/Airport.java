import java.util.ArrayList;

public class Airport {

	private String name;
	private String code;
	private String townLocated;
	private String countryLocated;
	//Λίστα με τα απευθείας συνδεδεμένα αεροδρόμια με ένα αεροδρόμιο.
	private ArrayList<Airport> directlyConnectedAirports = new ArrayList<Airport>();
	//Λίστα με τις εταιρείες που εξυπηρετούν ένα αεροδρόμιο.
	private ArrayList<String> companiesServing = new ArrayList<String>();
	
	public Airport() {
		
	}
	
	public Airport(String aName, String aCode, String aTown, String aCountry) {
		name = aName;
		code = aCode;
		townLocated = aTown;
		countryLocated = aCountry;
	}

	public String getName() {
		return name;
	}
	
	public int getDirectlyConnectedAirportsSize() {
		return directlyConnectedAirports.size();
	}
	
	//Εισαγωγή ενός αεροδρομίου στη λίστα με τα απευθείας συνδεδεμένα αεροδρόμια.
	public void addDirectlyConnectedAirport(Airport anAirport) {
		directlyConnectedAirports.add(anAirport);
	}
	
	//Εισαγωγή μιας εταιρείας στη λίστα με τις εταιρείες που εξυπηρετούν ένα αεροδρόμιο.
	public void addCompany(String aCompany) {
		companiesServing.add(aCompany);
	}
	
	//Έλεγχος ύπαρξης απευθείας σύνδεσης μεταξύ δύο αεροδρομίων.
	public boolean isDirectlyConnectedTo(Airport anAirport) {
		return this.directlyConnectedAirports.contains(anAirport); 
	}
	
	//Έλλεγχος ύπαρξης έμμεσης σύνδεσης μεταξύ δύο αεροδρομίων.
	public boolean isInDirectlyConnectedTo(Airport anAirport) {
		for (Airport airport: this.directlyConnectedAirports) {
			if (airport.directlyConnectedAirports.contains(anAirport))
				return true;
		}
		return false;
	}
	
	//Κατασκευή λίστας με τα κοινά απευθείας συνδεδεμένα αεροδρόμια μεταξύ δύο αεροδρομίων.
	public ArrayList<Airport> getCommonConnections(Airport anAirport){
		ArrayList<Airport> commonConnections = new ArrayList<Airport>();
		for (Airport airport: this.directlyConnectedAirports) {
			if (this.directlyConnectedAirports.contains(airport) && anAirport.directlyConnectedAirports.contains(airport))
				commonConnections.add(airport);
		}
		return commonConnections;
	}
	
	//Εκτύπωση των ονομάτων των εταιρειών που εξυπηρετούν ένα αεροδρόμιο.
	public void printCompanies() {
		for (String company: companiesServing) {
			System.out.println(company);
		}
	}
	
}
