package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import backend.core.model.Products;

import javax.swing.JLabel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class DEditProduct extends ModelDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tName;
	private JTextField tPrice;
	private JTextField tCount;
	private JComboBox cSupplier;
	private JComboBox cCategory;

	/**
	 * Create the dialog.
	 */
	public DEditProduct(JPanel panel, Products product) {
		super(panel);
		setBounds(100, 100, 430, 266);
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
		
		tName = new JTextField(product.getName());
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
			tPrice = new JTextField(product.getCount()+"");
			contentPanel.add(tPrice, "4, 10, left, default");
			tPrice.setColumns(10);
		}
		{
			JLabel lblCena = new JLabel("Cena:");
			contentPanel.add(lblCena, "2, 12, right, default");
		}
		{
			tCount = new JTextField(product.getPrice()+"");
			contentPanel.add(tCount, "4, 12, left, default");
			tCount.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
