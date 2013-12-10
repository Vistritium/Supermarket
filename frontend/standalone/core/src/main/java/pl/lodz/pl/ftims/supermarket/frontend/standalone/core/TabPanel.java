package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//W tej klasie znajduja sie taby i przykladwe dodane panele
public class TabPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	JTabbedPane tabPane;

	public TabPanel(){
		this.setLayout(new GridLayout(1,1));
        tabPane = new JTabbedPane();
        this.add(tabPane);
        
        //Przykladowo dodalem tutaj na szybko jakies panele
        this.tabPane.addTab("Tytul", new JLabel("Testowa labelka w TabPanel"));
        this.tabPane.addTab("Tytulinny", new JLabel("Testowa labelka w TabPanelu drugim"));
        this.addModul(new Panelzjakaszawartoscia());
	}

	public void addModul(Modul modul){
		this.tabPane.addTab(modul.getNazwa(),modul.getPanel());
	}
}