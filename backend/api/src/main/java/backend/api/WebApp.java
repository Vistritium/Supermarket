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

import backend.core.SessionFactoryManager;
import backend.core.model.Category;
import backend.core.model.Products;

/**
 *
 * @author Andrzej
 */
public class WebApp {
	
    
    public List<Products> getProducts() // dziala
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {
        	
            Query query = s.createQuery("select p from Products p");
            
            List<Products> products =  query.list();
            return products;

        } catch (Exception e){
           	e.printStackTrace();
           	return null;
           }
        finally {
            s.close();
        }
    }
    
    public List<Category> getCategory() // nie dziala jak na razie
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {
        	
            Query query = s.createQuery("from Category c");
            
            List<Category> category =  query.list();
            return category;

        } catch (Exception e){
           	e.printStackTrace();
           	return null;
           }
        finally {
            s.close();
        }
    }
}
