package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import backend.api.HumanResources;
import backend.core.model.Users;
import javax.swing.JLabel;

public class HR_employee extends HR_templateSingle{
	private JTextField txtName;
	private JTextField txtSurname;
	private JTextField txtDate;
	public HR_employee(final HR_main ref, final int mainIndex) {//final Object mainObj) {
		setLayout(null);
		
		final Users temp;
		int tempI = 0;
		if (mainIndex >= 0) {
			temp = ref.allUsers.get(mainIndex);
			tempI = mainIndex;
		} else {
			temp = ref.allUsers.get(ref.allUsers.indexOf(ref.selfUser));
			tempI = ref.allUsers.indexOf(ref.selfUser);
		}
		
		final int tempIndex = tempI;
		
		txtName = new JTextField();
		txtName.setText("name");
		txtName.setBounds(136, 91, 102, 20);
		//txtName.disable();
		add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setText("surname");
		txtSurname.setBounds(136, 122, 102, 20);
		//txtSurname.disable();
		add(txtSurname);
		txtSurname.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setText("date");
		txtDate.setBounds(136, 153, 102, 20);
		txtDate.disable();
		add(txtDate);
		txtDate.setColumns(10);
		
		/*JButton btnEdit = new JButton("edit");
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//txtName.enable(!txtName.isEnabled());
				if (txtName.isEnabled()) {
					txtName.enable();
				} else {
					txtName.disable();
				}
				txtSurname.enable(!txtSurname.isEnabled());
				txtDate.enable(!txtDate.isEnabled());
			}
		});
		
		btnEdit.setBounds(248, 153, 89, 44);
		add(btnEdit);
		*/
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (mainIndex < 0) {
					ref.switchPanel(EComponent.idle);
				} else {
					ref.switchPanel(EComponent.listEmployee);
				}
			}
		});
		btnCancel.setBounds(248, 211, 89, 23);
		add(btnCancel);
		
		JButton btnApply = new JButton("apply");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//temp.setName(txtName.getText());
				//temp.setSurname(txtSurname.getText());
				
				ref.allUsers.get(tempIndex).setName(txtName.getText());
				ref.allUsers.get(tempIndex).setSurname(txtSurname.getText());
				
				if (mainIndex < 0) {
					ref.switchPanel(EComponent.idle);
				} else {
					ref.switchPanel(EComponent.listEmployee);
				}
			}
		});
		btnApply.setBounds(61, 211, 177, 23);
		add(btnApply);
		
		//HumanResources humanResources = new HumanResources();
		//List<Users> allUsers = humanResources.getAllUsers();
		//Users temp = //ref.allUsers.get(1);
		//Users temp = ref.allUsers.get(ref.allUsers.indexOf(mainObj));
		
		
		
		txtName.setText(temp.getName());
		txtSurname.setText(temp.getSurname());
		//txtDate.setText(temp.getHired().toString());
		//temp.getHired().toGMTString();
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(61, 94, 46, 14);
		add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(61, 125, 46, 14);
		add(lblSurname);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(61, 156, 46, 14);
		add(lblDate);
		
		
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
	void update(EComponent ecom) {
		// TODO Auto-generated method stub
		
	}
}
