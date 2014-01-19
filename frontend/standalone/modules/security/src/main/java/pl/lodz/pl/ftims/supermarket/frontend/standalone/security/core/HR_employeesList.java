package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import backend.core.model.Users;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class HR_employeesList extends HR_templateList{
	//final	JList list;
	private JTable table;
			Object[][] data;
			int[] dataIterator;
	final	String[] dataHeader = {"id","name","surname"};
	public	HR_main tempRef;
	final	JTextPane textPane;
			JScrollPane scrollPane;
	
	public HR_employeesList(final HR_main ref) {
		setLayout(null);
		tempRef = ref;
/*		
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < ref.allUsers.size(); ++i) {
			listModel.addElement(	"" + ref.allUsers.get(i).getIdusers() 
								+ 	" | " + ref.allUsers.get(i).getSurname() 
								+ 	" | " + ref.allUsers.get(i).getName()
								);
		}
		list = new JList(listModel);
		list.setBounds(50, 50, 345, 169);
		list.setSelectedIndex(0);
		
		//add(list);
*/		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(252, 242, 89, 23);
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if (  table.getSelectedRowCount() > 0 ) { // table.getSelectedRow() >= 0 ) {
					ref.helpIndex = dataIterator[table.getSelectedRow()];
				} else {
					if ( dataIterator[0] < 0) {
						return;
					} else {
						ref.helpIndex = dataIterator[0];
					}
				}
				
				ref.switchPanel(EComponent.employee);
			}
		});
		add(btnEdit);
		
		JButton btnCancel = new JButton("Cancel");
		//btnCancel.addMouseListener(
		//getParent().getComponentAt(404, 2).action(new Event(ActionEvent e), new Object());
		//getParent().action(evt, what);// update(eComponent.idle);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ref.cancelChanges(EComponent.listEmployee);
				ref.switchPanel(EComponent.idle);//update(eComponent.idle);
			}
		});
		btnCancel.setBounds(351, 242, 89, 23);
		add(btnCancel);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 242, 133, 23);
		add(textPane);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				filter(textPane.getText());
			}
		});
		btnFilter.setBounds(153, 242, 89, 23);
		add(btnFilter);
		
		
		data = new Object[ref.allUsers.size()][3];
		
		//dataHeader = {"id","name","surname"};
		
		/*for (int i = 0; i < ref.allUsers.size(); ++i) {
			data[i][0] = "" + ref.allUsers.get(i).getIdusers();
			data[i][1] = "" + ref.allUsers.get(i).getName();
			data[i][2] = "" + ref.allUsers.get(i).getSurname();
		}*/
		
		table = new JTable(data, dataHeader);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(85, 20, 256, 200);
		add(scrollPane);
		
		filter("");
		
		JButton btnApply = new JButton("Apply");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ref.applyChanges(EComponent.listEmployee);
				ref.switchPanel(EComponent.idle);
			}
		});
		btnApply.setBounds(351, 173, 89, 50);
		add(btnApply);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Users newUser = new Users("", "", "asd123", "", Calendar.getInstance().getTime(), null);
				ref.allUsers.add(newUser);
				ref.switchPanel(EComponent.listEmployee);
			}
		});
		btnAdd.setBounds(350, 20, 89, 37);
		add(btnAdd);
		
		JButton btnDel = new JButton("Del");
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (table.getSelectedRowCount() > 0) {
					ref.allUsers.remove(dataIterator[table.getSelectedRow()]);
				}
				ref.switchPanel(EComponent.listEmployee);
			}
		});
		btnDel.setBounds(350, 70, 89, 37);
		add(btnDel);
		
	}

	//CEmployee list[];
	
	protected void filter(String text) {
		data = new Object[tempRef.allUsers.size()][3];
		dataIterator = new int[tempRef.allUsers.size()];
		
		dataIterator[0] = -1;
		
		int iter = 0;
		for (int i = 0; i < tempRef.allUsers.size(); ++i) {
			String temp = 
					(  "" + tempRef.allUsers.get(i).getIdusers() 
					+ " " + tempRef.allUsers.get(i).getSurname() 
					+ " " + tempRef.allUsers.get(i).getName()
					);
			if (temp.contains(text)) {
				data[iter][0] = "" + tempRef.allUsers.get(i).getIdusers();
				data[iter][1] = "" + tempRef.allUsers.get(i).getName();
				data[iter][2] = "" + tempRef.allUsers.get(i).getSurname();
				dataIterator[iter] = i;
				++iter;
			}
		}
		//this.remove(scrollPane);
		/*this.remove(this.findComponentAt(100, 100));
		this.revalidate();
		this.repaint();
		table = new JTable(data, dataHeader);
		scrollPane = new JScrollPane(table);
		//this.add(scrollPane);
*/		
		this.remove(scrollPane);
		table = new JTable(data, dataHeader);
		scrollPane = new JScrollPane(table);
		this.add(scrollPane);
		scrollPane.setBounds(85, 20, 256, 200);
		
		this.revalidate();
		this.repaint();
	}

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
