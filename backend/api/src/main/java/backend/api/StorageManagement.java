
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
 
     public boolean addProduct(Products product)
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
             
             List<Products> prod =  query.list();
             return prod;
 
         } finally {
             s.close();
         }
     }
     
     public void editProduct(Products product)
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
     
     public boolean removeProduct(int idProduct)
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
     
     public boolean removeCategory(int idCategory)
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
     
     public List<Category> getCategory()
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select c from Category c");
             
             List<Category> category =  query.list();
             return category;
 
         } finally {
             s.close();
         }
     }
     
     public Category getCategory(String name)
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
     
     public boolean addCategory(Category cat)
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
     
     public void editCategory(Category cat)
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
     
     public List<Manufacturers> getManufacturer()
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
     
     public Manufacturers getManufacturer(String name)
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select m from Manufacturers m where m.name=" + name);
             
             List<Manufacturers> manu =  query.list();
             if (manu.isEmpty() || manu.size()==0)
             	return null;
             return (Manufacturers) manu.get(0);
 
         } finally {
             s.close();
         }
     }   
     
     public boolean addManufacturer(Manufacturers man)
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
     
     public void editManufacturer(Manufacturers man)
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
     
      public boolean removeManufacturer(int idManufacturer)
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
      	finally {
      		session.close();
          }
     }
      
      
     public boolean addFinanceRegisterRecord(FinanceRegister fr)
     {
     	Session s = sf.openSession();
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
     
     public List<FinanceRegister> getFinanceRegisterRecords()
     {
     	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
         try {
         	
             Query query = s.createQuery("select c from Category c");
             
             List<FinanceRegister> fr =  query.list();
             return fr;
 
         } finally {
             s.close();
         }
     }
 
 }

