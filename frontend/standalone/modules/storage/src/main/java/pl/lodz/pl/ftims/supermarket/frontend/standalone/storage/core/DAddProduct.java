package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import backend.api.StorageManagement;
import backend.core.model.Category;
import backend.core.model.Manufacturers;
import backend.core.model.Products;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class DAddProduct extends ModelDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tName;
	private JTextField tCount;
	private JTextField tPrice;
	private JComboBox cSupplier;
	private JComboBox cCategory;
	private Validator validator;
	private List<Category> categories;
	private List<Manufacturers> suppliers;

	/**
	 * Create the dialog.
	 */
	public DAddProduct(PStorageManagment panel) {
		super(panel);
		
		validator= new Validator();
		
		setTitle("Dodaj nowy produkt");
		
		setBounds(100, 100, 313, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(75dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		{
			JLabel label = new JLabel("Wprowadź dane nowego produktu.");
			contentPanel.add(label, "2, 2, 5, 1");
		}
		
		JLabel lblNazwa = new JLabel("Nazwa:");
		contentPanel.add(lblNazwa, "2, 4, right, default");
		
		tName = new JTextField();
		contentPanel.add(tName, "4, 4, fill, default");
		tName.setColumns(10);
		{
			JLabel lblDostawca = new JLabel("Dostawca:");
			contentPanel.add(lblDostawca, "2, 6, right, default");
		}
		{
			cSupplier = new JComboBox();
			contentPanel.add(cSupplier, "4, 6, fill, default");
		}
		{
			JLabel lblKategoria = new JLabel("Kategoria:");
			contentPanel.add(lblKategoria, "2, 8, right, default");
		}
		{
			cCategory = new JComboBox();
			contentPanel.add(cCategory, "4, 8, fill, default");
		}
		{
			JLabel lblIlo = new JLabel("Ilość:");
			contentPanel.add(lblIlo, "2, 10, right, default");
		}
		{
			tCount = new JTextField();
			contentPanel.add(tCount, "4, 10, left, default");
			tCount.setColumns(10);
		}
		{
			JLabel lblCena = new JLabel("Cena:");
			contentPanel.add(lblCena, "2, 12, right, default");
		}
		{
			tPrice = new JTextField();
			contentPanel.add(tPrice, "4, 12, left, default");
			tPrice.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Dodaj");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addProduct();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Anuluj");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		cSupplier.removeAllItems();
		
		suppliers = new StorageManagement().getManufacturer();
		
		cSupplier.addItem("Wybierz dostawcę...");
		for(int i=0; i<suppliers.size(); i++){
			cSupplier.addItem(suppliers.get(i).getName());
		}	
		
		cCategory.removeAllItems();
		categories = new StorageManagement().getCategory();
		
		cCategory.addItem("Wybierz kategorię...");
		for(int i=0; i<categories.size(); i++){
			cCategory.addItem(categories.get(i).getName());
		}	
		
	}
	
	private void addProduct(){
		try{
			if(validator.addProduct(tName.getText().toString(), 
					categories.get(cCategory.getSelectedIndex()-1).getIdCategory(), 
					suppliers.get(cSupplier.getSelectedIndex()-1).getIdManufacturer(), 
					tPrice.getText().toString(),
					tCount.getText().toString())){
				JOptionPane.showMessageDialog(this, "Dodano produkt");
				panel.updateProductsList();
			}
			else JOptionPane.showMessageDialog(this, "Błąd dodawania produktu");
		}
		catch(ArrayIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(this, "Nie wybrano dostawcy i/lub produktu.");
		}
	}
}
