/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub.soap;

import flightclub.Booking;
import flightclub.User;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


import flightclub.Flight;
import flightclub.FlightApplication;
import flightclub.Flights;
import flightclub.UserApplication;
import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBException;
/**
 *
 * @author Harrison
 */
@WebService(serviceName = "flightService")
public class FlightService {
    
    @Resource
    private WebServiceContext context;
    
    private FlightApplication getFlightApp() throws Exception{
        ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            FlightApplication flightApp = (FlightApplication)application.getAttribute("flightApp");
            if (flightApp == null) {
                flightApp = new FlightApplication();
                flightApp.readFlightsXml(application.getRealPath("WEB-INF/flights.xml"));
                application.setAttribute("flightApp", flightApp);
            }
            return flightApp;
        }
    }
    
    private UserApplication getUserApp() throws JAXBException, IOException, Exception {
        ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        synchronized (application) {
            UserApplication userApp = (UserApplication)application.getAttribute("userapp");
            if (userApp == null) {
                userApp = new UserApplication();
                userApp.setFilePath(application.getRealPath("WEB-INF/users.xml"));
                application.setAttribute("userApp", userApp);
            }
            return userApp;
        }   
    }
    
    /**
     * This is a sample web service operation
     * @return Returns user if success, null if not
     */
    @WebMethod(operationName = "userLogin")
    public User userLogin(@WebParam(name = "email") String email, 
            @WebParam(name = "password") String password) throws IOException, Exception, JAXBException {
        //login user
        User user = getUserApp().getUsers().login(email, password);
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
     * @return Full list of flight objects
     * @throws java.lang.Exception
     */
    @WebMethod(operationName = "listFlights")
    public List<Flight> listFlights() throws Exception {
        Flights flights = getFlightApp().getFlights();
        return flights.getList();
    }
    
    /**
     * Returns a list of flights
     */
    @WebMethod(operationName = "listFlightsWithParams")
    public Flights listFlightsWithParams() {
        return null;
    }
    
    /**
     * Attempts to create booking
     * @param user The user to book with
     */
    @WebMethod(operationName = "createBooking")
    public User createBooking(@WebParam(name = "user") String userEmail, @WebParam(name = "flightId") String flightId) throws Exception {
        User user = null;
        FlightApplication flightApp = getFlightApp();
        UserApplication userApp = getUserApp();
        
        Flight flightToBook = flightApp.getFlights().findById(flightId);
        Booking booking = flightToBook.bookNextAvailableSeat(flightId, flightId);
        
        //Book it on the user object
        if (booking != null) { 
            user = userApp.getUsers().getUser(userEmail);
            user.setBooking(booking);
            //Write out both the flights.xml and the users.xml with the new info
            flightApp.writeFlightsXml();
            userApp.writeUsersXml();
        }
        return user;
    }
}
