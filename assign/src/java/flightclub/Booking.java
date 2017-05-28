 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Holds a single booking object, with a link to the flight and seat etc
 * A single one of these is held by each user
 * @author Harrison
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Booking {
    @XmlElement(name = "flightId")
    private String flightId;
    @XmlElement(name = "row")
    private int row;
    @XmlElement(name = "seatNumber")
    private String seatNumber;
    
    public Booking(String flightId, int row, String seatNumber) {
        this.flightId = flightId;
        this.row = row;
        this.seatNumber = seatNumber;
        
    }
}
