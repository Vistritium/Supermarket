package pl.lodz.pl.ftims.supermarket.frontend.standalone.start;


import pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core.Init;
import backend.core.SessionFactoryManager;

public class Main {

	public static void main(String[] args) {
		initDatabase();
		
		
	
	}

	private static void initDatabase() {
		SessionFactoryManager instance = SessionFactoryManager.INSTANCE;
		instance.getSessionFactory();
	}
	
	private static void initView(){
		//init view when done
	}
	
	private static void initStorageManagement(){
		pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core.Init init = new Init();
		init.init();
	}
	
}
