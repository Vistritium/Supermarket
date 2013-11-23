package backend.api;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import backend.core.model.Groups;
import backend.core.model.Users;

/**
 *
 * @author Andrzej
 */
public class View {
    
    public Groups checkAuthorization(String name, String Password)
    {
        Groups g = new Groups();
        return g;
    }
    
      public Users[] getUsers(int IdGroup)
    {
        Users u[] = new Users[1];
        return u;
    }
}
