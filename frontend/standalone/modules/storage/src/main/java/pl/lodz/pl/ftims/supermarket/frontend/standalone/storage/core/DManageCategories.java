package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.api.StorageManagement;
import backend.core.model.Category;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class DManageCategories extends ModelDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tCategory;
	private JButton bRemoveCategory;
	private JComboBox cCategories;
	private JButton bEditCategory;
	private Validator validator;
	private List<Category> categories;
	
	/**
	 * Create the dialog.
	 */
	public DManageCategories(PStorageManagment panel) {
		super(panel);
		
		validator= new Validator();
		
		setTitle("Zarządzaj kategoriami");
		setBounds(100, 100, 373, 299);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		{
			JPanel panel_1 = new JPanel();
			contentPanel.add(panel_1, "2, 2, fill, fill");
			panel_1.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(95dlu;default):grow"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			{
				JLabel lblNowaKategoria = new JLabel("Nowa kategoria");
				panel_1.add(lblNowaKategoria, "2, 2");
			}
			{
				JLabel lblNazwa = new JLabel("Nazwa:");
				panel_1.add(lblNazwa, "2, 4, right, default");
			}
			{
				tCategory = new JTextField();
				panel_1.add(tCategory, "4, 4, fill, default");
				tCategory.setColumns(10);
			}
			{
				JButton btnDodaj = new JButton("Dodaj");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addCategory();
					}
				});
				panel_1.add(btnDodaj, "4, 6, right, default");
			}
			
		}
		{
			JPanel panel_1 = new JPanel();
			contentPanel.add(panel_1, "2, 4, fill, fill");
			panel_1.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(39dlu;default):grow"),
					FormFactory.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(29dlu;default):grow"),},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("default:grow"),
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("default:grow"),
					FormFactory.RELATED_GAP_ROWSPEC,
					RowSpec.decode("default:grow"),}));
			{
				JLabel lblZarzdzajKategoriami = new JLabel("Zarządzaj kategoriami");
				panel_1.add(lblZarzdzajKategoriami, "2, 2");
			}
			{
				cCategories = new JComboBox();
				panel_1.add(cCategories, "2, 4, 5, 1, fill, default");
			}
			{
				bRemoveCategory = new JButton("Usuń");
				bRemoveCategory.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						removeCategory();
					}
				});
				panel_1.add(bRemoveCategory, "4, 6, right, default");
			}
			{
				bEditCategory = new JButton("Edytuj");
				bEditCategory.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						editCategory();
					}
				});
				panel_1.add(bEditCategory, "6, 6, right, default");
			}
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Zamknij");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		updateFrame();
	}

	private void addCategory(){
		if(validator.addCategory(tCategory.getText().toString())){
			panel.updateCategoryList();
			JOptionPane.showMessageDialog(this, "Dodano kategorię.");
			updateFrame();
		}
		else JOptionPane.showMessageDialog(this, "Błąd dodawania kategorii");
	}
	
	private void editCategory(){
		if(cCategories.getSelectedIndex()-1>=0){
			String in=JOptionPane.showInputDialog("Wprowadź nową nazwę.");
			if(in!=null){
					if(validator.editCategory(categories.get(cCategories.getSelectedIndex()-1).getIdCategory(), in)){
						panel.updateCategoryList();
						JOptionPane.showMessageDialog(this, "Edytowano kategorię.");
						updateFrame();
					}
					else{
						JOptionPane.showMessageDialog(this, "Błąd edytowania kategorii");
					}

			}
		}

	}
	
	private void removeCategory(){
		try{
			if(validator.removeCategory(categories.get(cCategories.getSelectedIndex()-1).getIdCategory())){
				panel.updateCategoryList();
				panel.updateProductsList();
				JOptionPane.showMessageDialog(this, "Usunięto kategorię.");
				updateFrame();
			}
			else{
				JOptionPane.showMessageDialog(this, "Błąd usuwania kategorii");
			}
		}
		catch(IndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(this, "nie wybrano kategorii");
		}

	}
	
	private void updateFrame(){
		cCategories.removeAllItems();
		categories=new StorageManagement().getCategory();
		
		cCategories.addItem("Wybierz kategorię...");
		for(int i=0; i<categories.size(); i++){
			cCategories.addItem(categories.get(i).getName());
		}		
	}
	
}
