package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class DManageCategories extends ModelDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tCategory;
	private JButton bRemoveCategory;
	private JComboBox cCategories;
	private JButton bEditCategory;

	/**
	 * Create the dialog.
	 */
	public DManageCategories(JPanel panel) {
		super(panel);
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
				panel_1.add(bRemoveCategory, "4, 6, right, default");
			}
			{
				bEditCategory = new JButton("Edytuj");
				panel_1.add(bEditCategory, "6, 6, right, default");
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

}
