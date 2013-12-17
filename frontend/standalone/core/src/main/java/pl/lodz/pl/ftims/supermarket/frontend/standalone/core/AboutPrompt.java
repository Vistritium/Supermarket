package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutPrompt extends JFrame implements ActionListener {
	JButton zamknij;
	JLabel tekst1,tekst2;
	public AboutPrompt(){
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		tekst1 = new JLabel("O programie ");
		tekst2 = new JLabel(Stale.getInstance().getProgram_title());
		tekst1.setFont(new Font("Verdana",Font.BOLD,24));
		tekst2.setFont(new Font("Verdana",Font.ITALIC,32));
		zamknij = new JButton("Zamknij");
		zamknij.addActionListener(this);
		this.add(tekst1);
		this.add(tekst2);
		this.add(zamknij);
		this.setSize(500, 600);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object z = arg0.getSource();
		if(z.equals(this.zamknij)){
			this.dispose();
		}
		
	}
	

}
