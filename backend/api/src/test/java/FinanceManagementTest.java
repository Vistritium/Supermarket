

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Ignore;
import org.junit.Test;

import backend.api.FinanceManagement;
import backend.core.SessionFactoryManager;
import backend.core.model.Groups;
import backend.core.model.Users;

public class FinanceManagementTest {

	 private static SessionFactory sf = SessionFactoryManager.INSTANCE.getSessionFactory();
    
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
