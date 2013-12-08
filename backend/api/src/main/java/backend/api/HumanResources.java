package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

    
	    public Users getUser(int idUser)
	    {
	    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
	        try {

	            Query q = s.createQuery("select u from Users u where "+idUser+"=u.idusers");        
	            List<Users> result =q.list();
	            if (result.isEmpty() || result.size()==0)
	            	return null;
	            return (Users) result.get(0);

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
        } finally {
            s.close();
        }
    }
    
    public List<Users> getUsers(int IdGroup)
   {
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
    public void editUser(Users user)
    {
    	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    
            session.update(user);
            tx.commit();
               
        }
    	finally {
    		session.close();
        }
        
    }
    
    public void removeUser(int idUser)
    {
    	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    		Users user = (Users) session.load(Users.class, idUser);
            if (null != user)
            {
                session.delete(user);
            }
            tx.commit();
        }
    	finally {
    		session.close();
        }
    }
    
    public boolean removeGroup(int idGroup)
    {
    	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
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
    	finally {
    		session.close();
        }
    }
    
    public void editGroup(Groups newData)
    {
    	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    
            session.update(newData);
            tx.commit();
               
        }
    	finally {
    		session.close();
        }
    }
    
    public List<Groups> getGroup()
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {

            Query q = s.createQuery("select g from Groups g");        
            List<Groups> result =q.list();
            if (result.isEmpty() || result.size()==0)
            	return null;
            return result;

        } finally {
            s.close();
        }
    }
    
    public boolean addGroup(Groups newData)
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
        } finally {
            s.close();
        }
    }
}
