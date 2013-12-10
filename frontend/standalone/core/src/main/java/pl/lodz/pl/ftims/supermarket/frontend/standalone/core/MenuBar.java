import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;


public class MenuBar implements ActionListener {
	JMenuBar menuBar;
    JMenu menuProgram, menuPomoc;
    JMenuItem itemZakoncz;
    JMenuItem itemTest;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    
    public JMenuBar createMenuBar(){
	    //Tworzenie glownego menubara
	    menuBar = new JMenuBar();
	
	    //Tworzenie menu Program
	    menuProgram = new JMenu("Program");
	    menuProgram.setMnemonic(KeyEvent.VK_P);
	    menuBar.add(menuProgram);
	    
	    //Zawartosc menu Program
	    itemZakoncz = new JMenuItem("Zakoñcz",KeyEvent.VK_T);
	    itemZakoncz.addActionListener(this);
	    menuProgram.add(itemZakoncz);
	    
	    //Dodanie testowe przycisku do testowe
	    itemTest = new JMenuItem("TEST");
	    itemTest.addActionListener(this);
	    menuProgram.add(itemTest);
	    
	    //Tworzenie menu Pomoc
	    menuPomoc = new JMenu("Pomoc");
	    menuPomoc.setMnemonic(KeyEvent.VK_H);
	    menuBar.add(menuPomoc);
	
	
		
	    return menuBar;
    }
    
    
    public void addMenu(JMenu menu){
        menuBar.add(menu);
    }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object z = arg0.getSource();
		if(z.equals(itemZakoncz)){
			//System.out.println("Nacisnieto zakoncz");
			System.exit(1);			
		}
		if(z.equals(itemTest)){
			System.out.println("Nacisnieto test");
			System.out.println(menuBar.getMenuCount());
			JMenu menuModul = new JMenu("NAZWAMODULU");
			menuBar.add(menuModul);
			System.out.println(menuBar.getMenuCount());
		}		
	}
}
