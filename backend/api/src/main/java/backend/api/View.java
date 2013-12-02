package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import backend.core.SessionFactoryManager;
import backend.core.model.Groups;
import backend.core.model.Users;

/**
 *
 * @author Andrzej
 */
public class View {
	
	private static SessionFactory sf = SessionFactoryManager.INSTANCE
			.getSessionFactory();
	
    public Groups checkAuthorization(String name, String Password)
    {
        Groups g = new Groups();
        return g;
    }
    
      public Users[] getUsers(int IdGroup)
    {
        Users u[] = new Users[1];
        return u;
    }
}
