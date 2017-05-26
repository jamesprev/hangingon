<%-- 
    Document   : viewBooking
    Created on : 25/05/2017, 1:59:47 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="flightclub.Flight"%>
<%@page import="flightclub.Flights"%>
<%
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
           Flights flights = flightApp.getFlights();  
        Flight flight = flights.findById(request.getParameter("id"));
         session.setAttribute("flight", flight);
        %>
        
      
        
        
    </body>
</html>
