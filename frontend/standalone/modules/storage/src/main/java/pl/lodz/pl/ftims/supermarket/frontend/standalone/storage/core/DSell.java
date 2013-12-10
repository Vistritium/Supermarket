package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.api.StorageManagement;
import backend.core.model.Products;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DSell extends ModelDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lSCount;
	private JTextField tCouny;
	Products product;

	/**
	 * Create the dialog.
	 */
	public DSell(PStorageManagment panel, Products product) {
		super(panel);
		this.product=product;
		setTitle("Sprzedaj produkt.");
		setBounds(100, 100, 450, 245);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		{
			JLabel lblWybranyProdukt = new JLabel("Wybrany produkt:");
			contentPanel.add(lblWybranyProdukt, "2, 2");
		}
		{
			JLabel lblNazwa = new JLabel("Nazwa:");
			contentPanel.add(lblNazwa, "2, 4, right, default");
		}
		{
			JLabel lblName = new JLabel(product.getName());
			contentPanel.add(lblName, "4, 4");
		}
		{
			JLabel lblProducent = new JLabel("Dostawca:");
			contentPanel.add(lblProducent, "2, 6, right, default");
		}
		{
			JLabel lblSupplier = new JLabel("Warka");
			contentPanel.add(lblSupplier, "4, 6");
		}
		{
			JLabel lblKategoria = new JLabel("Kategoria:");
			contentPanel.add(lblKategoria, "2, 8, right, default");
		}
		{
			JLabel lblCategory = new JLabel("Alkohole");
			contentPanel.add(lblCategory, "4, 8");
		}
		{
			JLabel lblDostpnaIlo = new JLabel("Dostępna ilość:");
			contentPanel.add(lblDostpnaIlo, "2, 10, right, default");
		}
		{
			lSCount = new JLabel(product.getCount()+"");
			contentPanel.add(lSCount, "4, 10");
		}
		{
			JLabel lblCenaZaSztuk = new JLabel("Cena za sztukę:");
			contentPanel.add(lblCenaZaSztuk, "2, 12, right, default");
		}
		{
			JLabel lblPrice = new JLabel(product.getPrice()+"");
			contentPanel.add(lblPrice, "4, 12");
		}
		{
			JLabel lblSprzedajWIloci = new JLabel("Sprzedaj w ilości:");
			contentPanel.add(lblSprzedajWIloci, "2, 14, right, default");
		}
		{
			tCouny = new JTextField();
			contentPanel.add(tCouny, "4, 14, left, default");
			tCouny.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sprzedaj");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Anuluj");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
