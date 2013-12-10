package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DManageSuppliers extends ModelDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tSupplier;
	private JButton bRemoveSupplier;
	private JButton bEditSupplier;
	private JComboBox cSuppliers;
	private Validator validator;

	/**
	 * Create the dialog.
	 */
	public DManageSuppliers(PStorageManagment panel) {
		super(panel);
		
		validator= new Validator();
		
		setTitle("Zarządzaj dostawcami");
		setBounds(100, 100, 351, 301);
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
				JLabel lblNowaKategoria = new JLabel("Nowy dostawca");
				panel_1.add(lblNowaKategoria, "2, 2");
			}
			{
				JLabel lblNazwa = new JLabel("Nazwa:");
				panel_1.add(lblNazwa, "2, 4, right, default");
			}
			{
				tSupplier = new JTextField();
				panel_1.add(tSupplier, "4, 4, fill, default");
				tSupplier.setColumns(10);
			}
			{
				JButton btnDodaj = new JButton("Dodaj");
				btnDodaj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addSupplier();
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
				JLabel lblZarzdzajKategoriami = new JLabel("Zarządzaj dostawcami");
				panel_1.add(lblZarzdzajKategoriami, "2, 2");
			}
			{
				cSuppliers = new JComboBox();
				panel_1.add(cSuppliers, "2, 4, 5, 1, fill, default");
			}
			{
				bRemoveSupplier = new JButton("Usuń");
				panel_1.add(bRemoveSupplier, "4, 6, right, default");
			}
			{
				bEditSupplier = new JButton("Edytuj");
				bEditSupplier.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				panel_1.add(bEditSupplier, "6, 6, right, default");
			}
			{
				bRemoveSupplier = new JButton("Usuń");
				panel_1.add(bRemoveSupplier, "4, 6, right, default");
			}
			{
				bEditSupplier = new JButton("Edytuj");
				panel_1.add(bEditSupplier, "6, 6, right, default");
			}
		
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Zamknij");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void addSupplier(){
		if(validator.addSupplier(tSupplier.getText().toString())){
			JOptionPane.showMessageDialog(this, "Dodano dostawcę");
		}
		else JOptionPane.showMessageDialog(this, "Błąd dodawania dostawcy");
	}

}
