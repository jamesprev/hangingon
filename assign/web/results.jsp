<%-- 
    Document   : results
    Created on : 17/05/2017, 11:08:21 PM
    Author     : Jamie Prevedoros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="flightclub.*"%>
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
        <!Needs menu>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<% //Get search parameters and perform actual search
    String departure = request.getParameter("departure");
    String destination = request.getParameter("destination");
    String typeOfFlight = request.getParameter("typeOfFlight");
    String returndate = request.getParameter("returndate");
    String departuredate = request.getParameter("departuredate");

    //for list of flight?
    Flight flight;
    flight = flightApp.getFlights().search(departure, destination, typeOfFlight, departuredate, returndate);
    if (flight != null) {
        //add each flight + elements to a list and display on results 
        session.setAttribute("flight", flight);
    }

%>

<body>
<h1>Results</h1>
<!Results from main page search are dispayed
    Following info on resulting flights is displayed:
    Flight departure & return date/time
    Price
    Available seats
    Origin & Destination
    Flight type
    Flight status: (Seats available/unavailable)

    Logged in or not logged in:
    Logged in takes them to results - clickable to book
    Not logged in has non-clickable results and a prompt to register/login
    The ability to "create and close a flight listing">
    <h3>You searched for:</h3>
    <ul>
        <li>Departure: <%=departure%></li>
        <li>Destination: <%=destination%></li>
        <li>Type of Flight: <%=typeOfFlight%></li>
        <li>Return date: <%=returndate%></li>
        <li>Departure date: <%=departuredate%></li>
    </ul>

</body>
</html>
