package flightclub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jamie Prevedoros
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Flight implements Serializable {

    @XmlElement(name = "departure")
    private String departure;
    @XmlElement(name = "destination")
    private String destination;
    @XmlElement(name = "typeofflight")
    private String typeofflight;
    @XmlElement(name = "priceofflight")
    private String priceofflight;
    @XmlElement(name = "availableseats")
    private int availableseats;
    @XmlElement(name = "numberofcustomers")
    private int numberofcustomers;
    @XmlElement(name = "departuredate")
    private String departuredate;
    @XmlElement(name = "returndate")
    private String returndate;

    /**
     * Empty constructor
     */
    public Flight() {
    }

    /**
     * Full constructor
     *
     * @param departure Flight departure location
     * @param destination Flight destination city
     * @param typeofflight Flight class
     * @param priceofflight Flight price
     * @param availableseats Number of seats available
     * @param numberofcustomers number of customers booked
     * @param departuredate Flight departure date
     * @param returndate Flight return date
     */
    public Flight(String departure, String destination, String typeofflight, String priceofflight, int availableseats, int numberofcustomers, String departuredate, String returndate) {
        this.departure = departure;
        this.destination = destination;
        this.typeofflight = typeofflight;
        this.priceofflight = priceofflight;
        this.availableseats = availableseats;
        this.numberofcustomers = numberofcustomers;
        this.departuredate = departuredate;
        this.returndate = returndate;
        //d
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureDate() {
        return departuredate;
    }

    public String getReturnDate() {
        return returndate;
    }

    public int getAvailableSeats() {
        return availableseats;
    }

    public int getNumberofCustomers() {
        return numberofcustomers;
    }

    public String getPriceOfFlight() {
        return priceofflight;

    }

    public String getTypeOfFlight() {
        return typeofflight;
    }

    public String departuredate() {
        return departuredate;
    }

    public String returndate() {
        return returndate;
    }

    /**
     * @param departure the departure to set
     */
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @param typeofflight the typeofflight to set
     */
    public void setTypeOfFlight(String typeofflight) {
        this.typeofflight = typeofflight;
    }

    /**
     * @param priceofflight the priceofflight to set
     */
    public void setPriceofflight(String priceofflight) {
        this.priceofflight = priceofflight;
    }

    /**
     * @param availableseats the availableseats to set
     */
    public void SetAvailableSeats(int availableseats) {
        this.availableseats = availableseats;
    }

    /**
     * @param numberofcustomers the numberofcustomers to set
     */
    public void setNumberOfCustomers(int numberofcustomers) {
        this.numberofcustomers = numberofcustomers;
    }

    /**
     * @param departuredate the departuredate to set
     */
    public void setDepartureDate(String departuredate) {
        this.departuredate = departuredate;
    }

    /**
     * @param returndate the returndate to set
     */
    public void setReturnDate(String returndate) {
        this.returndate = returndate;
    }

}
