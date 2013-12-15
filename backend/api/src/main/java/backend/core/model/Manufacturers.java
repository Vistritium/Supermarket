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
public class Manufacturers {
    private int idManufacturer;
    private String name;

    public Manufacturers() {
    }

    public Manufacturers(String name) {
        this.name = name;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Manufacturers [idManufacturer=" + idManufacturer + ", name="
				+ name + "]";
	}
    
    
}
