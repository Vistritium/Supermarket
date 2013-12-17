package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class HR_group extends HR_templateList{
	private JTextField txtName;
	private JTextField txtDescription;
	private JTextField txtSalary;
	public HR_group(final HR_main ref) {
		setLayout(null);
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(77, 85, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setText("description");
		txtDescription.setBounds(77, 116, 154, 43);
		add(txtDescription);
		txtDescription.setColumns(10);
		
		txtSalary = new JTextField();
		txtSalary.setText("salary");
		txtSalary.setBounds(77, 170, 86, 20);
		add(txtSalary);
		txtSalary.setColumns(10);
		
		JButton btnEdit = new JButton("edit");
		btnEdit.setBounds(257, 191, 89, 43);
		add(btnEdit);
		
		JButton btnApply = new JButton("apply");
		btnApply.setBounds(77, 211, 170, 23);
		add(btnApply);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ref.switchPanel(eComponent.idle);//update(eComponent.idle);
			}
		});
		btnCancel.setBounds(257, 245, 89, 23);
		add(btnCancel);
	}
	
	//CGroup group;
	
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
