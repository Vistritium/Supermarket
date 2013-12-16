package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;


public class MainFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	List<Initalizable> modules;
	LoginPrompt login;
	public MainFrame(List<Initalizable> modules){
		this.modules = modules;
		login = new LoginPrompt();

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
		System.out.println("Hasło : " + login.pass.getPassword());

		return true;				//todo: Dorobic cialo logowania
	} 
	
	public void initializeWindow(){
		this.setTitle(Constants.program_title);
		//this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	public void createMenuBar(){
		this.setJMenuBar(new MenuBar().createMenuBar());
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
				startAfterLogin();
			}
		}

		if(z.equals(login.anuluj)){
			System.out.println("Nacisnieto anuluj");
			System.exit(0);
		}	
	}
}