/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightclub;

/**
 * A test class for checking individual units
 * @author Harrison
 */
public class test {
    public static void main(String[] args) { 
        //Make a new array of size 2
        String[] stringArray = new String[5];
        //Populate the array with some strings
        stringArray[0] = "String1";
        stringArray[1] = "String2";
        stringArray[2] = "String3";
        stringArray[3] = "String4";
        stringArray[4] = "String5";

        /*
        for (int i = 0; i < stringArray.length; i++) {
            //Do something with each list item
            String listEntry = stringArray[i];
            System.out.println(listEntry);
        }*/
        
        //for each string (currentString) in the list stringArray, do some stuff
        
        //for each 
        for (String currentString : stringArray) {
            System.out.println(currentString); 
        }
    }
}
