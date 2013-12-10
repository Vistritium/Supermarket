import javax.swing.BorderFactory;
import javax.swing.JPanel;


public abstract class Modul {
	String nazwa;
	JPanel panel;
	public Modul(String nazwa, JPanel panel) {
		super();
		this.nazwa = nazwa;
		this.panel = panel;
		this.panel.setBorder(BorderFactory.createTitledBorder(this.nazwa));
	}
	public final String getNazwa() {
		return nazwa;
	}
	public final JPanel getPanel() {
		return panel;
	}
}
