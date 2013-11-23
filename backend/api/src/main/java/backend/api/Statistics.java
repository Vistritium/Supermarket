package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import backend.core.model.Monitoring;
import backend.core.model.MonitoringWorkers;

/**
 *
 * @author Andrzej
 */
public class Statistics {
    
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
}
