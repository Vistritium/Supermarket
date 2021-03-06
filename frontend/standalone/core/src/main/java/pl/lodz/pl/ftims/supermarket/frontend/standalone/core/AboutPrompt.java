package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPrompt extends JFrame implements ActionListener {
	JButton zamknij;
	JLabel tekst1,tekst2;
//	Thread fred;
	int i = 0;
	JPanel panel;
	public AboutPrompt(){
		panel = new JPanel();
		//this.panel.setLayout(new BorderLayout());
		tekst1 = new JLabel("O programie ");
		tekst2 = new JLabel(Stale.getInstance().getProgram_title());
		tekst1.setFont(new Font("Verdana",Font.BOLD,24));
		tekst2.setFont(new Font("Verdana",Font.ITALIC,32));
		zamknij = new JButton("Zamknij");
		zamknij.addActionListener(this);
		this.setTitle("O programie");
		this.panel.add(tekst1);
		this.panel.add(tekst2);
		
		this.panel.add(new JLabel("Boss : " + Stale.getInstance().getArchitekci()));
		
		this.panel.add(new JLabel("Database : " + Stale.getInstance().getDatabase()));
		this.panel.add(new JLabel("Viewer : " + Stale.getInstance().getViewer()));
		this.panel.add(new JLabel("Finance : " + Stale.getInstance().getFinance()));
		this.panel.add(new JLabel("Storage : " + Stale.getInstance().getStorage()));
		this.panel.add(new JLabel("Statistic : " + Stale.getInstance().getStatistics()));
		this.panel.add(new JLabel("Human Resources : " + Stale.getInstance().getHuman()));
		this.panel.add(new JLabel("Database : " + Stale.getInstance().getDatabase()));
		this.panel.add(new JLabel("WebApp : " + Stale.getInstance().getWebapp()));
		this.panel.add(new JLabel("         "));
		this.panel.add(zamknij);
		this.add(panel);
		this.setSize(400, 500);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
//		TODO: Epilepsja motzno
//		fred = new Thread() {
//			public void run() {
//				while(true){				
//					setBacka(losujKolor());
//					try {
//						this.sleep(50); //Czas sleepa w ms
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		fred.start();
		
		
	}

//	public void setBacka(Color kolo){
//		this.panel.setBackground(kolo);
//		this.zamknij.setBackground(losujKolor());
//	}
	
	public Color losujKolor(){
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color kolor = new Color(r,g,b);
		return kolor;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object z = arg0.getSource();
		if(z.equals(this.zamknij)){
//			fred.stop();
			this.dispose();
			
		}
		
	}
	

}
