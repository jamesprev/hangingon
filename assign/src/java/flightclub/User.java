package flightclub;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Harrison
 */
public class User {
   //Need to convert this to a bean
    
    //Add all the stuff a user is meant to have including username/password
    
    private boolean isAdmin;
    private String username;
    private String email;
    private String password;
    
    /**
     * Empty constructor to be a javabean
     */
    public User() {}
    
    public boolean getIsAdmin() {
        return isAdmin;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
}
