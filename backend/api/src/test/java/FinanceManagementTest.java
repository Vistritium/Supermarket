

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	public void removeUser()
	{

		
	}
	
}
