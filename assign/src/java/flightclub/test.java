/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;

import java.io.Console;
import java.util.Scanner;

/**
 * A test class for checking individual units
 * @author Harrison
 */
public class test {
    public static void main(String[] args) { 
        
        Scanner sc = new Scanner(System.in);
        System.out.print("    Email: ");
        String email = sc.nextLine();
        Console console = System.console();
        String password = new String(console.readPassword("    Password: "));
        
        
        System.out.println();
        System.out.println("User = " + email);
        System.out.println("Pass = " + password);
    }
}
