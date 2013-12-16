package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test extends JFrame {
	
	private JPanel contentPane;

	public test(JPanel contentPane) {
		setSize(new Dimension(700, 372));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HR_main panel = new HR_main();
					test frame = new test(panel.getMainPanel());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
