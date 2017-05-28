 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Holds a single booking object, with a link to the flight and seat etc
 * A single one of these is held by each user
 * @author Harrison
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Booking implements Serializable {
    @XmlElement(name = "flightId")
    private String flightId;
    @XmlElement(name = "row")
    private int row;
    @XmlElement(name = "seatNumber")
    private String seatNumber;
    @XmlElement(name = "seatType")
    private String seatType;
    
    public Booking(String flightId, int row, String seatNumber, String seatType) {
        this.flightId = flightId;
        this.row = row;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }
    
    public Booking() {
        
    }

    /**
     * @return the flightId
     */
    public String getFlightId() {
        return flightId;
    }

    /**
     * @param flightId the flightId to set
     */
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the seatNumber
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * @param seatNumber the seatNumber to set
     */
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * @return the seatType
     */
    public String getSeatType() {
        return seatType;
    }

    /**
     * @param seatType the seatType to set
     */
    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}
