package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import backend.core.SessionFactoryManager;
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

	private static SessionFactory sf = SessionFactoryManager.INSTANCE.getSessionFactory();

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
