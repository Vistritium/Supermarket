package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import backend.api.StorageManagement;
import backend.core.model.Category;
import backend.core.model.Manufacturers;
import backend.core.model.Products;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Stale;

public class PStorageManagment extends JPanel {
	private JPanel contentPanel;
	private JTable tProducts;
	private JButton bAddProduct;
	private JButton bEditSelectedProduct;
	private JButton bDeleteSelectedProduct;
	private JButton bManageCategories;
	private JButton bManageSuppliers;
	
	private ModelTable tableModel;
	private StorageManagement apiSM;
	private List<Products> products;
	private List<Category> categories;
	private List<Manufacturers> suppliers;
	private JLabel lblSz;
	private JLabel lblNazwa;
	private JTextField tSearchName;
	private JLabel lblNewLabel;
	private JComboBox cSuppliers;
	private JLabel lblWybierzKategori;
	private JComboBox cCategories;
	private JButton btnSzukaj;
	
	private Validator validator;
	
	//User right example
	private int secure=0; //Mozna zmienic na zero, wtedy pojawi sie panel sprzedawcy.
	
	/**
	 * Create the panel.
	 */
	public PStorageManagment() {
		setLayout(new BorderLayout(0, 0));
		
		validator= new Validator();
		
		contentPanel = new JPanel();
		add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPanel.add(scrollPane, gbc_scrollPane);
		
		tProducts = new JTable();
		scrollPane.setViewportView(tProducts);
		
		//Verify user rights
		String bName;
		if(secure==1){
			bName="Dodaj produkt";
		}
		else{
			bName="Sprzedaj produkt";
		}
		
		bAddProduct = new JButton(bName);
		bAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addProduct();
			}
		});
		GridBagConstraints gbc_bAddProduct = new GridBagConstraints();
		gbc_bAddProduct.insets = new Insets(0, 0, 5, 5);
		gbc_bAddProduct.gridx = 0;
		gbc_bAddProduct.gridy = 1;
		contentPanel.add(bAddProduct, gbc_bAddProduct);
		
		bEditSelectedProduct = new JButton("Edytuj produkt");
		bEditSelectedProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editSelectedProduct();
			}
		});
		GridBagConstraints gbc_bEditSelectedProduct = new GridBagConstraints();
		gbc_bEditSelectedProduct.insets = new Insets(0, 0, 5, 5);
		gbc_bEditSelectedProduct.gridx = 1;
		gbc_bEditSelectedProduct.gridy = 1;
		contentPanel.add(bEditSelectedProduct, gbc_bEditSelectedProduct);
		
		bDeleteSelectedProduct = new JButton("Usuń produkt");
		bDeleteSelectedProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeSelectedProduct();
			}
		});
		GridBagConstraints gbc_bDeleteSelectedProduct = new GridBagConstraints();
		gbc_bDeleteSelectedProduct.insets = new Insets(0, 0, 5, 5);
		gbc_bDeleteSelectedProduct.gridx = 2;
		gbc_bDeleteSelectedProduct.gridy = 1;
		contentPanel.add(bDeleteSelectedProduct, gbc_bDeleteSelectedProduct);
		
		bManageCategories = new JButton("Zarządzaj kategoriami");
		bManageCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageCategories();
			}
		});
		GridBagConstraints gbc_bManageCategories = new GridBagConstraints();
		gbc_bManageCategories.insets = new Insets(0, 0, 5, 5);
		gbc_bManageCategories.gridx = 3;
		gbc_bManageCategories.gridy = 1;
		contentPanel.add(bManageCategories, gbc_bManageCategories);
		
		bManageSuppliers = new JButton("Zarządzaj dostawcami");
		bManageSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageSuppliers();
			}
		});
		GridBagConstraints gbc_bManageSuppliers = new GridBagConstraints();
		gbc_bManageSuppliers.insets = new Insets(0, 0, 5, 0);
		gbc_bManageSuppliers.gridx = 4;
		gbc_bManageSuppliers.gridy = 1;
		contentPanel.add(bManageSuppliers, gbc_bManageSuppliers);
		
		
		//Fields
		apiSM= new StorageManagement();
		
		lblSz = new JLabel("Wyszukiwanie:");
		GridBagConstraints gbc_lblSz = new GridBagConstraints();
		gbc_lblSz.insets = new Insets(0, 0, 5, 5);
		gbc_lblSz.gridx = 0;
		gbc_lblSz.gridy = 2;
		contentPanel.add(lblSz, gbc_lblSz);
		
		lblNazwa = new JLabel("Nazwa:");
		GridBagConstraints gbc_lblNazwa = new GridBagConstraints();
		gbc_lblNazwa.anchor = GridBagConstraints.EAST;
		gbc_lblNazwa.insets = new Insets(0, 0, 5, 5);
		gbc_lblNazwa.gridx = 0;
		gbc_lblNazwa.gridy = 3;
		contentPanel.add(lblNazwa, gbc_lblNazwa);
		
		tSearchName = new JTextField();
		GridBagConstraints gbc_tSearchName = new GridBagConstraints();
		gbc_tSearchName.gridwidth = 2;
		gbc_tSearchName.insets = new Insets(0, 0, 5, 5);
		gbc_tSearchName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tSearchName.gridx = 1;
		gbc_tSearchName.gridy = 3;
		contentPanel.add(tSearchName, gbc_tSearchName);
		tSearchName.setColumns(10);
		
		lblNewLabel = new JLabel("Wybierz dostawcę:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		cSuppliers = new JComboBox();
		GridBagConstraints gbc_cSuppliers = new GridBagConstraints();
		gbc_cSuppliers.insets = new Insets(0, 0, 5, 0);
		gbc_cSuppliers.fill = GridBagConstraints.HORIZONTAL;
		gbc_cSuppliers.gridx = 4;
		gbc_cSuppliers.gridy = 3;
		contentPanel.add(cSuppliers, gbc_cSuppliers);
		
		lblWybierzKategori = new JLabel("Wybierz kategorię:");
		GridBagConstraints gbc_lblWybierzKategori = new GridBagConstraints();
		gbc_lblWybierzKategori.anchor = GridBagConstraints.EAST;
		gbc_lblWybierzKategori.insets = new Insets(0, 0, 5, 5);
		gbc_lblWybierzKategori.gridx = 3;
		gbc_lblWybierzKategori.gridy = 4;
		contentPanel.add(lblWybierzKategori, gbc_lblWybierzKategori);
		
		cCategories = new JComboBox();
		GridBagConstraints gbc_cCategories = new GridBagConstraints();
		gbc_cCategories.insets = new Insets(0, 0, 5, 0);
		gbc_cCategories.fill = GridBagConstraints.HORIZONTAL;
		gbc_cCategories.gridx = 4;
		gbc_cCategories.gridy = 4;
		contentPanel.add(cCategories, gbc_cCategories);
		
		btnSzukaj = new JButton("Szukaj");
		btnSzukaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchProducts();
			}
		});
		GridBagConstraints gbc_btnSzukaj = new GridBagConstraints();
		gbc_btnSzukaj.anchor = GridBagConstraints.EAST;
		gbc_btnSzukaj.gridx = 4;
		gbc_btnSzukaj.gridy = 5;
		contentPanel.add(btnSzukaj, gbc_btnSzukaj);
		
		//First update of products, suppliers and categories		
		try{
			updateCategoryList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			updateSuppliersList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		try{
			updateProductsList();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

		
		if(secure!=1){
			bDeleteSelectedProduct.setVisible(false);
			bEditSelectedProduct.setVisible(false);
			bManageCategories.setVisible(false);
			bManageSuppliers.setVisible(false);
		}
	}
	
	private void addProduct(){
		if(secure==1) new DAddProduct(this);
		else if(tProducts.getSelectedRow()!=-1){
			Manufacturers supplier=null;
			for(int i=0; i<suppliers.size(); i++){
				if(suppliers.get(i).getIdManufacturer()==products.get(tProducts.getSelectedRow()).getManufacturer()){
					supplier=suppliers.get(i);
					break;
				}
			}
			new DSell(this, products.get(tProducts.getSelectedRow()), supplier);
		}
	}
	
	private void editSelectedProduct(){ 
		if(tProducts.getSelectedRow()!=-1 && tProducts.getRowCount()>0) new DEditProduct(this, products.get(tProducts.getSelectedRow()));
	}
	
	private void manageCategories(){
		new DManageCategories(this);
	}
	
	private void manageSuppliers(){
		new DManageSuppliers(this);
	}
	
	private void removeSelectedProduct(){
		if(tProducts.getSelectedRow()!=-1 && tProducts.getRowCount()>0){
			int answer=JOptionPane.showOptionDialog(
					this, 
					"Czy na pewno chcesz usunąć produkt o nazwie "+products.get(tProducts.getSelectedRow()).getName()+"?", 
					"Usuwanie produktu.", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE,
					null,
					null,
					null
					);
			
			if(answer==JOptionPane.OK_OPTION){
				if(validator.removeProduct(products.get(tProducts.getSelectedRow()).getIdProducts())) this.updateProductsList();				
			}
		}
	}
	
	//Update methods
	public void updateProductsList(){
		
		tableModel= new ModelTable();
		tProducts.setModel(tableModel);
		
		products=apiSM.getProducts();
		
		//Example
		tableModel.addColumn("Nazwa produktu");
		tableModel.addColumn("Dostawca");
		tableModel.addColumn("Kategoria");
		tableModel.addColumn("Ilość");
		tableModel.addColumn("Cena");
		
		
		for(int i=0; i<products.size(); i++){
					
			//Finding supplier
			String supplierName="Brak danych";
			for(int j=0; j<suppliers.size(); j++){
				if(suppliers.get(j).getIdManufacturer()==products.get(i).getManufacturer()){
					supplierName=suppliers.get(j).getName().toString();
					break;
				}
			}
			
			Object[] exx={
				products.get(i).getName(),
				supplierName,
				products.get(i).getCategory().getName(),
				products.get(i).getCount(),
				products.get(i).getPrice()
			};
			tableModel.addRow(exx);
		}
		
		tProducts.changeSelection(0, 0, false, false);

	}
	
public void updateProductsList(List<Products> products){
		
		tableModel= new ModelTable();
		tProducts.setModel(tableModel);
		
		//Example
		tableModel.addColumn("Nazwa produktu");
		tableModel.addColumn("Dostawca");
		tableModel.addColumn("Kategoria");
		tableModel.addColumn("Ilość");
		tableModel.addColumn("Cena");
		
		
		for(int i=0; i<products.size(); i++){
					
			//Finding supplier
			String supplierName="Brak danych";
			for(int j=0; j<suppliers.size(); j++){
				if(suppliers.get(j).getIdManufacturer()==products.get(i).getManufacturer()){
					supplierName=suppliers.get(j).getName().toString();
					break;
				}
			}
			
			Object[] exx={
				products.get(i).getName(),
				supplierName,
				products.get(i).getCategory().getName(),
				products.get(i).getCount(),
				products.get(i).getPrice()
			};
			tableModel.addRow(exx);
		}
		
		tProducts.changeSelection(0, 0, false, false);

	}
	
	public void updateSuppliersList(){
		cSuppliers.removeAllItems();
		suppliers=apiSM.getManufacturer();
		
		cSuppliers.addItem("Wybierz dostawcę...");
		for(int i=0; i<suppliers.size(); i++){
			cSuppliers.addItem(suppliers.get(i).getName());
		}		
	}
	
	public void updateCategoryList(){
		categories=apiSM.getCategory();
		
		cCategories.addItem("Wybierz kategorię...");
		for(int i=0; i<categories.size(); i++){
			String name = categories.get(i).getName(); 
			cCategories.addItem(name);
		
		}		
	}
	
	private void searchProducts(){
		String name=tSearchName.getText().toString();
		int idCat=-1;
		int idSup=-1;
		if(cCategories.getSelectedIndex()-1>=0) idCat=categories.get(cCategories.getSelectedIndex()-1).getIdCategory();
		if(cSuppliers.getSelectedIndex()-1>=0) idSup=suppliers.get(cSuppliers.getSelectedIndex()-1).getIdManufacturer();
		updateProductsList(validator.searchProducts(name, idCat, idSup));
	}
}
