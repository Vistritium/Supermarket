package pl.lodz.pl.ftims.supermarket.frontend.standalone.statistics.core;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Initalizable;
import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.JPanelInjection;

public class Init implements Initalizable{

	@Override
	public void init(JPanelInjection jPanelInjection) {
		MainStatisticsPanel panel= new MainStatisticsPanel();
		panel.setName("Statistics Module");
		jPanelInjection.addJPanel(panel);
		
	}



}
