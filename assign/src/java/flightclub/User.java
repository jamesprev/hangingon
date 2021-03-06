package flightclub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.regex.Pattern;

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
public class User implements Serializable {

    //Need to convert this to a bean
    //Add all the stuff a user is meant to have including username/password
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "dob")
    private String dob;
    @XmlElement(name = "isAdmin")
    private boolean isAdmin;
    //Booking object
    @XmlElement(name = "booking")
    private Booking booking;

    /**
     * Empty constructor
     */
    public User() {
    }

    /**
     * Full constructor
     *
     * @param name User's name
     * @param email User's email
     * @param password User's password
     * @param dob User's date of birth
     * @param usertype
     */
    public User(String name, String email, String password, String dob, boolean isAdmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.isAdmin = isAdmin;
        this.booking = null;
    }

    //Booking management
    /**
     * Removes the booking object from this user
     */
    public void cancelBooking() {
        booking = null;
    }
    
    //Field validators
    public boolean isNameValid() {
        if (name != null && !name.isEmpty()) {
            Pattern pattern = Pattern
                    .compile("[a-zA-Z]+\\s?[a-zA-Z]+");
            return true;
        }
        return false;
    }

    public boolean isEmailValid() {
        if (email != null && !email.isEmpty()) {
            Pattern pattern = Pattern
                    .compile("[\\._a-zA-Z\\d]+@([a-zA-Z]+\\.)+[a-zA-Z]+");
                    //.compile("[^@]+@?[a-zA-Z]+\\.+[a-zA-Z]");
            //(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
            if (pattern.matcher(email).matches()) {
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordValid() {
        if (password != null && password.length() > 6) {
            return true;
        }
        return false;
    }

    public boolean isDobValid() {
        if (dob != null && !dob.isEmpty()) {
            //Check against basic date regex (verifies numbers between slashes)
            Pattern pattern = Pattern
                    .compile("[0123]?\\d\\/[01]?\\d\\/(19|20)\\d\\d");
            if (pattern.matcher(dob).matches()) {
                return true;
            }
        }
        return false;
    }

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

    /*public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin.equals("true");
    }*/
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
     * @return the booking
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * @param booking the booking to set
     */
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    
  
    
    
   }
    

