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

public class PStorageManagment extends JPanel {
	private JPanel contentPanel;
	private JTable tProducts;
	private JButton bAddProduct;
	private JButton bEditSelectedProduct;
	private JButton bDeleteSelectedProduct;
	private JButton bManageCategories;
	private JButton bManageSuppliers;
	
	public static final String ID_PRODUCT="idProduct";
	public static final String ID_CATEGORY="idCategory";
	public static final String ID_MANUFACTURER="idManufacturer";
	
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
	private JLabel lblNewLabel_1;
	private JLabel lblIlo;
	private JTextField tSearchPrice;
	private JTextField tSearchCount;
	private JLabel lblWybierzKategori;
	private JComboBox cCategories;
	private JButton btnSzukaj;
	
	private Validator validator;
	
	//User right example
	private int secure=1;
	
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
		tableModel= new ModelTable();
		tProducts.setModel(tableModel);
		
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
		
		lblNewLabel_1 = new JLabel("Cena:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 4;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tSearchPrice = new JTextField();
		GridBagConstraints gbc_tSearchPrice = new GridBagConstraints();
		gbc_tSearchPrice.insets = new Insets(0, 0, 5, 5);
		gbc_tSearchPrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_tSearchPrice.gridx = 1;
		gbc_tSearchPrice.gridy = 4;
		contentPanel.add(tSearchPrice, gbc_tSearchPrice);
		tSearchPrice.setColumns(10);
		
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
		
		lblIlo = new JLabel("Ilość:");
		GridBagConstraints gbc_lblIlo = new GridBagConstraints();
		gbc_lblIlo.anchor = GridBagConstraints.EAST;
		gbc_lblIlo.insets = new Insets(0, 0, 0, 5);
		gbc_lblIlo.gridx = 0;
		gbc_lblIlo.gridy = 5;
		contentPanel.add(lblIlo, gbc_lblIlo);
		
		tSearchCount = new JTextField();
		GridBagConstraints gbc_tSearchCount = new GridBagConstraints();
		gbc_tSearchCount.insets = new Insets(0, 0, 0, 5);
		gbc_tSearchCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_tSearchCount.gridx = 1;
		gbc_tSearchCount.gridy = 5;
		contentPanel.add(tSearchCount, gbc_tSearchCount);
		tSearchCount.setColumns(10);
		
		btnSzukaj = new JButton("Szukaj");
		GridBagConstraints gbc_btnSzukaj = new GridBagConstraints();
		gbc_btnSzukaj.anchor = GridBagConstraints.EAST;
		gbc_btnSzukaj.gridx = 4;
		gbc_btnSzukaj.gridy = 5;
		contentPanel.add(btnSzukaj, gbc_btnSzukaj);
		
		//First update of products, suppliers and categories		
		try{
			updateProductsList();
		}
		catch(Exception e){
			e.printStackTrace();
		}
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

		
		if(secure!=1){
			bDeleteSelectedProduct.setVisible(false);
			bEditSelectedProduct.setVisible(false);
			bManageCategories.setVisible(false);
			bManageSuppliers.setVisible(false);
		}
	}
	
	private void addProduct(){
		if(secure==1) new DAddProduct(this);
		else if(tProducts.getSelectedRow()!=-1) new DSell(this, products.get(tProducts.getSelectedRow()));
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
			
			if(answer==JOptionPane.OK_OPTION) validator.removeProduct(products.get(tProducts.getSelectedRow()).getIdProducts());
		}
	}
	
	//Update methods
	public void updateProductsList(){
		products=new ArrayList<Products>();
		products.add(apiSM.getProduct(1, "odzież"));
		
		//Delete data from tableModel
		for(int i=0; i<tableModel.getRowCount()-1; i++){
			tableModel.removeRow(i);
		}	
		
		//Example
		tableModel.addColumn("Nazwa produktu");
		tableModel.addColumn("Dostawca");
		tableModel.addColumn("Kategoria");
		tableModel.addColumn("Ilość");
		tableModel.addColumn("Cena");
		
		
		for(int i=0; i<products.size(); i++){
			
			Object[] exx={
				products.get(i).getName(),
				products.get(i).getManufacturer(),
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
		cCategories.removeAllItems();
		categories=new ArrayList<>();
		categories.add(apiSM.getCategory(1));
		categories.add(apiSM.getCategory(2));
		categories.add(apiSM.getCategory(3));
		categories.add(apiSM.getCategory(4));
		categories.add(apiSM.getCategory(5));
		categories.add(apiSM.getCategory(6));
		categories.add(apiSM.getCategory(7));
		categories.add(apiSM.getCategory(8));
		
		cCategories.addItem("Wybierz kategorię...");
		for(int i=0; i<categories.size(); i++){
			String name = categories.get(i).getName();
			cCategories.addItem(name);
		}		
	}
}
