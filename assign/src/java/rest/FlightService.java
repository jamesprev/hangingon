/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

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
    public Flight flight (/*QueryParam for customer name & numofseats & numofflights & numofcustomers*/) {
        return "Hello World";
    }
}
