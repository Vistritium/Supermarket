package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import backend.core.model.Products;

/**
 *
 * @author Andrzej
 */
public class WebApp {
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
}
