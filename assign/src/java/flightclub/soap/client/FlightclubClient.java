/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub.soap.client;

import java.io.Console;
import java.util.Scanner;

/**
 *
 * @author Harrison
 */
public class FlightclubClient {
    public FlightService_Service locator;
    public FlightService service;
    User user;
  
    public static void main(String[] args) {
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
    public void runClient() {
        Scanner sc = new Scanner(System.in);
        //Check if user is null, 
        //if they are (i.e. not logged in), show basic menu
        //if they aren't (i.e. they are logged in), show full menu
        System.out.println("Action (login|viewflights|exit): ");
        String input = "";
        do {
            input = sc.nextLine();
            switch(input) {
                default:
                case "login":
                    loginUser();
                    break;
                case "viewflights": 
                    break;
                case "exit":
                    System.out.println("Exiting client.");
                    break;
            }
        } while(!input.equals("exit"));
    }
    
    /**
     * Runs when the user is logged in
     */
    public void runFullClient() {
        
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
    
    public void loginUser() {
        user = null;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("    Email: ");
            String input = sc.nextLine();
            
            Console console = System.console();

            password = new String(console.readPassword("    Password: "));
            
            user = service.login(input); 
            if (user != null) {
                System.out.println("Found " + user.getName());
            } else {
                System.out.println("No such user found.");
            }
        } while (user != null);
    }
    
    public void viewFlights() {
        System.out.println("    Implement me!");
    }
}
