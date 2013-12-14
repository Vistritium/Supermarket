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
    	Session s = sf.openSession();
        try {
        	
            Query query = s.createQuery("select m from Monitoring m");
            
            List<Monitoring> monitor =  query.list();
            if (monitor.isEmpty() || monitor.size()==0)
            	return null;
            return monitor;

        } finally {
            s.close();
        }
    }
    
    public List<MonitoringWorkers> getRecordsMonitoringWorkers()
    {
    	Session s = sf.openSession();
        try {
        	
            Query query = s.createQuery("select m from MonitoringWorkers m");
            
            List<MonitoringWorkers> monitor =  query.list();
            if (monitor.isEmpty() || monitor.size()==0)
            	return null;
            return monitor;

        } finally {
            s.close();
        }
    }
    
    public void setRecords(Monitoring m)
    {
    	Session session = sf.openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    
            session.update(m);
            tx.commit();
               
        }catch (Exception e){
        	e.printStackTrace();
        }
    	finally  {
    		session.close();
        }
    }
    
    public void setRecordsMonitoringWorkers(MonitoringWorkers m)
    {
    	Session session = sf.openSession();
    	try
        {
    		Transaction tx = session.beginTransaction();
    
            session.update(m);
            tx.commit();
               
        }
    	catch (Exception e){
    	e.printStackTrace();
    }
	finally  {
		session.close();
    }
    }
    
    public boolean addFinanceRegisterRecord(FinanceRegister fr) // nie dziala org.hibernate.exception.GenericJDBCException: could not insert: [backend.core.model.FinanceRegister]
    {
        Session s = sf.openSession();
        try {
            Transaction tx = s.beginTransaction();

            try {
                s.save(fr);

                tx.commit();
                return true;
            } catch (Exception e) {
            	e.printStackTrace();
                tx.rollback();
                return false;
            }
        }
        catch (Exception e){
        	e.printStackTrace();
        	return false;
        	}
        finally {
            s.close();
        }
    }
    
    public List<FinanceRegister> getFinanceRegisterRecords() // ok
    {
    	Session s = sf.openSession();
        try {

            Query q = s.createQuery("select f from FinanceRegister f");        
            List<FinanceRegister> result =q.list();
            if (result.isEmpty() || result.size()==0)
            	return null;
            return result;

        } 
        catch (Exception e){
        	e.printStackTrace();
        	return null;
        	}
        finally {
            s.close();
        }
    }
    
}
