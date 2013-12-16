package backend.core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Singleton session factory manager for creating and holding SessionFactory
 * @author Maciej Nowicki
 *
 */
public enum SessionFactoryManager {
	INSTANCE;
	
	private SessionFactory sessionFactory;
	
	/**
	 * Initialize class. Create and configure SessionFactory
	 */
	public void init(){
        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.connection.driver_class",
                "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url",
                "jdbc:mysql://db4free.net:3306/iomarket");
        cfg.setProperty("hibernate.connection.username", "iomarket");
        cfg.setProperty("hibernate.connection.password", "iomarket123");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");

        cfg.setProperty("show_sql", "true");
        
        cfg.addResource("Products.hbm.xml");
        cfg.addResource("Suppliers.hbm.xml");
        cfg.addResource("Attributes.hbm.xml");
        cfg.addResource("AttrValues.hbm.xml");
        cfg.addResource("Category.hbm.xml");
        cfg.addResource("Users.hbm.xml");
        cfg.addResource("Orders.hbm.xml");
        cfg.addResource("Groups.hbm.xml");
        cfg.addResource("Monitoring.hbm.xml");
        cfg.addResource("MonitoringWorkers.hbm.xml");
        cfg.addResource("FinanceRegister.hbm.xml");
        cfg.addResource("Manufacturers.hbm.xml");
        
        sessionFactory = cfg.buildSessionFactory();
	}

	/**
	 * getter for SessionFactory. If SessionFactory is not created it will be created automaticly.
	 * @return SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			synchronized (this) {
				if (sessionFactory == null) {
					this.init();
				}
			}
		}
		return sessionFactory;
	}

}
