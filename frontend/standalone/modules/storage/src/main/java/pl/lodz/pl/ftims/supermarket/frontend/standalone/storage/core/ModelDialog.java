package pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ModelDialog extends JDialog {

	//private final JPanel contentPanel = new JPanel();
	protected PStorageManagment panel;

	/**
	 * Create the dialog.
	 */
	public ModelDialog(PStorageManagment panel) {
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		
		//Set fields
		this.panel=panel;
		
		//Component [] components=this.panel.getComponents();
		//for(int i=0; i<components.length; i++) components[i].setEnabled(false);
	}
	
	//Close window and activate panel.
	protected void close(){
		Component [] components=this.panel.getComponents();
		for(int i=0; i<components.length; i++) components[i].setEnabled(true);
		this.dispose();
	}

}
