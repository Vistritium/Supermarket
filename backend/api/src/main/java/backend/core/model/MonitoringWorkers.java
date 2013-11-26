package backend.core.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Date;

/**
 *
 * @author Andrzej
 */
public class MonitoringWorkers {
    private int idMW;
    private Date come;
    private Date goOut;
    private Date breakBegin;
    private Date breakEnd;
    private int amountHours;

    public MonitoringWorkers() {
    }

    public MonitoringWorkers(Date come, Date goOut, Date breakBegin, Date breakEnd, int amountHours) {
        this.come = come;
        this.goOut = goOut;
        this.breakBegin = breakBegin;
        this.breakEnd = breakEnd;
        this.amountHours = amountHours;
    }

    public int getIdMW() {
        return idMW;
    }

    public void setIdMW(int idMW) {
        this.idMW = idMW;
    }

    public Date getCome() {
        return come;
    }

    public void setCome(Date come) {
        this.come = come;
    }

    public Date getGoOut() {
        return goOut;
    }

    public void setGoOut(Date goOut) {
        this.goOut = goOut;
    }

    public Date getBreakBegin() {
        return breakBegin;
    }

    public void setBreakBegin(Date breakBegin) {
        this.breakBegin = breakBegin;
    }

    public Date getBreakEnd() {
        return breakEnd;
    }

    public void setBreakEnd(Date breakEnd) {
        this.breakEnd = breakEnd;
    }

    public int getAmountHours() {
        return amountHours;
    }

    public void setAmountHours(int amountHours) {
        this.amountHours = amountHours;
    }


    
    
}
