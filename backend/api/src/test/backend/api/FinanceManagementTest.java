package backend.api;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class FinanceManagementTest {

	@Test
	public void test() {
	
		FinanceManagement financeManagement = new FinanceManagement();
		SessionFactory instance = FinanceManagement.getInstance();
		
	}

}
