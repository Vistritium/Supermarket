package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Stale;
import javax.swing.JScrollPane;

public class HR_groupList extends HR_templateList {
	private JTable 		table;
			Object[][] 	data;
	final	String[] dataHeader = {"id", "name", "description", "salary"};
	
	
	private static final long serialVersionUID = -2161875489604406555L;
	final JList<String> list;
	
	public HR_groupList(final HR_main ref) {
		setLayout(null);
		
		Integer accessLevel = Stale.getInstance().getAccessLevel();
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = 0; i < ref.allGroups.size(); ++i) {
			listModel.addElement("" + ref.allGroups.get(i).getIdgroups() 
								+ 	" | " + ref.allGroups.get(i).getName() 
								+ 	" | " + ref.allGroups.get(i).getSalary());
		
		}
		
		list = new JList<>(listModel);
		list.setBounds(50, 50, 257, 169);
		list.setSelectedIndex(0);
		//add(list);
		
		JButton btnEdit = new JButton("Edit");
		ref.helpIndex = 0;
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//ref.helpIndex = list.getSelectedIndex();
				if (  table.getSelectedRowCount() > 0 ) { // table.getSelectedRow() >= 0 ) {
					ref.helpIndex = table.getSelectedRow();
				} else {
					if ( table.getRowCount() < 0) {
						return;
					} else {
						ref.helpIndex = 0;
					}
				}
				ref.switchPanel(EComponent.group);
			}
		});
		btnEdit.setBounds(218, 243, 89, 23);
		add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ref.switchPanel(EComponent.idle);//update(eComponent.idle);
			}
		});
		btnCancel.setBounds(317, 243, 89, 23);
		add(btnCancel);
		
		JButton btnApply = new JButton("Apply");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ref.applyChanges(EComponent.listGroup);
				ref.switchPanel(EComponent.idle);
			}
		});
		btnApply.setBounds(317, 175, 89, 44);
		add(btnApply);
		
		
		data = new Object[ref.allUsers.size()][4];
		
		for (int i = 0; i < ref.allGroups.size(); ++i) {
			data[i][0] = "" + ref.allGroups.get(i).getIdgroups();
			data[i][1] = "" + ref.allGroups.get(i).getName();
			data[i][2] = "" + ref.allGroups.get(i).getDescription();
			data[i][3] = "" + ref.allGroups.get(i).getSalary();
		}
		
		table = new JTable(data, dataHeader);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(50, 50, 257, 169);
		add(scrollPane);
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
	void update(EComponent ecom) {
		// TODO Auto-generated method stub
		
	}
}
