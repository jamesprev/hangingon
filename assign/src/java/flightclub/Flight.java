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

    private int departureDate, returnDate, returnTime, departureTime, numofSeats, numofCustomers, flightPrice;
    private String flightType, city;

    public int getDepartureDate() {
        return departureDate;
    }

    public int getReturnDate() {
        return returnDate;
    }

    public int getReturnTime() {
        return returnTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getNumofSeats() {
        return numofSeats;
    }

    public int getNumofCustomers() {
        return numofCustomers;
    }

    public int getFlightPrice() {
        return flightPrice;

    }

    public String getFlightType() {
        return flightType;
    }

    public String getCity() {
        return city;
    }

}
