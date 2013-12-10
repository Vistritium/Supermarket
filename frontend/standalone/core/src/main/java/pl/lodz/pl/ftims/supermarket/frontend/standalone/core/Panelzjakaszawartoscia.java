import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Panelzjakaszawartoscia extends Modul {
	public Panelzjakaszawartoscia(){
		super("PRzykladowy(ogolnie nazwa)", new JPanel()); // jako 2 parametr wasz  JPanel moze byc np konrstruktor od rasu waszego modulu
		this.getPanel().setVisible(true);	//bez tego nie zawsze sie pokazuje (chyba ze stosujecie layout)
		this.getPanel().setBackground(Color.green); 
		this.getPanel().add(new JLabel("Jakas labelka i zawartosc itd")); // taki przykladowy object w tym przykladowym module
	}
}
