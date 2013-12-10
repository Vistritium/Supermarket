package pl.lodz.pl.ftims.supermarket.frontend.standalone.start;

import java.util.ArrayList;
import java.util.List;

import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.Initalizable;
import pl.lodz.pl.ftims.supermarket.frontend.standalone.core.MainFrame;
import backend.core.SessionFactoryManager;

public class Main {
	static private MainFrame view;
	
	public static void main(String[] args) {
		initDatabase();
		Main.view = initView();
		getModules();
	}

	private static void initDatabase() {
		SessionFactoryManager instance = SessionFactoryManager.INSTANCE;
		instance.getSessionFactory();
	}
	
	private static MainFrame initView(){
		return new MainFrame();
	}
	
	private static void getModules() {
		List<Initalizable> modules = new ArrayList<>();
		modules.add(getInitStorageManagement());
	}

	/* Modules */
	private static Initalizable getInitStorageManagement(){
		return new pl.lodz.pl.ftims.supermarket.frontend.standalone.storage.core.Init();
	}
}