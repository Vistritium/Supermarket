package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import backend.core.SessionFactoryManager;
import backend.core.controller.UserController;
import backend.core.model.Groups;
import backend.core.model.Users;

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
        Users u = new Users();
        return u;
    }
    
    public boolean addUser(Users user)
    {
    	//UserController uc = new UserController();
    	//uc.addUser(user);
    
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
    
     public Users[] getUsers(int IdGroup)
    {
        Users u[] = new Users[1];
        return u;
    }
     
    public Users editParametr(String name, Object value)
    {
        Users u = new Users();
        return u;
    }
    
    public Users editUser(Users newData)
    {
        Users u = new Users();
        return u;
    }
    
    public Users removeUser(int idUser)
    {
        Users u = new Users();
        return u;
    }
    
    public boolean removeGroup(int idGroup)
    {
        return false;
    }
    
    public Groups editGroup(Groups newData)
    {
        Groups g = new Groups();
        return g;
    }
    
    public Groups getGroup()
    {
        Groups g = new Groups();
        return g;
    }
    
    public Users getUser()
    {
        Users u = new Users();
        return u;
    }
    
}
