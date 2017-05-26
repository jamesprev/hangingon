<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : flights.xsl
    Created on : 23 May 2017, 11:06 PM
    Author     : Jamie Prevedoros
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    
    <!--PARAMETERS FOR USE WITHIN STYLESHEET (for search mainly)-->
    <xsl:param name="departure"/>
    <xsl:param name="destination"/>
    <xsl:param name="typeOfFlight"/>
    <xsl:param name="departureDate"/>
    <xsl:param name="returnDate"/>
    
    <xsl:template match="/flights">
        <style>
            table.flightlist { border: solid 1px black; border-collapse: collapse; }
            table.flightlist th { background: #333333; color: white; padding: 8px; border: solid 1px #999999;}
            table.flightlist tr:nth-child(2) { background: #ffffff;}
            table.flightlist td { border: solid 1px #999; }
            .artist { font-style: italic; margin-bottom: 20px;}
        </style>
        
        <h1>You searched for: <xsl:value-of select="$destination"/></h1>
        <table class="flightlist">
            <thead>
                <tr>
                    <th>Departure City</th>
                    <th>Destination City</th>
                    <th>Type of Flight</th>
                    <th>Price of Flight</th>
                    <th>Type of Flight</th>
                    <th>Price of Flight</th>
                    <th>Available Seats</th>
                    <th>Departure Date </th>
                    <th>Return Date</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
    </xsl:template>

    <xsl:template match="flights/flight">
        <!--Apply style & write out row-->
        
        <!--Check destination-->
        <xsl:if test="($destination = '' or destination = $destination)
                    and ($departure = '' or departure = $departure)
                    and ($typeOfFlight = 'Either' or typeofflighte = $typeOfFlight or typeofflightb = $typeOfFlight)
                    and ($departureDate = '' or departuredate = $departureDate)
                    and ($returnDate = '' or returndate = $returnDate)">
            <tr>
                <xsl:apply-templates/>
                <td>
                    <a href="booking.jsp?flightId={flightId}">BOOK NOW</a>
                </td>
            </tr>
        </xsl:if>
    </xsl:template>

    <!--Match each individual flight-->
    <xsl:template match="flights/flight/departure|destination|typeofflighte|priceofflighte|typeofflightb|priceofflightb|availableseats|departuredate|returndate">
            <td>
                <xsl:apply-templates/>
            </td>
    </xsl:template>
    
    <!--Hide other elements that we don't want shown to the user-->
    <xsl:template match="flightId"/>
    
    <xsl:template match="flights/flight/flightSeatsE|flightSeatsB">
        <!--Shows how many seats are left on each one?-->
        
    </xsl:template>
    
</xsl:stylesheet>
