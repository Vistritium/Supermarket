package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import backend.core.model.FinanceRegister;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import backend.core.model.Monitoring;
import backend.core.model.MonitoringWorkers;

/**
 *
 * @author Andrzej
 */
public class Statistics {
    private static SessionFactory sf = null;

    public static SessionFactory getInstance() {

        if (sf == null) {

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
            
            sf = cfg.buildSessionFactory();
        }

        return sf;
    }
    public Monitoring[] getRecords()
    {
        Monitoring m[] = new Monitoring[1];
        return m;
    }
    
    public MonitoringWorkers[] getRecordsMonitoringWorkers()
    {
        MonitoringWorkers m[] = new MonitoringWorkers[1];
        return m;
    }
    
    public boolean setRecords(Monitoring m)
    {
        return false;
    }
    
    public boolean setRecordsMonitoringWorkers(MonitoringWorkers m)
    {
        return false;
    }
    
    public boolean addFinanceRegisterRecord(FinanceRegister fr)
    {
        return false;
    }
    
    public FinanceRegister getFinanceRegisterRecord()
    {
        FinanceRegister fr = new FinanceRegister();
        return fr;
    }
    public FinanceRegister[] getFinanceRegisterRecords()
    {
        FinanceRegister fr[] = new FinanceRegister[1];
        return fr;
    }
    
}
