/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub.soap;

import flightclub.User;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


import flightclub.Flight;
import flightclub.Flights;
/**
 *
 * @author Harrison
 */
@WebService(serviceName = "flightService")
public class flightService {
    
    @Resource
    private WebServiceContext context;
    
    private FlightApplication getFlightApp() throws Exception{
        ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            FlightApplication flightApp = (FlightApplication)application.getAttribute("flightApp");
            if (flightApp == null) {
                flightApp = new FlightApplication();
                flightApp.setFilePath(application.getRealPath("WEB-INF/flights.xml"));
                application.setAttribute("flightApp", flightApp);
            }
            return flightApp;
        }   
    } 
    

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
        return null;
    }
    
    /**
     * Returns a list of flights
     */
    @WebMethod(operationName = "listFlightsWithParams")
    public Flights listFlightsWithParams() {
        return null;
    }
}
