package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class MenuBar {
	JMenuBar menuBar;
    JMenu menuProgram, menuPomoc;
    JMenuItem itemZakoncz;
    JMenuItem itemPrzeloguj;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    
    public JMenuBar createMenuBar(){
	    //Tworzenie glownego menubara
	    menuBar = new JMenuBar();
	
	    //Tworzenie menu Program
	    menuProgram = new JMenu("Program");
	    menuProgram.setMnemonic(KeyEvent.VK_P);
	    menuBar.add(menuProgram);
	    
	  //Dodanie testowe przycisku do testowe
	    itemPrzeloguj = new JMenuItem("Przeloguj");
	    menuProgram.add(itemPrzeloguj);
	    
	    //Zawartosc menu Program
	    itemZakoncz = new JMenuItem("Zakończ",KeyEvent.VK_T);
	    menuProgram.add(itemZakoncz);
	    
	    
	    
	    //Tworzenie menu Pomoc
	    menuPomoc = new JMenu("Pomoc");
	    menuPomoc.setMnemonic(KeyEvent.VK_H);
	    menuBar.add(menuPomoc);

	    return menuBar;
    }
    
    public void addMenu(JMenu menu){
        menuBar.add(menu);
    }
}
