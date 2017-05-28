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
                flightApp.setFilePath(application.getRealPath("WEB-INF/flights.xml"));
                application.setAttribute("flightApp", flightApp);
            }
            return flightApp;
        }   
    }
    
        private UserApplication getUserApp() throws JAXBException, IOException, Exception {
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

    @GET
    @Path("flight")
    @Produces(MediaType.TEXT_PLAIN)
    public Flights getFlights() throws IOException, Exception{
        return getFlightApp().getFlights();
    }
    
//    @GET
//    @Path("flight/{customers}")
//    @Produces(MediaType.APPLICATION_XML)
//    public Flight getUserFlights(@PathParam("email") String email) throws IOException, Exception{ /*needs to return a type of some sort*/
//        return null;
//    }
    
    @GET
    @Path("flight/{numofseats}")
    @Produces(MediaType.APPLICATION_XML)
    public Flight getSeatFlights(@QueryParam("numofseats") int seats) throws IOException, Exception{
        Flight flight = getFlightApp().getFlights().getSeatFlights(seats);
        return flight;
    }
            
    @GET
    @Path("flight/{numofflights}")
    @Produces(MediaType.APPLICATION_ATOM_XML)
    public FlightResults flightResults(@QueryParam("numofflights") int flights){
        return null;
    }
}
