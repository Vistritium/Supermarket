package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import backend.core.model.Groups;
import javax.swing.JScrollPane;

public class HR_group extends HR_templateList{
	private JTextField txtName;
	private JTextField txtDescription;
	private JTextField txtSalary;
	private JTable tableUsers;
	private JScrollPane scrollPane;
	private JButton btnDelUser;
	public	HR_main tempRef;
	public	int		tempMainIndex;
	public HR_group(final HR_main ref, int mainIndex) {
		setLayout(null);
		tempRef = ref;
		tempMainIndex = mainIndex;
		
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
				ref.switchPanel(EComponent.listGroup);//update(eComponent.idle);
			}
		});
		btnCancel.setBounds(257, 245, 89, 23);
		add(btnCancel);
		
		DefaultTableModel tempTable = new DefaultTableModel();
		Object[] tempObjID = {"a", "b", "c"};
		tempTable.setColumnIdentifiers(tempObjID);
		Object[][] data = new Object[ref.allUsers.size()][3];
		
		data[0][0] = "a"; data[0][1] = "b"; data[0][2] = "c";
		
		//Object[] tempObj = new Object[3];//{"", "", ""};
		for (int i = 0; i < ref.allUsers.size(); ++i) {
			/*Object[] tempObj = {"" + ref.allUsers.get(i).getIdusers(), 
								"" + ref.allUsers.get(i).getName(), 
								"" + ref.allUsers.get(i).getSurname()
								}; 
			*/
			data[i][0] = "" + ref.allUsers.get(i).getIdusers();
			data[i][1] = "" + ref.allUsers.get(i).getName();
			data[i][2] = "" + ref.allUsers.get(i).getSurname();
			
			//tempTable.addRow( tempObj );
		}
		
		String[] tempStr = {"a","b","c"};
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setPreferredSize(new Dimension(0, 0));
		
		JButton btnAddUser = new JButton("+");
		btnAddUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tableUsers.getSelectedRow() >= 0) {
					if(!tempRef.allGroups.get(tempMainIndex).getUsers().contains(tempRef.allUsers.get(tableUsers.getSelectedRow()))) {
						tempRef.allGroups.get(tempMainIndex).getUsers().add(tempRef.allUsers.get(tableUsers.getSelectedRow()));
					}
				}
				//get(temp).addUser();
				belong();
			}
		});
		btnAddUser.setBounds(421, 50, 41, 43);
		add(btnAddUser);
		
		//tableUsers = new JTable(tempTable);
		tableUsers = new JTable(data, tempStr);
		//tableUsers.getTableHeader().setDefaultRenderer(renderer);
		
		belong();
		
		//tableUsers.setTableHeader(tableHeader);// (tempObjID));
		
		//tableUsers.setBounds(241, 49, 170, 110);
		//scrollPane.add(tableUsers);
		
		scrollPane = new JScrollPane(tableUsers);
		scrollPane.setBounds(241, 49, 170, 110);
		add(scrollPane);
		
		btnDelUser = new JButton("-");
		btnDelUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*if (tableUsers.getSelectedRow() >= 0) {
					tempRef.allGroups.get(tempMainIndex).getUsers().remove(tempRef.allUsers.get(tableUsers.getSelectedRow()));
				}*/
				belong();
			}
		});
		btnDelUser.setBounds(420, 100, 41, 43);
		add(btnDelUser);
		
		Groups temp;
		if (mainIndex >= 0) {
			temp = ref.allGroups.get(mainIndex);
			txtName.setText(temp.getName());
			txtDescription.setText(temp.getDescription());
			txtSalary.setText("" + temp.getSalary());
		}
		belong();
		
		//txtDescription.setText("" + tempRef.allGroups.get(tempMainIndex).getUsers().size());
		//txtDescription.setText(tempRef.allGroups.get(tempMainIndex).getUsers().toArray()[0]);
		//txtDescription.setText("" + tempRef.allUsers.get(3).toString());
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
	void update(EComponent ecom) {
		// TODO Auto-generated method stub
		
	}
	
	public void belong(){
		for (int i = 0; i < tempRef.allUsers.size(); ++i) {
			for (int j = 0; j < tempRef.allGroups.get(tempMainIndex).getUsers().size(); ++j) {
				//if (tempRef.allUsers.get(i).getIdusers() == tempRef.allGroups.get(tempMainIndex).getUsers())
				/*if ( tempRef.allGroups.get(tempMainIndex).getUsers().contains(tempRef.allUsers.get(i)) ) {
					tableUsers.setRowSelectionInterval(0, 0); 
					tableUsers.setBackground(Color.GREEN);
				}*/
				if (tempRef.allUsers.get(i).toString() == tempRef.allGroups.get(tempMainIndex).getUsers().toArray()[j].toString()){
					tableUsers.setRowSelectionInterval(0, 0); 
					tableUsers.setBackground(Color.GREEN);
				}
			}
		}
		txtDescription.setText("" + tempRef.allGroups.get(tempMainIndex).getUsers().size());
	}
}
