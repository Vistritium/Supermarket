/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend.core.model;

import java.util.Date;

/**
 *
 * @author Andrzej
 */
public class FinanceRegister {
    private int idFR;
    private float price;
    private Users user;
    private Date data;
    private float account;
    private String description;

    public FinanceRegister() {
    }

    public FinanceRegister(float price, Users user, Date data, float account, String description) {
        this.price = price;
        this.user = user;
        this.data = data;
        this.account = account;
        this.description = description;
    }

   

    public int getIdFR() {
        return idFR;
    }

    public void setIdFR(int idFR) {
        this.idFR = idFR;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }



    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getAccount() {
        return account;
    }

    public void setAccount(float account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
