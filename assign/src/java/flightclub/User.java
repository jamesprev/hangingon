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
    private String name;
    private String email;
    private String password;
    private String dob;
    
    
    /**
     * Empty constructor to be a javabean
     */
    public User() {}
    
    public boolean getIsAdmin() {
        return isAdmin;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getDob() {
        return dob;
    }
    
    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }
}
