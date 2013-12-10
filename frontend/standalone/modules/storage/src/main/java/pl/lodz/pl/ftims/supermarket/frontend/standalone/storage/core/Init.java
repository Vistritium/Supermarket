package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Initalizable;
import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.JPanelInjection;

public class Init implements Initalizable{

	@Override
	public void init(JPanelInjection jPanelInjection) {
		PStorageManagment panel= new PStorageManagment();
		panel.setName("Storage Management");
		jPanelInjection.addJPanel(panel);
		
	}



}
