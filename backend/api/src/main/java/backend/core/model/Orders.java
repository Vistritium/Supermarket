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
public class Orders {
    private int idOrders;
    private int productCount;
    private Date date;
    private int sold;
    private Products product;
    private Users user;

    public Orders(int productCount, Date date, int sold, Products product, Users user) {
        this.productCount = productCount;
        this.date = date;
        this.sold = sold;
        this.product = product;
        this.user = user;
    }

  

    public int getIdOrders() {
        return idOrders ;
    }

    public void setIdOrders(int idOrders) {
        this.idOrders = idOrders;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }



    


    
}
