/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harrison
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class FlightSeats implements Serializable {
    @XmlElement(name = "flightSeat")
    private ArrayList<FlightSeat> list = new ArrayList<FlightSeat>();
    
    /**
     * Empty constructor
     */
    public FlightSeats() {
    }
    
    public FlightSeats(ArrayList<FlightSeat> list) {
        this.list = list;
    }
    
    /**
     * Loops over the list of flight seats and returns the first available
     * @param seatList 
     * @return Null if none found, a flight seat
     */
    public FlightSeat getNextAvailableSeat() {
        for (FlightSeat seat : list) {
            if (!seat.getBooked()) {
                return seat;
            }
        }
        return null;
    }
    
    /**
     * Cancels a given booking
     * @param booking 
     */
    public void cancelBooking(Booking booking) {
        //Get the correct seat
        FlightSeat seat = getSeat(booking.getRow(), booking.getSeatNumber());
        if (seat != null) { //Seat found, process cancellation
            seat.cancelBooking();
        }
    }
    
    private FlightSeat getSeat(int row, String seatNumber) {
        for (FlightSeat seat : list) {
            if (seat.getRow() == row && seat.getSeatNumber().equals(seatNumber)) {
                return seat;
            }
        }
        return null;
    }
    
    public int getNumAvailableSeats() {
        int numOfSeats = 0;
        for(FlightSeat seat : list) {
            if (!seat.isBooked()) {
                numOfSeats++;
            }
        }
        return numOfSeats;
    }
    
    public void addFlightSeat(FlightSeat seat) {
        list.add(seat);
    }
    
    /**
     * @return the list
     */
    public ArrayList<FlightSeat> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<FlightSeat> list) {
        this.list = list;
    }
}
