package backend.core.controller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import backend.core.model.Pracownik;

/**
 *
 * @author Andrzej
 */
public class PracownikController {

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

            cfg.addResource("Pracownicy.hbm.xml");

            sf = cfg.buildSessionFactory();
        }

        return sf;
    }

    public PracownikController() {
    }

    public void addPracownik(Pracownik pracownik) {

        Session s = getInstance().openSession();
        try {
            Transaction tx = s.beginTransaction();

            try {
                s.save(pracownik);

                tx.commit();

            } catch (Exception e) {
                tx.rollback();
            }
        } finally {
            s.close();
        }
    }

    public Pracownik getPracownikById(int id) {

        Pracownik pracownik;

        Session s = getInstance().openSession();
        try {
             //pracownik = (Pracownik) s.load(Pracownik.class, id);

            Query query = s.createQuery("from Pracownik where id =" + id);
            pracownik = (Pracownik) query.list().get(0);

        } finally {
            s.close();
        }

        return pracownik;
    }
}
