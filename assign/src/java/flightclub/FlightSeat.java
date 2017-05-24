/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andrew
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "flightSeat")
public class FlightSeat {
    @XmlElement(name = "row")
    private int row; //Row in plane of seatNumber
    @XmlElement(name = "seatNumber")
    private String seatNumber; //Seat 'letter'
    @XmlElement(name = "booked")
    private boolean booked; //Whether the seat is booked or not

    /**
     * Empty constructor
     */
    public FlightSeat() { }
    
    /**
     * constructor
     */
    public FlightSeat(int row, String seatNumber) {
        this.row = row;
        this.seatNumber = seatNumber;
        this.booked = false;
    }
    
    public int getRow() {
        return row;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
    
    public boolean getBooked() {
        return booked;
    }

    public void setRow(int row) {
        this.row = row;
    }
    
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
