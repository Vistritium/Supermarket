import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JToolBar;


public class MainPanel extends JPanel {
	TabPanel taby;
	public MainPanel(){
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("G³ówne okno"));
		//this.setBackground(Color.BLUE);
		this.taby = new TabPanel();
		this.add(taby);
		//System.out.println("Dodalem taby");		
		this.taby.setVisible(true);
		//System.out.println("Stworzylem mainPanel");
		
	}
}
