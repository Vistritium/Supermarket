package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.xml.ws.handler.HandlerResolver;

import backend.api.HumanResources;

import java.awt.BorderLayout;



public class HR_main extends HR_template{

	public JPanel templatePanel;
	
	HR_employee 		panEmployee;
	HR_employeesList	panEList;
	HR_group			panGroup;
	HR_groupList		panGList;

	
	public HR_main() {
		templatePanel = new JPanel();
		//jpan = new JPanel();
		//panEmployee = new HR_employee();
		//panEList	= new HR_employeesList();
		//panGroup	= new 
				
	}
	
	public int switchPanel(eComponent panel) {
		return 0;
	}

	@Override
	void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void draw() {
		
		
	}

	@Override
	void init() {
		
		
		
	}

	@Override
	void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void shutdown() {
		// TODO Auto-generated method stub
		
	}
	
}
