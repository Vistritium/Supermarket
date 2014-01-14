package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Stale;

public class HR_groupList extends HR_templateList {
	/**
	 * 
	 */
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
		list.setBounds(50, 50, 345, 169);
		list.setSelectedIndex(0);
		add(list);
		
		JButton btnEdit = new JButton("Edit");
		ref.helpIndex = 0;
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ref.helpIndex = list.getSelectedIndex();
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
