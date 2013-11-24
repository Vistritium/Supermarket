package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import backend.core.model.Groups;
import backend.core.model.Users;

/**
 *
 * @author Andrzej
 */
public class HumanResources {
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

            sf = cfg.buildSessionFactory();
        }

        return sf;
    }
    
    public Users getUser(int idUser)
    {
        Users u = new Users();
        return u;
    }
    
    public boolean addUser(Users user)
    {
        return false;
    }
    
     public Users[] getUsers(int IdGroup)
    {
        Users u[] = new Users[1];
        return u;
    }
     
    public Users editParametr(String name, Object value)
    {
        Users u = new Users();
        return u;
    }
    
    public Users editUser(Users newData)
    {
        Users u = new Users();
        return u;
    }
    
    public Users removeUser(int idUser)
    {
        Users u = new Users();
        return u;
    }
    
    public boolean removeGroup(int idGroup)
    {
        return false;
    }
    
    public Groups editGroup(Groups newData)
    {
        Groups g = new Groups();
        return g;
    }
    
    public Groups getGroup()
    {
        Groups g = new Groups();
        return g;
    }
    
    public Users getUser()
    {
        Users u = new Users();
        return u;
    }
    
}
