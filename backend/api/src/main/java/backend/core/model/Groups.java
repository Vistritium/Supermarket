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
public class Groups {
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idgroups;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Groups other = (Groups) obj;
		if (idgroups != other.idgroups)
			return false;
		return true;
	}

	private int idgroups;
	private String name;
    private String description;
    private float salary;
    private Set<Users> Users = new HashSet<Users>(0);

    public Groups(String name, String description, float salary) {
        this.name = name;
        this.description = description;
        this.salary = salary;
    }

    public Groups() {
        //throw new UnsupportedOperationException("trololo."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdgroups() {
        return idgroups;
    }

    public void setIdgroups(int idgroups) {
        this.idgroups = idgroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Set<Users> getUsers() {
        return Users;
    }

    public void setUsers(Set<Users> Users) {
        this.Users = Users;
    }

	@Override
	public String toString() {
		return "Groups [idgroups=" + idgroups + ", name=" + name
				+ ", description=" + description + ", salary=" + salary + "]";
	}



}
