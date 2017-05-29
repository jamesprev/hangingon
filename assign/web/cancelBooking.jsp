<%-- 
    Document   : cancelBooking
    Created on : 29/05/2017, 11:50:12 AM
    Author     : Harrison
--%>

<%@page import="flightclub.Booking"%>
<%@page import="flightclub.Flight"%>
<%@page import="flightclub.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% //Gets the filepath of the project for writing to flights
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
        <title>Cancel booking</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        
        <h1>Booking</h1>
        <%
            //Check if logged in
            User user = (User)session.getAttribute("user");
            
            if (user != null) { //User is logged in
                //Check if a cancel request was submitted
                String submitted = request.getParameter("submit");
                if (submitted != null && submitted.equals("Cancel Booking")) {
                    //Check that user definitely has a booking
                    Booking booking = user.getBooking();
                    if (booking != null) {
                        //Request to cancel is valid, process cancellation
                        //Get the flight and cancel the flight
                        flightApp.getFlights().findById(booking.getFlightId()).cancelBooking(booking);
                        //Get the correct user, cancel booking there too
                        user.cancelBooking();
                        //Write out to both flights.xml and users.xml
                        flightApp.writeFlightsXml();
                        userApp.writeUsersXml();
                        %><p> Booking canceled. Click <a href="main.jsp">here</a> to return to the main page.</p><%
                            
                    } else {
                        %><p>You do not have any bookings to cancel!</p> <%
                    }
                } else { 
                    %>
                    <p>Whoops, you have reached this page by mistake. Please click <a href="main.jsp">here</a> to return to the main menu.</p><%
                }
            } else {
                %><p>Please log in to make or cancel a booking.</p><%
            }
        %>
    </body>
</html>
