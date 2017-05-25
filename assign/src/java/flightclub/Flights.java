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

    public Flight search(String departure, String destination, String typeOfFlight, String departuredate, String returndate) {
        // For each flight in the list...
        for (Flight flight : list) {
            if ((departure.equals("") || flight.getDeparture().equals(departure))//checks if departure field matches existing flights or is blank.
                    && (destination.equals("") || flight.getDestination().equals(destination))//checks if destination field matches existing flights or is blank.
                    && (typeOfFlight.equals("Either") || flight.getTypeOfFlightE().equals(typeOfFlight) || flight.getTypeOfFlightB().equals(typeOfFlight))//checks which radio button was selected
                    && (departuredate.equals("") || flight.getDepartureDate().equals(departuredate)) //checks if departure field matches existing flights or is blank.
                    && (returndate.equals("") || flight.getReturnDate().equals(returndate)) //checks if return field matches existing flights or is blank.
                    ) {
                return flight; //Search matches a flight, return the flight
            }     
        } 
        return null; //Search matches no flight, return null. ==IS THIS IN THE RIGHT SPOT?==
    }
}
