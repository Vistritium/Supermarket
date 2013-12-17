

import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import backend.api.StorageManagement;
import backend.core.SessionFactoryManager;
import backend.core.model.Category;

public class FinanceManagementTest {

	 private static SessionFactory sf = SessionFactoryManager.INSTANCE.getSessionFactory();

	 @Test
	 public void SM()
	 {
		 //Category c = new Category();
		 StorageManagement sm = new StorageManagement();
		 sm.getProducts();
		 /*
		 Iterator<Category> itr=list.iterator();  
		    while(itr.hasNext()){  
		        System.out.println(itr.next());  
		    }
		    */
		 //HumanResources hr = new HumanResources();
		 //Manufacturers m = new Manufacturers("Sokołów");
		 //sm.addManufacturer(m);
		 //Manufacturers m2 = sm.getManufacturer(3);
		// m2.setName("Warka");
		// sm.editManufacturer(m2);
		// sm.removeManufacturer(2);
		// Category c = new Category("Wędliny");
		// sm.addCategory(c);
		//Category c2=sm.getCategory(8);
		//Products p = new Products("spodnie", c2, 50, 3, m2.getIdManufacturer());
		// sm.addProduct(p);
		 //Products p2 =sm.getProduct(1, "odzież");
		 //System.out.println(p2);
		// Users u = hr.getUser(0);
		 //Date d = new Date(2013,05,01);
		 //FinanceRegister fr = new FinanceRegister(500, u, d , 500, "Zakup czegos");
		 //System.out.println(sm.addFinanceRegisterRecord(fr));
	 }
	 
	 
	 /*	 
	  @Ignore	
	  @Test
	 public void HR ()
	 {
		 
			 HumanResources hr = new HumanResources();

			 List<Users> list=hr.getUsers(1); 
			 System.out.println(list.size());
			 
				Iterator<Users> itr=list.iterator();  
			    while(itr.hasNext()){  
			        System.out.println(itr.next());  
			    }
			    
			    
	 }
	 	 @Ignore
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

		 Category c = new Category("Odzież1");
		 Attributes a = new Attributes("spodnie");
		 Set<Attributes> as = new HashSet<Attributes>(0);
		 as.add(a);
		 c.setAttributes(as);
		 StorageManagement sm = new StorageManagement();
		 sm.addCategory(c);
		 
		 System.out.println(cat2.size());
			//for(Iterator<Category> i = cat2.iterator(); i.hasNext();){
         //	System.out.println(i.next().getName());
        // }
		 
	 }
	 
	 @Ignore
	 @Test
		public void hr() {
		
			HumanResources hr = new HumanResources();
			//Groups g2 = hr.getGroup().get(0);
			Groups g2 = new Groups("Kasjer", "ta dam", 2500);
			hr.addGroup(g2);
			
			Set<Groups> groups = new HashSet<Groups>(1);
			groups.add(g2);
			//System.out.println(g1.getName());
			Users u = new Users();
			u.setName("Marek");
			u.setSurname("Marecki");
			u.setPassword("rgeffrgergerhehe");
			u.setGroups(groups);
			hr.addUser(u);
			
			 
			
			Users u = hr.getUser(5);
			
			Set<Groups> groups = new HashSet<Groups>(0);
			groups.add(g1);
			System.out.println(u.getName());
			u.addGroups(groups);
			u.setName("test5555");
			hr.editUser(u);
			
			
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
	}*/
}
