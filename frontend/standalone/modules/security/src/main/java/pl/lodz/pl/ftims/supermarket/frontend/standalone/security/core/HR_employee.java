package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import backend.api.HumanResources;
import backend.core.model.Users;

public class HR_employee extends HR_templateSingle{
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtDate;
	public HR_employee(final HR_main ref) {
		setLayout(null);
		
		
		
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(104, 91, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setText("surname");
		txtSurname.setBounds(104, 122, 86, 20);
		add(txtSurname);
		txtSurname.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText("date");
		txtDate.setBounds(104, 153, 86, 20);
		add(txtDate);
		txtDate.setColumns(10);
		
		JButton btnEdit = new JButton("edit");
		btnEdit.setBounds(248, 190, 89, 44);
		add(btnEdit);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ref.switchPanel(eComponent.idle);//update(eComponent.idle);
			}
		});
		btnCancel.setBounds(248, 245, 89, 23);
		add(btnCancel);
		
		JButton btnApply = new JButton("apply");
		btnApply.setBounds(61, 211, 177, 23);
		add(btnApply);
		
		HumanResources humanResources = new HumanResources();
		List<Users> allUsers = humanResources.getAllUsers();
		Users temp = allUsers.get(0);
		
		txtName.setText(temp.getName());
		txtSurname.setText(temp.getSurname());
		
		
	}
	
	//CEmployee user;
	
	
	@Override
	int commit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int edit() {
		// TODO Auto-generated method stub
		return 0;
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
