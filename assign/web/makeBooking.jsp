<%-- 
    Document   : booking
    Created on : 19/05/2017, 12:01:31 AM
    Author     : Harrison
--%>

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
        
        <%
            //Check if have created a new booking
            Booking booking = null;
            User user = (User)session.getAttribute("user");
            
            String submitted = request.getParameter("submit");
            if (submitted != null && submitted.equals("Register")) {
                //Have submitted a new flight
                String seatType = request.getParameter("typeOfFlight");
                Flight flightToBook = (Flight)session.getAttribute("flightToBook");
                
                booking = flightApp.getFlights().findById(flightToBook.getFlightId()).bookNextAvailableSeat(seatType, user.getEmail());
                
                if (booking != null) {
                    //booking is legit
                    //write out to users 
                    user.setBooking(booking);
                    flightApp.writeFlightsXml();
                    
                    //NOTE - the session user object may not be the same one in the list
                    //therefore updating the session object may not update the xml file
                    //may need to get user again from Users and then update and write out
                    Users users = userApp.getUsers();
                    //userApp.setUsers(users); //Write it back to the XML file
                    //write out to flights
                }
            }
        %>
        
        
        
        <h1>Booking</h1>
        <%if (booking != null) {%>
            <p> Booking created, click <a href="viewBooking.jsp">here</a> to view your booking </p>
        <%} else {%>
            <p> Error making your booking. Click here to return to the previous page. </p>
        <%}%>
    </body>
</html>
