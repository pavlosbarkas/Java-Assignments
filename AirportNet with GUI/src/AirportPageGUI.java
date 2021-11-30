import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AirportPageGUI extends JFrame{

	private JPanel panel = new JPanel();
	private JPanel airportDataPanel = new JPanel();
	private JPanel searchPanel = new JPanel();
	private JPanel flightDetailsPanel = new JPanel();
	
	private JTextField airportNameField = new JTextField(10);
	private JTextField airportCodeField = new JTextField(10);
	private JTextField airportCityField = new JTextField(10);
	private JTextField airportCountryField = new JTextField(10);
	private JTextArea companiesServingArea = new JTextArea(5, 10);
	
	private JTextField destinationField = new JTextField(10);
	private JButton findFlightsButton = new JButton("Find Flights");
	private JTextArea directFlightsArea = new JTextArea(10, 35);
	private JTextArea indirectFlightsArea = new JTextArea(10, 35);
	private JButton backButton = new JButton("Back to Search Screen");
	
	public AirportPageGUI(Airport airport) {
		
		airportNameField.setText(airport.getName());
		airportCodeField.setText(airport.getCode());
		airportCityField.setText(airport.getCityLocated());
		airportCountryField.setText(airport.getCountryLocated());
		for (String company: airport.getCompaniesServing())
			companiesServingArea.append(company + "\n");
	
		airportDataPanel.add(airportNameField);
		airportDataPanel.add(airportCodeField);
		airportDataPanel.add(airportCityField);
		airportDataPanel.add(airportCountryField);
		airportDataPanel.add(companiesServingArea);
		airportDataPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
		searchPanel.add(destinationField);
		searchPanel.add(findFlightsButton);
		
		flightDetailsPanel.add(directFlightsArea);
		flightDetailsPanel.add(indirectFlightsArea);
		
		panel.add(airportDataPanel);
		panel.add(searchPanel);
		panel.add(flightDetailsPanel);
		panel.add(backButton);
		
		this.setContentPane(panel);
		
		findFlightsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String destination = destinationField.getText();
				if (destination.equals(airportCityField.getText())) {
					JOptionPane.showMessageDialog(null, "Arrival and departure city cannot be the same!");
				}else {
					ArrayList<String> directFlightsDetails = new ArrayList<>();
					ArrayList<String> indirectFlightsDetails = new ArrayList<>();
					
					directFlightsDetails = CentralRegistry.getDirectFlightsDetails(airport, CentralRegistry.getAirport(destination));
					indirectFlightsDetails = CentralRegistry.getInDirectFlightsDetails(airport, CentralRegistry.getAirport(destination));
					
					for (String line: directFlightsDetails)
						directFlightsArea.append(line + "\n");
					for (String line: indirectFlightsDetails)
						indirectFlightsArea.append(line + "\n");
					directFlightsArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					indirectFlightsArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				}
			}
		});
		
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FindAirportGUI();
			}
		});
		
		this.setVisible(true);
		this.setTitle("Airport Page");
		this.setSize(820, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}