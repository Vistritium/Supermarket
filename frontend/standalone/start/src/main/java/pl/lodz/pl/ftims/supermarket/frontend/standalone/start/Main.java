package pl.lodz.pl.ftims.supermarket.frontend.standalone.start;


import java.util.ArrayList;
import java.util.List;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Initalizable;
import backend.core.SessionFactoryManager;

public class Main {

	public static void main(String[] args) {
		initDatabase();
		
		List<Initalizable> modules = new ArrayList<>();
		modules.add(getInitStorageManagement());
		
	
	}

	private static void initDatabase() {
		SessionFactoryManager instance = SessionFactoryManager.INSTANCE;
		instance.getSessionFactory();
	}
	
	private static void initView(){
		//init view when done
	}
	
	private static Initalizable getInitStorageManagement(){
		return new pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core.Init();
	}
	
}
