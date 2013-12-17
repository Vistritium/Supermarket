package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.xml.bind.Marshaller.Listener;
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
		templatePanel = new JPanel();
		//jpan = new JPanel();
		mainPanel = new JPanel();
		
		init();
		mainPanel.setLayout(new BorderLayout());
		//mainPanel.add(jpan);
		//templatePanel = getPanel();
		//mainPanel.setLayout(new BorderLayout());
		mainPanel.add(templatePanel);
		
		draw();
		
		//panEmployee = new HR_employee();
		//panEList	= new HR_employeesList();
		//panGroup	= new 
				
	}
	
	public int switchPanel(eComponent panel) {
		
		mainPanel.removeAll();
		
		switch (panel) {
		case employee:
			//panEmployee = new HR_employee();
			//templatePanel = panEmployee.getPanel();
			mainPanel.add(new HR_employee(this));
			break;
		case listEmployee :
			//panEList = new HR_employeesList(this);
			//templatePanel = panEList.getPanel();
			//mainPanel.remove(templatePanel);
			//mainPanel.add(templatePanel);
			
			//mainPanel.removeAll();
			
			//mainPanel.add(new JPanel());
			//mainPanel.getComponent(0) = panEList.getPanel();
			mainPanel.add(new HR_employeesList(this));
			//add(new HR_employeesList());
			//mainPanel.revalidate();
			//mainPanel.repaint();
			break;
		case group :
			//panGroup = new HR_group();
			mainPanel.add(new HR_group(this));
			//templatePanel = panGroup.getPanel();
			break;
		case listGroup:
			//panGList = new HR_groupList();
			//templatePanel = panGList.getPanel();
			
			mainPanel.add(new HR_groupList(this));
			
			break;
		case idle :
		default:
			//templatePanel = getPanel();
			//mainPanel.add(templatePanel);
			//init();
			mainPanel.add(templatePanel);
			//mainPanel.add(getPanel());
		};
		
		draw();
		
		return 0;
	}

	@Override
	void draw() {
		
		mainPanel.revalidate();
		mainPanel.repaint();
		//revalidate();
		//repaint();
		
	}

	@Override
	void init() {
		
		templatePanel.setName("Human Resouces");
		
		templatePanel.setLayout(null);
		
		JButton btnSelf = new JButton("Self");
		btnSelf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanel(eComponent.employee);
			}
		});
		btnSelf.setBounds(145, 78, 89, 45);
		templatePanel.add(btnSelf);
		
		JButton btnEmployeeList = new JButton("Employee list");
		btnEmployeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanel(eComponent.listEmployee);
			}
		});
		btnEmployeeList.setBounds(124, 158, 130, 23);
		templatePanel.add(btnEmployeeList);
		
		JButton btnGroupList = new JButton("Group list");
		btnGroupList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanel(eComponent.listGroup);
			}
		});
		btnGroupList.setBounds(145, 192, 89, 23);
		templatePanel.add(btnGroupList);
		
		JLabel lblNewLabel = new JLabel("Name Forename");
		lblNewLabel.setBounds(10, 11, 187, 14);
		templatePanel.add(lblNewLabel);
		
	}

	@Override
	void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void shutdown() {
		// TODO Auto-generated method stub
		
	}
	
	ActionListener cancelListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			switchPanel(eComponent.idle);
		}
	};

	@Override
	void update(eComponent ecom) {
		switchPanel(ecom);
		
	}
	
}
