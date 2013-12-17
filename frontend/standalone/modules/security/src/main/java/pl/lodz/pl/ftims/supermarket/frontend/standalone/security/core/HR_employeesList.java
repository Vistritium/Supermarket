package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;

public class HR_employeesList extends HR_templateList{
	public HR_employeesList(final HR_main ref) {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(50, 50, 345, 169);
		add(list);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(218, 243, 89, 23);
		add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		//btnCancel.addMouseListener(
		//getParent().getComponentAt(404, 2).action(new Event(ActionEvent e), new Object());
		//getParent().action(evt, what);// update(eComponent.idle);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ref.switchPanel(eComponent.idle);//update(eComponent.idle);
			}
		});
		btnCancel.setBounds(317, 243, 89, 23);
		add(btnCancel);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.setBounds(119, 243, 89, 23);
		add(btnFilter);
	}

	//CEmployee list[];
	
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
