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
     * Gives the user a choice
     */
    public void runClient() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Action (login|viewflights|exit) :");
        String input = "";
        do {
            input = sc.nextLine();
            switch(input) {
                case "exit":
                    System.out.println("Exiting client.");
                    break;
            }
        } while(!input.equals("exit"));
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
