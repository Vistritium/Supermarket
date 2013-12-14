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
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import backend.core.SessionFactoryManager;
import backend.core.model.FinanceRegister;
import backend.core.model.Groups;
import backend.core.model.Users;

/**
 *
 * @author Andrzej
 */
public class FinanceManagement {
    
    private static SessionFactory sf = null;

    public static SessionFactory getInstance() {

        if (sf == null) {

            Configuration cfg = new Configuration();
            cfg.setProperty("hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect");
            cfg.setProperty("hibernate.connection.driver_class",
                    "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.url",
                    "jdbc:mysql://db4free.net:3306/iomarket");
            cfg.setProperty("hibernate.connection.username", "iomarket");
            cfg.setProperty("hibernate.connection.password", "iomarket123");
            cfg.setProperty("hibernate.hbm2ddl.auto", "update");

            cfg.setProperty("show_sql", "true");
            
            cfg.addResource("Groups.hbm.xml");
            cfg.addResource("Users.hbm.xml");
            cfg.addResource("FinanceRegister.hbm.xml");

            sf = cfg.buildSessionFactory();
        }

        return sf;
    }

    
    public List<Users> getAllUser()
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
    
    //zrobic-------------- HOW??!!
     public List<Users> getUsers(int IdGroup)
    {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {
        	Query q = s.createQuery("from Users u, Groups g where '"+IdGroup+"'=g.idgroups");      
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

    
    public boolean addFinanceRegisterRecord(FinanceRegister fr)
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {
            Transaction tx = s.beginTransaction();

            try {
                s.save(fr);

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
    
    public FinanceRegister getFinanceRegisterRecord()
    {
        FinanceRegister fr = new FinanceRegister();
        //sprecyzuj czego kurwa chcesz? :P
        return fr;
    }
    public List<FinanceRegister> getFinanceRegisterRecords()
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {

            Query q = s.createQuery("select * from FinanceRegister");        
            List<FinanceRegister> result =q.list();
            if (result.isEmpty() || result.size()==0)
            	return null;
            return result;

        } finally {
            s.close();
        }
    }
    
    
    
}
