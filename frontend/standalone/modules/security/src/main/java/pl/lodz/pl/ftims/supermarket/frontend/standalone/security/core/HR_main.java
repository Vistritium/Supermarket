package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.xml.bind.Marshaller.Listener;
import javax.xml.ws.handler.HandlerResolver;

import backend.api.HumanResources;
import backend.core.model.Groups;
import backend.core.model.Users;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.util.List;



public class HR_main extends HR_template{

	public JPanel templatePanel;
	public JPanel mainPanel;
	
	HR_employee 		panEmployee;
	HR_employeesList	panEList;
	HR_group			panGroup;
	HR_groupList		panGList;
	List<Users> 		allUsers;
	List<Groups>		allGroups;
	HumanResources 		humanResources;
	Users 				selfUser;
	int					helpIndex = -1;
	
	public JPanel getMainPanel() {return mainPanel;}
	
	public HR_main() {
		templatePanel = new JPanel();
		//jpan = new JPanel();
		mainPanel = new JPanel();
		
		humanResources = new HumanResources();
		allUsers = humanResources.getAllUsers();
		allGroups = humanResources.getGroup();
		selfUser = allUsers.get(1);
		
		init();
		mainPanel.setLayout(new GridLayout(0, 1, 0, 0));
		//mainPanel.add(jpan);
		//templatePanel = getPanel();
		//mainPanel.setLayout(new BorderLayout());
		mainPanel.add(templatePanel);
		
		draw();
		
		//panEmployee = new HR_employee();
		//panEList	= new HR_employeesList();
		//panGroup	= new 
				
	}
	
	public int switchPanel(EComponent panel) {
		
		mainPanel.removeAll();
		
		switch (panel) {
		case employee:
			//panEmployee = new HR_employee();
			//templatePanel = panEmployee.getPanel();
			if (helpIndex >= 0) { 
				mainPanel.add(new HR_employee(this, /*panEList.list.getSelectedIndex()*/ helpIndex));
				helpIndex = -1;
			}
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
			if (helpIndex >= 0) {
				mainPanel.add(new HR_group(this, helpIndex));
				helpIndex = -1;
			}
			//templatePanel = panGroup.getPanel();
			break;
		case listGroup:
			//panGList = new HR_groupList();
			//templatePanel = panGList.getPanel();
			
			mainPanel.add(new HR_groupList(this));
			
			break;
		case self:
			mainPanel.add(new HR_employee(this,-1));//allUsers.indexOf(selfUser)));
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
	
	public void applyChanges(EComponent panel) {
		if (panel == EComponent.listEmployee){
			for (int i=0; i<allUsers.size(); i++) {
				//if (i >= humanResources.getAllUsers().size()) {
				if ( humanResources.getUser(allUsers.get(i).getIdusers()) == null ) {
					humanResources.addUser(allUsers.get(i));
				} else {
					humanResources.editUser(allUsers.get(i));
				}
			}
			
			List<Users> quickTemp = humanResources.getAllUsers();
			for (int i=0; i<quickTemp.size(); ++i) {
				if (!allUsers.contains(quickTemp.get(i))) {
					humanResources.removeUser(quickTemp.get(i).getIdusers());
				}
			}
			allUsers = humanResources.getAllUsers();
			//allUsers.a
		} else if (panel == EComponent.listGroup) {
			for (int i=0; i<allGroups.size(); i++) {
				if ( humanResources.getGroup().size() == 0 || !humanResources.getGroup().contains(allGroups.get(i))) {//(allUsers.get(i).getIdusers()) == null ) {
					humanResources.addGroup(allGroups.get(i));
				} else {
					humanResources.editGroup(allGroups.get(i));
				}
			}
			
			List<Groups> quickTemp = humanResources.getGroup();
			for (int i=0; i<quickTemp.size(); ++i) {
				if (!allGroups.contains(quickTemp.get(i))) {
					humanResources.removeGroup(quickTemp.get(i).getIdgroups());
				}
			}
			
			allGroups = humanResources.getGroup();
		}
	}
	
	public void cancelChanges(EComponent panel) {
		if (panel == EComponent.listEmployee){
			allUsers = humanResources.getAllUsers();
		} else if (panel == EComponent.listGroup) {
			allGroups = humanResources.getGroup();
		}
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
				switchPanel(EComponent.self);
			}
		});
		btnSelf.setBounds(145, 78, 89, 45);
		templatePanel.add(btnSelf);
		
		JButton btnEmployeeList = new JButton("Employee list");
		btnEmployeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanel(EComponent.listEmployee);
			}
		});
		btnEmployeeList.setBounds(124, 158, 130, 23);
		templatePanel.add(btnEmployeeList);
		
		JButton btnGroupList = new JButton("Group list");
		btnGroupList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanel(EComponent.listGroup);
			}
		});
		btnGroupList.setBounds(145, 192, 89, 23);
		templatePanel.add(btnGroupList);
		
		JLabel lblNewLabel = new JLabel( "" + selfUser.getName() + " " + selfUser.getSurname() ); //("Name Forename");
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
			switchPanel(EComponent.idle);
		}
	};

	@Override
	void update(EComponent ecom) {
		switchPanel(ecom);
		
	}
	
}
