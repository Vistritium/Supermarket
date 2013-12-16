package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;


import javax.swing.JPanel;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Initalizable;
import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.JPanelInjection;
//import pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core.MainStatisticsPanel;

public class Init implements Initalizable{

	@Override

	public void init(JPanelInjection jPanelInjection) {
		HR_main panel= new HR_main();
		panel.setName("HR");
		JPanel TEMP = new JPanel();
		TEMP.setName("MACIEK");
		jPanelInjection.addJPanel(TEMP);
		//jPanelInjection.addJPanel(panel.getMainPanel());
		//JPanel jPanel;

	}



}
