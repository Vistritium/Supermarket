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
public class Products {
    private int idProducts;
    private String name;
    private Category category;
    private int count;
    private float price;
    private int manufacturer;
    private Set<Suppliers> suppliers = new HashSet<Suppliers>(0);
    private Set<Attributes> attributes = new HashSet<Attributes>(0);
    private Set<Orders> orders = new HashSet<Orders>(0);

    public Products(String name, Category category, int count, float price, int manufacturer) {
        this.name = name;
        this.category = category;
        this.count = count;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public Products() {
    }

    public Set<Suppliers> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Suppliers> suppliers) {
        this.suppliers = suppliers;
    }

    public int getIdProducts() {
        return idProducts;
    }

    public void setIdProducts(int idProducts) {
        this.idProducts = idProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attributes> attributes) {
        this.attributes = attributes;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    
}
