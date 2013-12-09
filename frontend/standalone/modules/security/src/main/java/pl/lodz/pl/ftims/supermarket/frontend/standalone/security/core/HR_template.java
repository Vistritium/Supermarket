package pl.lodz.pl.ftims.supermarket.frontend.standalone.security.core;

import javax.swing.JPanel;

public abstract class HR_template {
	protected JPanel jpan;
	
	abstract void update();
	abstract void draw();
	abstract void init();
	abstract void reset();
	abstract void shutdown();
	
	abstract JPanel getPanel();
}
