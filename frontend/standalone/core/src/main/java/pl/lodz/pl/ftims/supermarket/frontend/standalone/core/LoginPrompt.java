package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class LoginPrompt extends JFrame {
	private static final long serialVersionUID = 1L;

	public JButton loguj, anuluj;
	public JLabel label1, label2;
	public JTextField login;
	public JPasswordField pass;
	
	public LoginPrompt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Zaloguj się do supermarketu " + Stale.getInstance().getProgram_title());
		this.setSize(600, 200);
		this.setVisible(true);
		this.setResizable(false);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		this.label1 = new JLabel("Login: ");
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.anchor = GridBagConstraints.EAST;
		gbc_label1.gridx = 0;
		gbc_label1.gridy = 0;
		getContentPane().add(label1, gbc_label1);
		
		this.login = new JTextField();
		GridBagConstraints gbc_login = new GridBagConstraints();
		gbc_login.fill = GridBagConstraints.HORIZONTAL;
		gbc_login.gridx = 1;
		gbc_login.gridy = 0;
		getContentPane().add(login, gbc_login);
		login.setColumns(10);
		
		this.label2 = new JLabel("Hasło: ");
		GridBagConstraints gbc_label2 = new GridBagConstraints();
		gbc_label2.anchor = GridBagConstraints.EAST;
		gbc_label2.gridx = 0;
		gbc_label2.gridy = 1;
		getContentPane().add(label2, gbc_label2);
		
		this.pass = new JPasswordField();
		GridBagConstraints gbc_pass = new GridBagConstraints();
		gbc_pass.fill = GridBagConstraints.HORIZONTAL;
		gbc_pass.gridx = 1;
		gbc_pass.gridy = 1;
		getContentPane().add(pass, gbc_pass);
		
		this.loguj = new JButton("Zaloguj");
		GridBagConstraints gbc_loguj = new GridBagConstraints();
		gbc_loguj.anchor = GridBagConstraints.WEST;
		gbc_loguj.gridx = 1;
		gbc_loguj.gridy = 2;
		getContentPane().add(loguj, gbc_loguj);
		
		this.anuluj = new JButton("Anuluj");
		GridBagConstraints gbc_anuluj = new GridBagConstraints();
		gbc_anuluj.anchor = GridBagConstraints.WEST;
		gbc_anuluj.gridx = 1;
		gbc_anuluj.gridy = 3;
		getContentPane().add(anuluj, gbc_anuluj);
		
		this.getRootPane().setDefaultButton(loguj);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().revalidate();
		getContentPane().repaint();
	}
}