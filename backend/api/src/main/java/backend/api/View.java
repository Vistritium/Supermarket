package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
	
    public boolean checkAuthorization(String name, String password)
    {
    	Session s = sf.openSession();
        try {

            Query q = s.createQuery("select u from Users u where u.name='" +name + "' and u.password='" +password + "'");        
            List<Users> result =q.list();
            if (result.isEmpty() || result.size()==0)
            	return false;
            return true;

        } finally {
            s.close();
        }
    }
    
      public List<Users> getUsers(int IdGroup)
    {	//jeszcze nie do konca jestem pewien... dam wam na razie zwracajaca wszystkich userow.
       	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {

            Query q = s.createQuery("select u from Users u, Groups g where "+IdGroup+"=g.idgroups");        
            List<Users> result =q.list();
            if (result.isEmpty() || result.size()==0)
            	return null;
            return result;

        } finally {
            s.close();
        }
    }
      
      public List<Users> getAllUsers()
      {
      	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
  	        try {
  	        	
  	            Query query = s.createQuery("select u from Users u");
  	            
  	            List<Users> users =  query.list();
  	            return users;

  	        } finally {
  	            s.close();
  	        }

      }
}
