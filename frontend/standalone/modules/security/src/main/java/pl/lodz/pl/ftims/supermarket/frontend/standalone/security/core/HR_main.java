package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.xml.ws.handler.HandlerResolver;

import backend.api.HumanResources;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class HR_main extends HR_template{

	public JPanel templatePanel;
	public JPanel mainPanel;
	
	HR_employee 		panEmployee;
	HR_employeesList	panEList;
	HR_group			panGroup;
	HR_groupList		panGList;
	
	public JPanel getMainPanel() {return mainPanel;}
	
	public HR_main() {
		//templatePanel = new JPanel();
		jpan = new JPanel();
		mainPanel = new JPanel();
		
		init();
		templatePanel = getPanel();
		mainPanel.setLayout(null);
		mainPanel.add(templatePanel);
		mainPanel.revalidate();
		mainPanel.repaint();
		
		//panEmployee = new HR_employee();
		//panEList	= new HR_employeesList();
		//panGroup	= new 
				
	}
	
	public int switchPanel(eComponent panel) {
		
		switch (panel) {
		case employee:
			panEmployee = new HR_employee();
			templatePanel = panEmployee.getPanel();
			break;
		case listEmployee :
			panEList = new HR_employeesList();
			templatePanel = panEList.getPanel();
			break;
		case group :
			panGroup = new HR_group();
			templatePanel = panGroup.getPanel();
			break;
		case listGroup:
			panGList = new HR_groupList();
			templatePanel = panGList.getPanel();
			break;
		case idle :
		default:
			templatePanel = getPanel();
		};
		
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
		
		jpan.setName("Human Resouces");
		
		jpan.setLayout(null);
		
		JButton btnSelf = new JButton("Self");
		btnSelf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(eComponent.listEmployee);
			}
		});
		btnSelf.setBounds(145, 78, 89, 45);
		jpan.add(btnSelf);
		
		JButton btnEmployeeList = new JButton("Employee list");
		btnEmployeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanel(eComponent.listEmployee);
			}
		});
		btnEmployeeList.setBounds(124, 158, 130, 23);
		jpan.add(btnEmployeeList);
		
		JButton btnGroupList = new JButton("Group list");
		btnGroupList.setBounds(145, 192, 89, 23);
		jpan.add(btnGroupList);
		
		JLabel lblNewLabel = new JLabel("Name Forename");
		lblNewLabel.setBounds(10, 11, 187, 14);
		jpan.add(lblNewLabel);
		
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
