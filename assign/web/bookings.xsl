<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : bookings.xsl
    Created on : 29 May 2017, 1:45 PM
    Author     : Harrison
    Description:
        Transforms users.xml into a readable bookings system
        Also has lookups into Flights for more details
        FOR 'ADMIN' USERS ONLY
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    
    <xsl:template match="users">
        <style>
            table.booklist { border: solid 1px black; border-collapse: collapse; }
            table.booklist th { background: #333333; color: white; padding: 8px; border: solid 1px #999999;}
            table.booklist tr:nth-child(2) { background: #ffffff;}
            table.booklist td { border: solid 1px #999; }
            .artist { font-style: italic; margin-bottom: 20px;}
        </style>
        
        <table class="booklist">
            <thead>
                <tr>
                    <th>User</th>
                    <th>Name</th>
                    <th>Flight ID</th>
                    <th>Row</th>
                    <th>Seat</th>
                    <th>Seat Type</th>
                    <th>View booking</th>
                </tr>
            </thead>
            <tbody>
                <xsl:apply-templates/>
            </tbody>
        </table>
        <br/>
    </xsl:template>

    <xsl:template match="users/user">
        <!--Apply style & write out row-->
        <xsl:variable name="targetUser" select="email">
        </xsl:variable>
        <form action="booking.jsp?targetUser={email}" method="post">
            <tr>
                <xsl:apply-templates/>
            </tr>
        </form>
    </xsl:template>
    
    <xsl:template match="user/email|name|flightId|row|seatNumber">
            <td>
                <xsl:apply-templates/>
            </td>
    </xsl:template>
    
    <xsl:template match="seatType">
            <td>
                <xsl:apply-templates/>
            </td>
            <td>
                <input type="submit" name="submit" value="View Booking"/>
            </td>
    </xsl:template>
    
    <!--Hide other elements that we don't want shown to the user-->
    <xsl:template match="password|dob|isAdmin"/>
    
</xsl:stylesheet>
