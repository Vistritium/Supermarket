package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.util.List;

public class InitView  {


	public void init(List<Initalizable> modules) {
		// TODO Auto-generated method stub
		MainFrame window = new MainFrame();
		window.modules.addAll(modules);
		
	}
	


}
