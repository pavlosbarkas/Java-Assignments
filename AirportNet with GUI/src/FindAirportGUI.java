import java.awt.event.*;
import javax.swing.*;

public class FindAirportGUI extends JFrame{

	private JPanel panel = new JPanel();
	private JTextField searchTextField = new JTextField(20);
	private JButton findButton = new JButton("Find");
	
	public FindAirportGUI() {
		
		panel.add(searchTextField);
		panel.add(findButton);
		
		this.setContentPane(panel);
		
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cityName = searchTextField.getText();
				if (CentralRegistry.getAirport(cityName) == null) {
					JOptionPane.showMessageDialog(null, cityName + " does not have an airport!");
				}else {
					new AirportPageGUI(CentralRegistry.getAirport(cityName));
				}
			}
		});
		
		this.setVisible(true);
		this.setSize(400, 200);
		this.setTitle("Find Airport");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
