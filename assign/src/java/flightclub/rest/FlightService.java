/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub.rest;

import flightclub.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author Jamie Prevedoros
 */
@Path("/flight")
public class FlightService {

    @Path("hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public FlightResults/*needs to return a type of some sort*/ flight (@QueryParam("username") String email, 
            @QueryParam("numofseats") int seats, 
            @QueryParam("numofflights") int flights
    /*QueryParam for customer name & numofseats & numofflights*/) {
        return null;
    }
}
