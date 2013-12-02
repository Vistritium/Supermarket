package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PStorageManagment extends JPanel {
	private JPanel contentPanel;
	private JTable tProducts;
	private JButton bAddProduct;
	private JButton bEditSelectedProduct;
	private JButton bDeleteSelectedProduct;
	private JButton bManageCategories;
	private JButton bManageSuppliers;
	
	private DefaultTableModel tableModel;
	
	
	/**
	 * Create the panel.
	 */
	public PStorageManagment() {
		setLayout(new BorderLayout(0, 0));
		
		contentPanel = new JPanel();
		add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		bAddProduct = new JButton("Dodaj produkt");
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
		GridBagConstraints gbc_bEditSelectedProduct = new GridBagConstraints();
		gbc_bEditSelectedProduct.insets = new Insets(0, 0, 5, 5);
		gbc_bEditSelectedProduct.gridx = 1;
		gbc_bEditSelectedProduct.gridy = 1;
		contentPanel.add(bEditSelectedProduct, gbc_bEditSelectedProduct);
		
		bDeleteSelectedProduct = new JButton("Usuń produkt");
		GridBagConstraints gbc_bDeleteSelectedProduct = new GridBagConstraints();
		gbc_bDeleteSelectedProduct.insets = new Insets(0, 0, 5, 5);
		gbc_bDeleteSelectedProduct.gridx = 2;
		gbc_bDeleteSelectedProduct.gridy = 1;
		contentPanel.add(bDeleteSelectedProduct, gbc_bDeleteSelectedProduct);
		
		bManageCategories = new JButton("Zarządzaj kategoriami");
		GridBagConstraints gbc_bManageCategories = new GridBagConstraints();
		gbc_bManageCategories.insets = new Insets(0, 0, 5, 5);
		gbc_bManageCategories.gridx = 3;
		gbc_bManageCategories.gridy = 1;
		contentPanel.add(bManageCategories, gbc_bManageCategories);
		
		bManageSuppliers = new JButton("Zarządzaj dostawcami");
		GridBagConstraints gbc_bManageSuppliers = new GridBagConstraints();
		gbc_bManageSuppliers.insets = new Insets(0, 0, 5, 0);
		gbc_bManageSuppliers.gridx = 4;
		gbc_bManageSuppliers.gridy = 1;
		contentPanel.add(bManageSuppliers, gbc_bManageSuppliers);
	}
	
	private void addProduct(){
		new DAddProduct(contentPanel);		
	}
}
