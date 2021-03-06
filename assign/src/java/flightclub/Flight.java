package flightclub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Holder class for all flight details
 * @author Jamie Prevedoros
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Flight implements Serializable {


    @XmlElement(name = "flightId")
    private String flightId;
    @XmlElement(name = "departure")
    private String departure;
    @XmlElement(name = "destination")
    private String destination;
    @XmlElement(name = "typeofflighte")
    private String typeofflighte;
    @XmlElement(name = "typeofflightb")
    private String typeofflightb;
    @XmlElement(name = "priceofflighte")
    private String priceofflighte;
    @XmlElement(name = "priceofflightb")
    private String priceofflightb;
    @XmlElement(name = "availableseats")
    private int availableseats;
    @XmlElement(name = "numberofcustomers")
    private int numberofcustomers;
    @XmlElement(name = "departuredate")
    private String departuredate;
    @XmlElement(name = "returndate")
    private String returndate;
    //Lists of seats
    @XmlElement(name = "flightSeatsE") //Economy class seats
    private FlightSeats flightSeatsE;
    //private ArrayList<FlightSeat> flightSeatsE;
    @XmlElement(name = "flightSeatsB") //Business class seats
    private FlightSeats flightSeatsB;
    //private ArrayList<FlightSeat> flightSeatsB = new ArrayList<FlightSeat>();

    /**
     * Empty constructor
     */
    public Flight() {
    }

    /**
     * Full constructor
     * @param flightId Unique ID for a particular flight
     * @param departure Flight departure location
     * @param destination Flight destination city
     * @param typeofflighte Economy Flight class
     * @param typeofflightb Business flight class
     * @param priceofflighte Economy Flight price
     * @param priceofflightb Business flight price
     * @param availableseats Number of seats available
     * @param numberofcustomers number of customers booked
     * @param departuredate Flight departure date
     * @param returndate Flight return date
     */
    public Flight(String flightId,
            String departure, 
            String destination, 
            String typeofflighte, 
            String priceofflighte, 
            String typeofflightb, 
            String priceofflightb, 
            int availableseats, 
            int numberofcustomers, 
            String departuredate, 
            String returndate) {
        this.flightId = flightId;
        this.departure = departure;
        this.destination = destination;
        this.typeofflighte = typeofflighte;
        this.priceofflighte = priceofflighte;
        this.typeofflightb = typeofflightb;
        this.priceofflightb = priceofflightb;
        this.availableseats = availableseats;
        this.numberofcustomers = numberofcustomers;
        this.departuredate = departuredate;
        this.returndate = returndate;
        this.flightSeatsE = new FlightSeats();
        this.flightSeatsB = new FlightSeats();
    }

    /**
     * Creates a booking and set user objects here
     * @param seatType
     * @return 
     */
    public Booking bookNextAvailableSeat(String seatType, String userEmail) {
        FlightSeat seat;
        switch(seatType) {
            case "Business":
                seat = flightSeatsB.getNextAvailableSeat();
                break;
            case "Economy":
            default:
                seat = flightSeatsE.getNextAvailableSeat();
                break;
        }
        if (seat != null) { //Found a seat, create booking and return it
            seat.createBooking(userEmail);
            availableseats--; //Update the total amount of seats available
            return new Booking(flightId, seat.getRow(), seat.getSeatNumber(), seatType);
            //TODO - set availability variable if availableseats reaches 0 zero?
        }
        //Else, couldn't find an available seat.
        return null;
    }
    
    public void cancelBooking(Booking booking) {
        //Gets seat type
        switch(booking.getSeatType()) {
            case "Business":
                flightSeatsB.cancelBooking(booking);
                break;
            case "Economy":
            default:
                flightSeatsE.cancelBooking(booking);
                break;
        }
        availableseats++;
        //TODO - set availability variable if available seats goes up to 1 or more
    }
    
    /**
     * Returns the amount of available business class seats
     * @return Number of available seats, 0 if none available
     */
    public int getNumAvailableSeatsBusiness() {
        return flightSeatsB.getNumAvailableSeats();
    }
    
    /**
     * Returns the amount of available business class seats
     * @return Number of available seats, 0 if none available
     */
    public int getNumAvailableSeatsEconomy() {
        return flightSeatsE.getNumAvailableSeats();
    }
    
    //GETTERS AND SETTERS
    public String getFlightId() {
        return flightId;
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

    public String getPriceOfFlightE() {
        return priceofflighte;
    }

    public String getTypeOfFlightE() {
        return typeofflighte;
    }

    public String getPriceOfFlightB() {
        return priceofflightb;
    }

    public String getTypeOfFlightB() {
        return typeofflightb;
    }

    public String departuredate() {
        return departuredate;
    }

    public String returndate() {
        return returndate;
    }
    
    /**
     * @param flightId 
     */
    public void setString(String flightId) {
        this.flightId = flightId;
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
     * @param typeofflight the typeofflighte to set
     */
    public void setTypeOfFlightE(String typeofflighte) {
        this.typeofflighte = typeofflighte;
    }

    /**
     * @param priceofflight the priceofflighte to set
     */
    public void setPriceOfFlightE(String priceofflighte) {
        this.priceofflighte = priceofflighte;
    }
    
        /**
     * @param typeofflight the typeofflighte to set
     */
    public void setTypeOfFlightB(String typeofflightb) {
        this.typeofflightb = typeofflightb;
    }

    /**
     * @param priceofflight the priceofflighte to set
     */
    public void setPriceOfFlightB(String priceofflightb) {
        this.priceofflightb = priceofflightb;
    }

    /**
     * @param availableseats the availableseats to set
     */
    public void setAvailableSeats(int availableseats) {
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

    
    /**
     * @return the flightSeatsE
     */
    public FlightSeats getFlightSeatsE() {
        return flightSeatsE;
    }

    /**
     * @param flightSeatsE the flightSeatsE to set
     */
    public void setFlightSeatsE(FlightSeats flightSeatsE) {
        this.flightSeatsE = flightSeatsE;
    }

    /**
     * @return the flightSeatsB
     */
    public FlightSeats getFlightSeatsB() {
        return flightSeatsB;
    }

    /**
     * @param flightSeatsB the flightSeatsB to set
     */
    public void setFlightSeatsB(FlightSeats flightSeatsB) {
        this.flightSeatsB = flightSeatsB;
    }
    
}
