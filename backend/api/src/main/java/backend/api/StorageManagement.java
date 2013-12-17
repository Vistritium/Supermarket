
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

import backend.core.SessionFactoryManager;
import backend.core.model.Attributes;
import backend.core.model.Category;
import backend.core.model.FinanceRegister;
import backend.core.model.Manufacturers;
import backend.core.model.Products;
 
 /**
  *
  * @author Andrzej
  */
 public class StorageManagement {
 
 	private static SessionFactory sf = SessionFactoryManager.INSTANCE
 			.getSessionFactory();
 
     public boolean addProduct(Products product) //ok
     {
     	Session s = sf.openSession();
         try {
             Transaction tx = s.beginTransaction();
 
             try {
                 s.save(product);
 
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
     

     public Products getProduct(int idProduct, String type) // po id // nie ma po typie, jezeli chcie to dodam
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
 
             Query q = s.createQuery("select p from Products p where '"+idProduct+"'=p.idProducts");        
             List<Products> result =q.list();
             if (result.isEmpty() || result.size()==0)
             	return null;
             return (Products) result.get(0);
 
         } finally {
             s.close();
         }
     }

     public List<Products> getProducts() //ok
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select p from Products p");
             
             List<Products> prod =  query.list();
             return prod;
 
         } finally {
             s.close();
         }
     }
     
     public void editProduct(Products product) //ok
     {
     	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
     	try
         {
     		Transaction tx = session.beginTransaction();
     
             session.update(product);
             tx.commit();
                
         }
     	finally {
     		session.close();
         }
     }
     
     public boolean removeProduct(int idProduct) //ok
     {
     	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
     	try
         {
     		Transaction tx = session.beginTransaction();
     		Products product = (Products) session.load(Products.class, idProduct);
             if (null != product)
             {
                 session.delete(product);
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
     
     public boolean removeCategory(int idCategory) //ok
     {
     	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
     	try
         {
     		Transaction tx = session.beginTransaction();
     		Category category = (Category) session.load(Category.class, idCategory);
             if (null != category)
             {
                 session.delete(category);
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
     
     public List<Category> getCategory() //ok
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select new backend.core.model.Category(c.idCategory, c.name) from Category c");
             
             List<Category> category =  query.list();
             return category;
 
         } finally {
             s.close();
         }
     }
     
     public Category getCategory(int idCategory) //ok
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("from Category c where c.idCategory='" + idCategory + "'");
             
             List<Category> category =  query.list();
             if (category.isEmpty() || category.size()==0)
             	return null;
             return (Category) category.get(0);
 
         } finally {
             s.close();
         }
     }
     
     public Category getCategory(String name) //ok
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("from Category c where c.name='" + name + "'");
             
             List<Category> category =  query.list();
             if (category.isEmpty() || category.size()==0)
             	return null;
             return (Category) category.get(0);
 
         } finally {
             s.close();
         }
     }
     public boolean addCategory(Category cat) //ok
     {
     	Session s = sf.openSession();
         try {
             Transaction tx = s.beginTransaction();
 
             try {
                 s.save(cat);
 
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
     
     public void editCategory(Category cat) //ok
     {
     	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
     	try
         {
     		Transaction tx = session.beginTransaction();
     
             session.update(cat);
             tx.commit();
                
         }
     	finally {
     		session.close();
         }
     }
     
     public List<Manufacturers> getManufacturer() //ok
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select m from Manufacturers m");
             
             List<Manufacturers> manu =  query.list();
             return manu;
 
         } finally {
             s.close();
         }
     }
     
     public Manufacturers getManufacturer(String name) //ok
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select m from Manufacturers m where m.name= '" + name +"'");
             
             List<Manufacturers> manu =  query.list();
             if (manu.isEmpty() || manu.size()==0)
             	return null;
             return (Manufacturers) manu.get(0);
 
         } finally {
             s.close();
         }
     }   
     
     public Manufacturers getManufacturer(int idManufacturer) //ok
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select m from Manufacturers m where m.idManufacturer= '" + idManufacturer + "'");
             
             List<Manufacturers> manu =  query.list();
             if (manu.isEmpty() || manu.size()==0)
             	return null;
             return (Manufacturers) manu.get(0);
 
         } finally {
             s.close();
         }
     }  
     
     public boolean addManufacturer(Manufacturers man) //ok
     {
     	Session s = sf.openSession();
         try {
             Transaction tx = s.beginTransaction();
 
             try {
                 s.save(man);
 
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
     
     public void editManufacturer(Manufacturers man)//ok
     {
     	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
     	try
         {
     		Transaction tx = session.beginTransaction();
     
             session.update(man);
             tx.commit();
                
         }
     	finally {
     		session.close();
         }
     }
     
      public boolean removeManufacturer(int idManufacturer) //ok
     {
      	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
      	try
          {
      		Transaction tx = session.beginTransaction();
      		Manufacturers manu = (Manufacturers) session.load(Manufacturers.class, idManufacturer);
              if (null != manu)
              {
                  session.delete( manu);
                  tx.commit();
                  return true;
              }
              else
              {
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
      
      
      public boolean removeAttributes(int idAttributes) //ok
      {
      	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
      	try
          {
      		Transaction tx = session.beginTransaction();
      		Category category = (Category) session.load(Category.class, idAttributes);
              if (null != category)
              {
                  session.delete(category);
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
      
      public List<Attributes> getAttributes() //ok
      {
      	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
          try {
          	
              Query query = s.createQuery("select a from Attributes a");
              
              List<Attributes> attributes =  query.list();
              return attributes;
  
          }
          catch (Exception e){
	        	e.printStackTrace();
	        	return null;
	        }
          finally {
              s.close();
          }
      }
      
      public Category getAttributes(int idAttributes) //ok
      {
      	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
          try {
          	
              Query query = s.createQuery("select a from Attributes a where a.idCategory='" + idAttributes + "'");
              
              List<Category> category =  query.list();
              if (category.isEmpty() || category.size()==0)
              	return null;
              return (Category) category.get(0);
  
          }
          catch (Exception e){
	        	e.printStackTrace();
	        	return null;
	        }
          finally {
              s.close();
          }
      }
      
      public Category getAttributes(String name) //ok
      {
      	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
          try {
          	
              Query query = s.createQuery("select a from Attributes a where a.name='" + name + "'");
              
              List<Category> category =  query.list();
              if (category.isEmpty() || category.size()==0)
              	return null;
              return (Category) category.get(0);
  
          } 
          catch (Exception e){
	        	e.printStackTrace();
	        	return null;
	        }
          finally {
              s.close();
          }
      }
      public boolean addAttributes(Attributes at) //ok
      {
      	Session s = sf.openSession();
          try {
              Transaction tx = s.beginTransaction();
  
              try {
                  s.save(at);
  
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
	        } finally {
              s.close();
          }
      }
      
      public void editAttributes(Attributes at) //ok
      {
      	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
      	try
          {
      		Transaction tx = session.beginTransaction();
      
              session.update(at);
              tx.commit();
                 
          }
      	catch (Exception e){
	        	e.printStackTrace();
	        }
      	finally {
      		session.close();
          }
      }
      
      
      
      
     public boolean addFinanceRegisterRecord(FinanceRegister fr) /// ok
     {
     	Session s = sf.openSession();
         try {
             Transaction tx = s.beginTransaction();
 
             try {
                 s.save(fr);
 
                 tx.commit();
                 return true;
             } catch (Exception e) {
            	 e.printStackTrace();
                 tx.rollback();
                 return false;
             }
         }catch (Exception e){
	        	e.printStackTrace();
	        	return false;
	        }
         finally {
             s.close();
         }
     }
     
     public List<FinanceRegister> getFinanceRegisterRecords() // ok
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select fr from FinanceRegister fr");
             
             List<FinanceRegister> fr =  query.list();
             return fr;
 
         }catch (Exception e){
	        	e.printStackTrace();
	        	return null;
	        }
         finally {
             s.close();
         }
     }
 
 }

