package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	TabPanel taby;

	public MainPanel(List<Initalizable> modules){
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder("Główne okno"));
		//this.setBackground(Color.BLUE);
		this.taby = new TabPanel();
		this.add(taby);
		//System.out.println("Dodalem taby");		
		this.taby.setVisible(true);
		for(Initalizable module : modules){
			module.init(taby);
		}
		//System.out.println("Stworzylem mainPanel");
	}
}