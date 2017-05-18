/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;

/**
 *
 * @author Andrew
 */
public class Flight {

    private int departureDate;
    private int returnDate;
    private int numofSeats;
    private int numofCustomers;
    private String flightType;
    private String city;
    
    

    public int getDepartureDate() {
        return departureDate;
    }

    public int getReturnDate() {
        return returnDate;
    }
    
    public int getNumofSeats() {
    return numofSeats;
    }
    
    public int getNumofCustomers() {
    return numofCustomers;
    }

    public String getFlightType() {
        return flightType;
    }

    public String getCity() {
    return city;
    }
  
}
