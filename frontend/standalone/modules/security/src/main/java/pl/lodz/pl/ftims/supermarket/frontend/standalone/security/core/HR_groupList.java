package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class HR_groupList extends HR_templateList {
	public HR_groupList() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(50, 50, 345, 169);
		add(list);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(218, 243, 89, 23);
		add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(317, 243, 89, 23);
		add(btnCancel);
	}
	
	//CGroup groupList[];
	
	@Override
	void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void get() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void update(eComponent ecom) {
		// TODO Auto-generated method stub
		
	}
	
}
