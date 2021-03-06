package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import backend.api.View;


public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	List<Initalizable> modules;
	LoginPrompt login;
	String login_string;
	String pass_string;
	View view;
	MenuBar menu;
	public MainFrame(List<Initalizable> modules){
		this.modules = modules;
		login = new LoginPrompt();
		//view = new View();
		//JOptionPane.showMessageDialog(null,view.getAllUsers());

		this.login.loguj.addActionListener(this);
		this.login.anuluj.addActionListener(this);
	}
	
	public void startAfterLogin(){
		this.initializeWindow();
		this.createMenuBar();
		this.createMainJPanel();
		this.setVisible(true);
	}
	
	public boolean zaloguj(){
		System.out.println("Login : " + login.login.getText());
		System.out.println("Hasło : " + login.pass.getText());
		

		view = new View();
		login_string = login.login.getText();
		pass_string = login.pass.getText();
		
		if(view.checkAuthorization(login.login.getText(), login.pass.getText())){
			System.out.println("Udało się zalogowac");
			return true;
		}
		System.out.println("Nie udało się zalogować");
		return false;				
	} 
	
	public void initializeWindow(){
		this.setTitle(Stale.getInstance().getProgram_title());
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void createMenuBar(){
		menu = new MenuBar();
		this.setJMenuBar(menu.createMenuBar());
		menu.itemZakoncz.addActionListener(this);
		menu.itemPrzeloguj.addActionListener(this);
		menu.itemoProgramie.addActionListener(this);
	}

	public void createMainJPanel(){
		this.setContentPane(new MainPanel(modules));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object z = arg0.getSource();

		if(z.equals(login.loguj)){
			System.out.println("Nacisnieto zaloguj buduje okno programu glowne");
			login.setVisible(false);
			if(zaloguj()){
				Stale.getInstance().setLogin(login_string);
				Stale.getInstance().setPass(pass_string);
				//System.out.println(Stale.getInstance().getLogin()+"   " + Stale.getInstance().getPass());
				startAfterLogin();
			}
			else{
				JOptionPane.showMessageDialog(null, Stale.getInstance().getLogin_fail());
				login.setVisible(true);
				//System.exit(1);
			}
		}

		if(z.equals(login.anuluj)){
			System.out.println("Nacisnieto anuluj");
			System.exit(0);
		}
		if(z.equals(menu.itemZakoncz)){
			System.exit(0);
		}
		if(z.equals(menu.itemPrzeloguj)){
			this.login.pass.setText("");
			this.login.setVisible(true);
			this.setVisible(false);
		}
		if(z.equals(menu.itemoProgramie)){
			AboutPrompt prompt = new AboutPrompt();
		}
	}
}
