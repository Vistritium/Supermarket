package pl.lodz.pl.ftims.supermarket.frontend.standalone.core;

import java.util.ArrayList;
import java.util.List;

public class InitView  {


	public void init(List<Initalizable> modules) {
		// TODO Auto-generated method stub
		MainFrame window = new MainFrame(modules);
		//window.modules.addAll(modules);
		
	}
	
	
	
	public static void main(String[] args) {
		InitView initView = new InitView();
		initView.init(new ArrayList<Initalizable>());
	}
	


}
