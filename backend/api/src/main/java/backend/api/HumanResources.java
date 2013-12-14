package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import backend.core.SessionFactoryManager;
import backend.core.controller.UserController;
import backend.core.model.Groups;
import backend.core.model.Users;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Andrzej
 */
public class HumanResources {
	 private static SessionFactory sf = SessionFactoryManager.INSTANCE.getSessionFactory();

    
	    public Users getUser(int idUser) // ok
	    {
	    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
	        try {

	            Query q = s.createQuery("select u from Users u where "+idUser+"=u.idusers");        
	            List<Users> result =q.list();
	            if (result.isEmpty() || result.size()==0)
	            	return null;
	            return (Users) result.get(0);

	        } 
	        catch (Exception e){
	        	e.printStackTrace();
	        	return null;
	        }
	        finally {
	            s.close();
	        }

	    }
    

    
    public List<Users> getAllUsers() // ok
    {
    	Session s = sf.openSession();
	        try {
	        	
	            Query query = s.createQuery("select u from Users u");
	            
	            List<Users> users =  query.list();
	            return users;

	        } 
	        catch (Exception e){
	        	e.printStackTrace();
	        	return null;
	        }
	        	finally {
	            s.close();
	        }
			

    }
  
    public boolean addUser(Users user)
    {
        Session s = sf.openSession();
        try {
            Transaction tx = s.beginTransaction();

            try {
                s.save(user);

                tx.commit();
                return true;
            } catch (Exception e) {
                tx.rollback();
                return false;
            }
        } catch (Exception e){
        	e.printStackTrace();
        	return false;
        }
        finally {
            s.close();
          
        }
    }
    
    public List<Users> getUsers(int IdGroup) // nie dziala wyswietla wszystkich userow, niezaleznie od grupy?? (dziwne przeciez zapytanie nawet mu nie pozwala)
   {
    	//Session s = sf.openSession(); // nie wiem jak sie odwolac do groups_has_user, takto problem bylby rozwiazany
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
       try {
    	   String hql = "select new backend.core.model.Users(u.idusers, u.name, u.surname, u.password, u.salt, u.hired, u.last_login) "
    	   		+ "from Users u join u.Groups g where g.idgroups in (:idGroup)";
    	   Query q = s.createQuery(hql);
    	   q.setParameter("idGroup", IdGroup);
    	   
    	   List<Users> result =q.list();
    	   
           if (result.isEmpty() || result.size()==0)
           	return null;
           return  result;
/*
           Query q = s.createQuery("select u from Users u, Groups g where u.i=g.idgroups");        
           List<Users> result =q.list();
           if (result.isEmpty() || result.size()==0)
           	return null;
           return result;
*/
       } catch (Exception e){
       	e.printStackTrace();
       	return null;
       }
       finally {
           s.close();
       }
   }
    public void editUser(Users user) // ok
    {
    	Session session = sf.openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    
            session.update(user);
            tx.commit();
               
        } catch (Exception e){
        	e.printStackTrace();
        }
    	finally  {
    		session.close();
        }
        
    }
    
    public boolean removeUser(int idUser) // ok
    {
    	Session session = sf.openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    		Users user = (Users) session.load(Users.class, idUser);
            if (null != user)
            {
                session.delete(user);
                tx.commit();
                return true;         
            }
            else{
            	return false;
            }
            
        }
    	catch (Exception e){
        	e.printStackTrace();
        	return false;
        }
    	finally {
    		session.close();
        }
		
    }
    
    public boolean removeGroup(int idGroup) // ok, rozpatrzyc przypadek kiedy usuwa sie grupe do ktorej ktos nalezy.
    {
    	Session session = sf.openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    		Groups group = (Groups) session.load(Groups.class, idGroup);
            if (null != group)
            {
                session.delete(group);
                tx.commit();
                return true;
            }
            else {
            	return false;
            }            
        }
    	catch (Exception e){
        	e.printStackTrace();
        	return false;
    	}
    	finally {
    		session.close();
        }
    }
    
    public void editGroup(Groups newData) // ok
    {
    	Session session = sf.openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    
            session.update(newData);
            tx.commit();
               
        }
    	catch (Exception e){
        	e.printStackTrace();
    	}
    	finally {
    		session.close();
        }
    }
    
    public List<Groups> getGroup() // dziala ale problem zaczyna sie wtedy kiedy musi wyswietlic tostring userow w grupie trzeba napisac innego to string
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {

            Query q = s.createQuery("select g from Groups g");        
            List<Groups> result =q.list();
            if (result.isEmpty() || result.size()==0)
            	return null;
            return result;

        } 
        catch (Exception e){
        	e.printStackTrace();
        	return null;
    	}
        finally {
            s.close();
        }
    }
    
    public boolean addGroup(Groups newData) // ok
    {
        Session s = sf.openSession();
        try {
            Transaction tx = s.beginTransaction();

            try {
                s.save(newData);

                tx.commit();
                return true;
            } catch (Exception e) {
                tx.rollback();
                return false;
            }
        } 
        catch (Exception e){
        	e.printStackTrace();
        	return false;
    	}finally {
            s.close();
        }
    }
}
