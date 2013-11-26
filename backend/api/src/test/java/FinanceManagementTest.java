

import org.hibernate.SessionFactory;
import org.junit.Test;

import backend.api.FinanceManagement;

public class FinanceManagementTest {

	@Test
	public void test() {
	
		FinanceManagement financeManagement = new FinanceManagement();
		SessionFactory instance = FinanceManagement.getInstance();
		
	}

}
