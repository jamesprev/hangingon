/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;
 
import javax.xml.bind.annotation.*;
import java.util.*;
import java.io.Serializable;

/**
 *
 * @author Jamie Prevedoros
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {//Lab 5
    //Specifies a list ('element wrapper') of type ''
    //@XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    private ArrayList<User> list = new ArrayList<User>();
 
    public ArrayList<User> getList() {
        return list;
    }
    public void addUser(User user) {
        list.add(user);
    }
    public void removeUser(User user) {
        list.remove(user);
    }
    
    /**
     * Gets a specific user from the list
     * @param email the email of the user to find
     * @return The found user
     */
    public User getUser(String email)
    {
        for (User user : list) {
            if (user.getEmail().equals(email))
                return user; // Email correct. Return this user.
        }
        return null;
    }
    
    public boolean checkEmailExists(String email) {
        // For each user in the list...
        for (User user : list) {
            if (user.getEmail().equals(email))
                return true; // Login correct. Return this user.
        }
        return false; // Login incorrect. Return null.
    }
    
    public User login(String email, String password) {
        // For each user in the list...
        for (User user : list) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return user; // Login correct. Return this user.
        }
        return null; // Login incorrect. Return null.
    }
}