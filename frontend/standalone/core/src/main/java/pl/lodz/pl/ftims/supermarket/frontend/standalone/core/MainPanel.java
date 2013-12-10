package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	TabPanel taby;

	public MainPanel(){
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("Główne okno"));
		//this.setBackground(Color.BLUE);
		this.taby = new TabPanel();
		this.add(taby);
		//System.out.println("Dodalem taby");		
		this.taby.setVisible(true);
		//System.out.println("Stworzylem mainPanel");
	}
}