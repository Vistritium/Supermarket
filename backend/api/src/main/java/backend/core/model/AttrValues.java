package backend.core.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Andrzej
 */
public class AttrValues {
    private int idValues;
    private String name;
    private Attributes attribute;

    public AttrValues(String name, Attributes attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public AttrValues() {
    }

    public int getIdValues() {
        return idValues;
    }

    public void setIdValues(int idValues) {
        this.idValues = idValues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Attributes getAttribute() {
        return attribute;
    }

    public void setAttribute(Attributes attribute) {
        this.attribute = attribute;
    }

    
    
}
