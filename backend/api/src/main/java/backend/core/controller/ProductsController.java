package backend.core.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import backend.core.model.Category;
import backend.core.model.Groups;
import backend.core.model.MonitoringWorkers;
import backend.core.model.Orders;
import backend.core.model.Products;
import backend.core.model.Users;

/**
 *
 * @author Andrzej
 */
public class ProductsController {
    
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

    public ProductsController() {
    }

    public void addProduct(Products product) {
        Session s = getInstance().openSession();
        try { 
            Transaction tx = s.beginTransaction();

            try {
                s.save(product);

                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            }
        } finally {
            s.close();
        }
    }
    
    public void addP()
    {
        Session session = getInstance().openSession();
 
	session.beginTransaction();
 
        Groups g = new Groups("kasjer", "kaka bukaka saka laka ", 4500);
	Users u = new Users("test", "test2", "sergerg", "grgeg", new Date(), new Date());
        
        Category c = new Category("d");
        session.save(c);
        Set<Groups> groups = new HashSet<Groups>();
        groups.add(g);
        
        u.setGroups(groups);
        Products p = new Products("spudnica", c, 1, 10, 1);
        session.save(p);
        Orders o = new Orders(1, new Date(), 1, p, u);
        session.save(u);
        session.save(o);
        session.getTransaction().commit();
    }
    
    
    public void monitoring(){
        Session session = getInstance().openSession();
 
	session.beginTransaction();
        //Monitoring m = new Monitoring("test", "test", new Date(), "test");
        MonitoringWorkers mw = new MonitoringWorkers(new Date(), new Date(), new Date(), new Date(), 8);
        session.save(mw);
        //session.save(mw);
        session.getTransaction().commit();
    }

}
