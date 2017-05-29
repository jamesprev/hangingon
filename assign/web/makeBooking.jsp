<%-- 
    Document   : booking
    Created on : 19/05/2017, 12:01:31 AM
    Author     : Harrison
--%>

<%@page import="flightclub.Flights"%>
<%@page import="flightclub.Users"%>
<%@page import="flightclub.Booking"%>
<%@page import="flightclub.User"%>
<%@page import="flightclub.Flight"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% //Gets the filepath of the project for writing a new user
    String filePath = application.getRealPath("WEB-INF/flights.xml"); %>
<jsp:useBean id="flightApp" class="flightclub.FlightApplication" scope="application">
    <jsp:setProperty name="flightApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>
<% //Gets the filepath of the project for writing a new user
String userFilePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="userApp" class="flightclub.UserApplication" scope="application">
    <jsp:setProperty name="userApp" property="filePath" value="<%=userFilePath%>"/>
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        
        <h1>Booking</h1>
        <%
            //Check if have created a new booking
            User user = (User)session.getAttribute("user");
            
            if (user != null) {
                String submitted = request.getParameter("submit");
                if (submitted != null && submitted.equals("Book Seat")) {
                    //Check that user doesn't already have a booking (this is currently not working??)
                    if (user.getBooking() == null) {
                        //Request to book is valid, process
                        String seatType = request.getParameter("typeOfFlight");
                        Flight flightToBook = (Flight)session.getAttribute("flightToBook");
                        //Flight flight = flightApp.getFlights().findById(flightToBook.getFlightId());
                        Booking booking = flightToBook.bookNextAvailableSeat(seatType, user.getEmail());

                        if (booking != null) { //Checks if booking creation was successful
                            //Retrieve user from 'database', then set the booking object
                            //User currentUser =  userApp.getUsers().getUser(user.getEmail());
                            //TODO - test if just using the session user will still update the xml correctly
                            user.setBooking(booking);
                            //Write out both the flights.xml and the users.xml with the new info
                            flightApp.writeFlightsXml();
                            userApp.writeUsersXml();
                            %><p> Booking created, click <a href="booking.jsp">here</a> to view your booking </p><%
                        } else {
                            %><p> Booking could not be created, please try again later. </p><%
                        }
                    } else {
                        %><p>You already have a booking. Please cancel your booking before making a new booking.</p> <%
                    }
                } else { 
                    %>
                    <p>Booking failed, please try again later.</p><%
                }
            } else {
                %><p>Please log in to make a booking.</p><%
            }
        %>
    </body>
</html>
