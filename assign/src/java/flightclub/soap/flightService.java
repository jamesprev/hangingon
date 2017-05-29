/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub.soap;

import flightclub.Flights;
import flightclub.User;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Harrison
 */
@WebService(serviceName = "flightService")
public class flightService {

    /**
     * This is a sample web service operation
     * @return Returns user if success, null if not
     */
    @WebMethod(operationName = "userLogin")
    public User userLogin(@WebParam(name = "email") String email, 
            @WebParam(name = "password") String password) {
        //login user
        User user = userApp.getUsers().login(email, password);
        return user;
    }
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "userLogout")
    public void userLogout() {
        //Invalidate user object??
    }
    
    /**
     * Returns a list of flights
     */
    @WebMethod(operationName = "listFlights")
    public Flights listFlights() {
        
        return flights;
    }
}
