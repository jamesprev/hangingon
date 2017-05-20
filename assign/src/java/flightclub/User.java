package flightclub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Harrison
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class User implements Serializable{

   //Need to convert this to a bean
    
    //Add all the stuff a user is meant to have including username/password
    
    private boolean isadmin;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "dob")
    private String dob;
    @XmlElement(name = "usertype")
    private String usertype;
    
    /**
     * Empty constructor to be a javabean
     * @param name
     * @param email
     * @param password
     * @param dob
     * @param usertype
     */
    public User(String name, String email, String password, String dob, String usertype) {}
    
    public boolean getIsAdmin() {
        return isadmin;
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
    
    public String getUsertype(){
        return usertype;
    }
    
    
    /**
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isadmin = isAdmin;
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
    
    /**
     * @param usertype the usertype to set
     */
        public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
