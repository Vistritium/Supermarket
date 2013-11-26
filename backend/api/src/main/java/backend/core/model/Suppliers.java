package backend.core.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Andrzej
 */
public class Suppliers {
    private int idSuppliers;
    private String name;
    private Set<Products> products = new HashSet<Products>(0);
    
    public Suppliers() {
    }

    public Suppliers(String name) {
        this.name = name;
    }
    
    
    public int getIdSuppliers() {
        return idSuppliers;
    }

    public void setIdSuppliers(int idSuppliers) {
        this.idSuppliers = idSuppliers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
    
    
}
