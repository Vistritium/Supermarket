package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPrompt extends JFrame {
	private static final long serialVersionUID = 1L;

	public JPasswordField pass;
	public JLabel label1,label2;
	public JTextField login;
	public JButton loguj,anuluj;
	
	public LoginPrompt(){
		this.setLayout(new GridLayout(3,2));
		this.setTitle("Zaloguj się do supermarketu "+Constants.program_title);
		this.setSize(600, 200);
		this.setVisible(true);
		this.loguj=new JButton("Zaloguj");
		this.anuluj = new JButton("Anuluj");
		this.pass = new JPasswordField();
		this.login = new JTextField();
		this.label1 = new JLabel("Login : ");
		this.label2 = new JLabel("Hasło : ");
		this.label1.setVisible(true);
		this.label1.setBounds(10, 50, 100, 50);
		this.add(label1);
		this.add(login);
		this.add(label2);
		this.add(pass);
		this.add(loguj);
		this.add(anuluj);
		this.login.setSize(100, 20);
		this.setResizable(false);
	}
}