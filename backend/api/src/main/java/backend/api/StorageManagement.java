package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import backend.core.model.Category;
import backend.core.model.Manufacturers;
import backend.core.model.Products;

/**
 *
 * @author Andrzej
 */
public class StorageManagement {
    
    public boolean addProduct(Products p)
    {
        return true;
    }
    
    /**
     * 
     * @param id
     * @param type - "idCategory" lub "idProduct" lub "idManufacturer"
     * @return 
     */
    public Products getProduct(int id, String type) 
    {
        Products p = new Products();
        return p;
    }
    /**
     * 
     * @param id
     * @param type - "idCategory" lub "idProduct" lub "idManufacturer"
     * @return 
     */
    public Products[] getProducts(int id, String type) 
    {
        Products p[] = new Products[1];
        return p;
    }
    
    public boolean editProduct(int idProduct)
    {
        return false;
    }
    
    public boolean removeProduct(int idProduct)
    {
        return false;
    }
    
    public boolean removeCategory(int idCategory)
    {
        return false;
    }
    
    public Category getCategory(int idCategory)
    {
        Category c = new Category();
        return c;
    }
    
    public Category getCategory(String name)
    {
        Category c = new Category();
        return c;
    }
         
    public Manufacturers getManufacturer(int idManufacturer)
    {
        Manufacturers c = new Manufacturers();
        return c;
    }
    
    public Manufacturers getManufacturer(String name)
    {
        Manufacturers c = new Manufacturers();
        return c;
    }   
    
     public boolean removeManufacturer(int idManufacturer)
    {
        return false;
    }
}
