package backend.core.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import backend.core.model.Users;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





/**
 *
 * @author Andrzej
 */
public class UserController {
    
    private static SessionFactory sf = null;

    public static SessionFactory getInstance() {

        if (sf == null) {

            Configuration cfg = new Configuration();
            cfg.setProperty("hibernate.dialect",
                    "org.hibernate.dialect.MySQLDialect");
            cfg.setProperty("hibernate.connection.driver_class",
                    "com.mysql.jdbc.Driver");
            cfg.setProperty("hibernate.connection.url",
                    "jdbc:mysql://localhost/io");
            cfg.setProperty("hibernate.connection.username", "root");
            cfg.setProperty("hibernate.connection.password", "");
            cfg.setProperty("hibernate.hbm2ddl.auto", "update");

            cfg.setProperty("show_sql", "true");
            
            cfg.addResource("Groups.hbm.xml");
            cfg.addResource("Users.hbm.xml");
            

            sf = cfg.buildSessionFactory();
        }

        return sf;
    }

    public UserController() {
    }

    public void addUser(Users user) {

        Session s = getInstance().openSession();
        try {
            Transaction tx = s.beginTransaction();

            try {
                s.save(user);

                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            }
        } finally {
            s.close();
        }
    }
    
    public Users getUsersByGroupId(int id) {

        Users user;

        Session s = getInstance().openSession();
        try {
             //pracownik = (Pracownik) s.load(Pracownik.class, id);

            Query query = s.createQuery("select u from Users u where "
                    + "idusers = " + id);
            
            user = (Users) query.list().get(0);

        } finally {
            s.close();
        }

        return user;
    }
  
}
