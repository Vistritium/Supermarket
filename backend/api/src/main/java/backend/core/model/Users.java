package backend.core.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Andrzej
 */


public class Users {
    
    private int idusers;
    private String name;
    private String surname;
    private String password;
    private String salt;
    private Date hired;
    private Date last_login;
    private Set<Groups> groups = new HashSet<Groups>(0);

    public Users(String name, String surname, String password, String salt, Date hired, Date last_login) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.salt = salt;
        this.hired = hired;
        this.last_login = last_login;
    }

    public Users() {
    }

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getHired() {
        return hired;
    }

    public void setHired(Date hired) {
        this.hired = hired;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Set<Groups> getGroups() {
        return groups;
    }

    public void setGroups(Set<Groups> groups) {
        this.groups = groups;
    }


    @Override
    public String toString() {
        return "user{" + "id=" + idusers + ", grupa=" + groups + ", imie=" + name + '}';
    }
    
}
