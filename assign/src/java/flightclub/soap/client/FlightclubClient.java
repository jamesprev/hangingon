/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub.soap.client;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class FlightclubClient {
    public FlightService_Service locator;
    public FlightService service;
    User user;
  
    public static void main(String[] args) throws Exception_Exception, IOException_Exception, JAXBException_Exception {
        FlightService_Service locator = new FlightService_Service();
        FlightService service = locator.getFlightServicePort();
        FlightclubClient client = new FlightclubClient(locator, service);
        client.runClient();
    }
    
    public FlightclubClient(FlightService_Service locator, FlightService service) {
        this.locator = locator;
        this.service = service;
    }
    
    /**
     * Gives the user a choice, runs when the user is not logged in
     */
    public void runClient() throws Exception_Exception, IOException_Exception, JAXBException_Exception {
        Scanner sc = new Scanner(System.in);
        //Check if user is null, 
        //if they are (i.e. not logged in), show basic menu
        //if they aren't (i.e. they are logged in), show full menu
        String input = "";
        do {
            System.out.println("Action (login|viewflights|exit): ");
            input = sc.nextLine();
            switch(input) {
                case "login":
                    loginUser();
                    break;
                case "viewflights": 
                    viewFlights();
                    break;
                case "exit":
                    System.out.println("Exiting client.");
                    break;
                default:
                    System.out.println("Command not recognised.");
                    break;
            }
        } while(!input.equals("exit"));
    }
    
    /**
     * Runs when the user is logged in
     */
    public void runFullClient() throws Exception_Exception, IOException_Exception, JAXBException_Exception {
        Scanner sc = new Scanner(System.in);
        //Check if user is null, 
        //if they are (i.e. not logged in), show basic menu
        //if they aren't (i.e. they are logged in), show full menu
        String input = "";
        do {
            System.out.println("Action (viewflights|bookflight|logout): ");
            input = sc.nextLine();
            switch(input) {
                case "viewflights": 
                    viewFlights();
                    break;
                case "logout":
                    logoutUser();
                    break;
                case "bookflight":
                    createBooking();
                    break;
                default:
                    System.out.println("Command not recognised.");
                    break;
            }
        } while(!input.equals("logout"));
    }
    
    /**
     * Displays help message on system .out
     */
    public void displayHelp() {
        System.out.println("Choices: ");
        System.out.println("Choices: ");
        System.out.println("Choices: ");
        System.out.println("Choices: ");
        System.out.println("Choices: ");
        System.out.println("Choices: ");
    }
    
    public void loginUser() throws Exception_Exception, IOException_Exception, JAXBException_Exception {
        user = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("    Email: ");
        String email = sc.nextLine();
        System.out.print("    Password: ");
        String password= sc.nextLine();

        user = service.userLogin(email, password); 
        if (user != null) {
            System.out.println("===========================================");
            System.out.println("Welcome, " + user.getName());
            runFullClient();
        } else {
            System.out.println("    Login failed.");
        }
    }
    
    public void logoutUser() {
        user = null;
        System.out.println("User logged out");
        System.out.println("===========================================");
    }
    
    public void viewFlights() throws Exception_Exception {
        java.util.List<Flight> flightList = new ArrayList<Flight>();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("    Use parameters?(y/n): ");
        String line = sc.nextLine();
        boolean useParams = (line.equals("y") || line.equals("yes"));
        if (useParams) {
            System.out.println("Sorry not supported from SOAP");
        } else {
            flightList = service.listFlights();
        }
        printFlights(flightList);
    }
    
    public void printFlights(java.util.List<Flight> flightList) {
        for (Flight flight : flightList) {
            System.out.println("    Flight: " + flight.getFlightId());
            System.out.println("       Departure: " + flight.getDeparturedate() + " " + flight.getDeparture());
            System.out.println("          Return: " + flight.getReturndate() + " " + flight.getDestination());
            System.out.println("           Seats: " + flight.getAvailableseats());
            System.out.println("           Price: [" + flight.getPriceofflighte() + "]Economy ; ["
                    + flight.getPriceofflightb() + "]Business");
        }
    }
    
    public void createBooking() throws Exception_Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("    Flight ID: ");
        String flightId = sc.nextLine();
        System.out.print("    Seat type(Economy|Business): ");
        String seatType = sc.nextLine();
        
        boolean isBusiness = (seatType.equals("b") || seatType.equals("Business"));
        if (isBusiness) {
            seatType = "Business";
        } else {
            seatType = "Economy";
        }
        
        User user = service.createBooking(this.user.getEmail(), flightId);
        if (user != null) {
            this.user = user;
            System.out.println("Booking created successfully");
        } else {
            System.out.println("Could not create booking.");
        }
    }
}
