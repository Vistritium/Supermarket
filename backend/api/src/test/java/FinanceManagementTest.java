

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;

import backend.api.FinanceManagement;
import backend.core.SessionFactoryManager;
import backend.core.model.Users;

public class FinanceManagementTest {

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

}
