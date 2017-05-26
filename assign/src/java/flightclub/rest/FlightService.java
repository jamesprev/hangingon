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

    @Path("customers")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CustomerResults/*needs to return a type of some sort*/ customerResults(@QueryParam("username") String email){
        return null;
    }
    
    @Path("numofseats")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public SeatResults seatResults(@QueryParam("numofseats") int seats){
        return null;
    }
            
    @Path("numofseats")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public FlightResults flightResults(@QueryParam("numofflights") int flights){
        return null;
    }
}
