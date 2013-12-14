package backend.api;

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
	
	private static SessionFactory sf = SessionFactoryManager.INSTANCE.getSessionFactory();
    
    public List<Products> getProducts() // ok
    {
    	Session s = sf.openSession();
        try {
        	
            Query query = s.createQuery("select p from Products p");
            
            List<Products> products =  query.list();
            if (products.isEmpty() || products.size()==0)
            	return null;
            return products;

        } catch (Exception e){
           	e.printStackTrace();
           	return null;
           }
        finally {
            s.close();
        }
    }
    
    public List<Category> getCategory() // ok
    {

    	Session s = sf.openSession();
        try {
        	
            Query query = s.createQuery("select c from Category c");
            
            List<Category> category =  query.list();
            if (category.isEmpty() || category.size()==0)
            	return null;
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

