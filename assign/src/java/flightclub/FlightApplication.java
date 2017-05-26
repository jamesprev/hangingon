/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;

import java.io.*;
import javax.xml.bind.*;
/**
 *
 * @author Andrew
 */

public class FlightApplication implements Serializable{
    private String filePath;
    private Flights flights;
    
   
    public FlightApplication() {
        
    }

   
    public String getFilePath() {
        return filePath;
    }
    
  

    
    public void setFilePath(String filePath) throws Exception{
        this.filePath = filePath;
        // Create the unmarshaller
        JAXBContext jc = JAXBContext.newInstance(Flights.class);
        Unmarshaller u = jc.createUnmarshaller();

        // Now unmarshal the object from the file
        FileInputStream fin = new FileInputStream(filePath);
        flights = (Flights)u.unmarshal(fin); // This loads the "shop" object
        fin.close();
    }

 
    public Flights getFlights() {
        return flights;
    }    
    
    
}
