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
@XmlRootElement(name = "flights")
public class Flights implements Serializable {//Lab 5

    //hi
    @XmlElement(name = "flight")
    private ArrayList<Flight> list = new ArrayList<Flight>();

    public ArrayList<Flight> getList() {
        return list;
    }

    public void addFlight(Flight flight) {
        list.add(flight);
    }

    public void removeFlight(Flight flight) {
        list.remove(flight);
    }

    public Flight getFlight(String departure, String destination, String typeofflighte, String typeofflightb, String priceofflight, int availableseats, int numberofcustomers, String returndate, String departuredate) {
        for (Flight flight : list) {
            if (flight.getDestination().equals(destination)) { //JUST TEMP UNTIL WE FIGURE OUT WHAT WE WANT TO DO WITH THIS
                return flight; // Email correct. Return this user.
            }
        }
        return null;
    }

    public Flight search(String departure, String destination, String typeofflight, String returndate, String departuredate) {
        // For each user in the list...
        for (Flight flight : list) {
            if (flight.getDeparture().equals("") || flight.getDeparture().equals("departure")
                    && flight.getDestination().equals("") || flight.getDestination().equals("destination")
                    && (flight.getTypeOfFlightE().equals("") || flight.getTypeOfFlightE().equals("typeofflighte")
                    || flight.getTypeOfFlightB().equals("") || flight.getTypeOfFlightB().equals("typeofflightb"))
                    && flight.getDepartureDate().equals("") || flight.getDepartureDate().equals("departuredate")
                    && flight.getReturnDate().equals("") || flight.getReturnDate().equals("returndate")
                    ) {
                
            }
            
                return flight; // Login correct. Return this user.
        }
        return null; // Login incorrect. Return null.
    }
}
