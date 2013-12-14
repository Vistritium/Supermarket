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
public class Attributes {
    private int idAttributes;
    private String name;
    private Set<Products> products = new HashSet<Products>(0);
    private Set<AttrValues> values = new HashSet<AttrValues>(0);
    private Set<Category> category = new HashSet<Category>(0);

    public Attributes(String name) {
        this.name = name;
    }

    
    public int getIdAttributes() {
        return idAttributes;
    }

    public void setIdAttributes(int idAttributes) {
        this.idAttributes = idAttributes;
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


    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public Set<AttrValues> getValues() {
        return values;
    }

    public void setValues(Set<AttrValues> values) {
        this.values = values;
    }


	@Override
	public String toString() {
		return "Attributes [idAttributes=" + idAttributes + ", name=" + name
				+ ", products=" + products + ", values=" + values
				+ ", category=" + category + "]";
	}

  
    
}
