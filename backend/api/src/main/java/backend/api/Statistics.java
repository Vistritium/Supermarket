package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.List;

import backend.core.SessionFactoryManager;
import backend.core.model.FinanceRegister;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import backend.core.model.Monitoring;
import backend.core.model.MonitoringWorkers;
import backend.core.model.Users;

/**
 *
 * @author Andrzej
 */
public class Statistics {

	private static SessionFactory sf = SessionFactoryManager.INSTANCE.getSessionFactory();

    public List<Monitoring> getRecords()
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {
        	
            Query query = s.createQuery("select m from Monitoring m");
            
            List<Monitoring> monitor =  query.list();
            return monitor;

        } finally {
            s.close();
        }
    }
    
    public List<MonitoringWorkers> getRecordsMonitoringWorkers()
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {
        	
            Query query = s.createQuery("select m from MonitoringWorkers m");
            
            List<MonitoringWorkers> monitor =  query.list();
            return monitor;

        } finally {
            s.close();
        }
    }
    
    public void setRecords(Monitoring m)
    {
    	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    
            session.update(m);
            tx.commit();
               
        }
    	finally {
    		session.close();
        }
    }
    
    public void setRecordsMonitoringWorkers(MonitoringWorkers m)
    {
    	Session session = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    
            session.update(m);
            tx.commit();
               
        }
    	finally {
    		session.close();
        }
    }
    
    public boolean addFinanceRegisterRecord(FinanceRegister fr)
    {
        Session s = sf.openSession();
        try {
            Transaction tx = s.beginTransaction();

            try {
                s.save(fr);

                tx.commit();
                return true;
            } catch (Exception e) {
                tx.rollback();
                return false;
            }
        } finally {
            s.close();
        }
    }
    
    public List<FinanceRegister> getFinanceRegisterRecord()
    {
    	Session s = SessionFactoryManager.INSTANCE.getSessionFactory().openSession();
        try {
        	
            Query query = s.createQuery("select m from FinanceRegister m");
            
            List<FinanceRegister> monitor =  query.list();
            return monitor;

        } finally {
            s.close();
        }
    }

    
}
