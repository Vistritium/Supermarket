

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import backend.api.FinanceManagement;
import backend.api.HumanResources;
import backend.api.StorageManagement;
import backend.api.WebApp;
import backend.core.SessionFactoryManager;
import backend.core.model.Attributes;
import backend.core.model.Category;
import backend.core.model.FinanceRegister;
import backend.core.model.Groups;
import backend.core.model.Products;
import backend.core.model.Users;

public class FinanceManagementTest {

	 private static SessionFactory sf = SessionFactoryManager.INSTANCE.getSessionFactory();
	 
	 @Test
	 public void fm ()
	 {
		 
			 FinanceManagement fm = new FinanceManagement();
			 Users u = fm.getUser(5);
			 System.out.println(u.getName());
			 FinanceRegister fr = new FinanceRegister(500, u, new Date(), 500, "blabla");
			 fm.addFinanceRegisterRecord(fr);
		 
	 }
	 @Ignore
	 @Test
		public void sm() {
		
			StorageManagement sm = new StorageManagement();
			List<Category> list=sm.getCategory(); 
			Iterator<Category> itr=list.iterator();  
		    while(itr.hasNext()){  
		        System.out.println(itr.next().getName());  
		    }
		}
	 
	 @Ignore
	 @Test
	 public void veb() {
		 WebApp vA = new WebApp();
		 List<Category> cat2 = vA.getCategory();
/*
		 Category c = new Category("Odzież1");
		 Attributes a = new Attributes("spodnie");
		 Set<Attributes> as = new HashSet<Attributes>(0);
		 as.add(a);
		 c.setAttributes(as);
		 StorageManagement sm = new StorageManagement();
		 sm.addCategory(c);
		 */
		 System.out.println(cat2.size());
			//for(Iterator<Category> i = cat2.iterator(); i.hasNext();){
         //	System.out.println(i.next().getName());
        // }
		 
	 }
	 
	 @Ignore
	 @Test
		public void hr() {
		
			HumanResources hr = new HumanResources();
			Groups g1 = hr.getGroup().get(1);
			Groups g2 = new Groups("admiddn", "trddololo", 2500);
			//hr.addGroup(g2);
			/*
			Set<Groups> groups = new HashSet<Groups>(1);
			groups.add(g2);
			System.out.println(g1.getName());
			Users u = new Users();
			u.setName("drupa");
			u.setSurname("dupa1");
			u.setPassword("wgea1rgrgrsgereg");
			u.setGroups(groups);
			hr.addUser(u);
			/*
			 * 
			 
			Users u = hr.getUser(5);
			
			Set<Groups> groups = new HashSet<Groups>(0);
			groups.add(g1);
			System.out.println(u.getName());
			u.addGroups(groups);
			u.setName("test5555");
			hr.editUser(u);
			*/
			
			List<Groups> groups2 = hr.getGroup();
			for(Groups group : groups2){
            	System.out.println(group);
            }
			
		}

	 
	 @Ignore
	 @Test
		public void category() {
		
			Category c = new Category("Odzież");
			StorageManagement sm = new StorageManagement();
			Category c1 = sm.getCategory("Odzież");
			System.out.println(c1.getName());
		}
	 
	@Ignore
	@Test
	public void test() {
	
		FinanceManagement financeManagement = new FinanceManagement();
		SessionFactory instance = SessionFactoryManager.INSTANCE.getSessionFactory();
		
	}
	
	@Ignore
	@Test
	public void queryTest() {
		
		 Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
	        try {
	             //pracownik = (Pracownik) s.load(Pracownik.class, id);

	            Query query = s.createQuery("select u from Users u");
	            
	            List<Users> users =  query.list();
	            
	            for(Users user : users){
	            	System.out.println(user);
	            }

	        } finally {
	            s.close();
	        }
		
		
	}
	
	@Ignore
	@Test
	public void poidTest()
	{
		int idUser = 2;
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {

            Query q = s.createQuery("select u from Users u where "+idUser+"=u.idusers");        

            List<Users> result =q.list();
            if (result.isEmpty() || result.size()==0)
            	System.out.println("null");
            System.out.println((Users) result.get(0));

        } finally {
            s.close();
        }

	}
	
	@Ignore
	@Test
	public void xaxa()
	{
	      	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
	         try {
	         	Query q = s.createQuery("from Users u, Groups g where "+1+"=g.idgroups");      
	             List<Users> result =q.list();
	             if (result.isEmpty() || result.size()==0)
	            	 System.out.println("nima");
	             //System.out.println((Users) result);

	         } finally {
	             s.close();
	         }
	     }
	@Ignore
	@Test
	public void addgroup()
	{//Monitoring m = new Monitoring("test", "test", new Date(), "test");
		Groups newData = new Groups("Bijeacz","grupa ktora ssie", 5000000);
	Session s = sf.openSession();
    try {
        Transaction tx = s.beginTransaction();

        try {
            s.save(newData);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    } finally {
        s.close();
    }
	}
}
