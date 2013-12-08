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
import backend.core.model.Products;

/**
 *
 * @author Andrzej
 */
public class WebApp {
	


    public Products getProduct(int idProduct, String type) 
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {

            Query q = s.createQuery("select p from Products p where "+idProduct+"=u.idProducts");        
            List<Products> result =q.list();
            if (result.isEmpty() || result.size()==0)
            	return null;
            return (Products) result.get(0);

        } finally {
            s.close();
        }
    }
    
    public List<Products> getProducts()
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {
        	
            Query query = s.createQuery("select p from Products p");
            
            List<Products> products =  query.list();
            return products;

        } finally {
            s.close();
        }
    }
}
