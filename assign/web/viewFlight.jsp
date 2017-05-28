<%-- 
    Document   : viewBooking
    Created on : 25/05/2017, 1:59:47 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="flightclub.Flight"%>
<%@page import="flightclub.Flights"%>
<%
    //Allows the user to view a particular flight and book it.
	String filePath = application.getRealPath("WEB-INF/flights.xml");
%>
<jsp:useBean id="flightApp" class="flightclub.FlightApplication"
	scope="application">
	<jsp:setProperty name="flightApp" property="filePath"
		value="<%=filePath%>" />
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Booking</title>
    </head>
    <body>
        <h1>Your booking</h1>
        <%
            String flightId = request.getParameter("flightId");
            flightApp.readFlightsXml(filePath);  
            Flights flights = flightApp.getFlights();
            Flight flight = flights.findById(flightId);
         //session.setAttribute("flight", flight);
         //Attempt to add something to the post request
         //request.setAttribute("flight", flight);
        %>
        
        
        <h2>Flight details</h2>
        
        <ul>
            <li>Flight: <%=flight.getFlightId()%></li>
            <li>Departing from: <%=flight.getDeparture()%></li>
            <li>Flying to: <%=flight.getDestination()%></li>
            <li>Returning on: <%=flight.getReturnDate()%></li>
            <li>Available seats: <%=flight.getAvailableSeats()%></li>
        </ul>
        
        <%--IF USER HAS NOT ALREADY BOOKED A FLIGHT:--%>
        <form action="makeBooking.jsp" method ="post">
            <% session.setAttribute("flightToBook", flight); %>
            <input type="radio" name="typeOfFlight" value="Economy">Economy<br>
            <input type="radio" name="typeOfFlight" value="Business">Business<br>
            <input type="submit" name="submit" value="Book Seat">
        </form>
        
    </body>
</html>
