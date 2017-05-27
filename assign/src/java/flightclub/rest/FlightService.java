/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub.rest;

import flightclub.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import java.io.*;
import javax.servlet.ServletContext;

/**
 *
 * @author Jamie Prevedoros
 */
@Path("/flight")
public class FlightService {
    @Context
    private ServletContext application;
    
    private FlightApplication getFlightApp() throws JAXBException, IOException, Exception {
        synchronized (application) {
            FlightApplication flightApp = (FlightApplication)application.getAttribute("flightApp");
            if (flightApp == null) {
                flightApp = new FlightApplication();
                flightApp.readFlightsXml(application.getRealPath("WEB-INF/users.xml"));
                application.setAttribute("flightApp", flightApp);
            }
            return flightApp;
        }   
    }
    
    /*
    private UserApplication getUserApp() throws JAXBException, IOException, Exception {
        synchronized (application) {
            UserApplication userApp = (UserApplication)application.getAttribute("userApp");
            if (flightApp == null) {
                flightApp = new FlightApplication();
                flightApp.readFlightsXml(application.getRealPath("WEB-INF/users.xml"));
                application.setAttribute("flightApp", flightApp);
            }
            return diaryApp;
        }   
    }*/
    /*
    @GET
    @Path("user")
    @Produces(MediaType.TEXT_PLAIN)
    public CustomerResults customerResults(@PathParam("email") String email) throws IOException, Exception{
        User user = getUserApp().getUsers().getUser(email);
        return user;
    }*/
    
    @GET
    @Path("customers")
    @Produces(MediaType.TEXT_PLAIN)
    public CustomerResults customerResults(@PathParam("email") String email) throws IOException, Exception{ /*needs to return a type of some sort*/
        return null;
    }
    
    @GET
    @Path("numofseats")
    @Produces(MediaType.TEXT_PLAIN)
    public SeatResults seatResults(@QueryParam("numofseats") int seats){
        return null;
    }
            
    @GET
    @Path("numofflights")
    @Produces(MediaType.TEXT_PLAIN)
    public FlightResults flightResults(@QueryParam("numofflights") int flights){
        return null;
    }
}
