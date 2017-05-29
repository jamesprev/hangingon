<%-- 
    Document   : booking
    Created on : 27/05/2017, 6:11:31 PM
    Author     : Harrison
    PURPOSE : To display a single user's booking object (and the flight associated with it)
--%>
<%@page import="flightclub.Flight"%>
<%@page import="flightclub.Booking"%>
<%@page import="flightclub.User"%>
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Booking</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        
    <% //Check if user is logged in
        
    //Check if URL parameter for specific user & current user is admin
    //Otherwise get booking for the current user
    String targetUser = request.getParameter("targetUser");
    User user = (User)session.getAttribute("user");
    boolean adminMode = false;
    if (targetUser != null && user.getIsAdmin()) { //Admin wants to view booking as user
        adminMode = true;
        user = userApp.getUsers().getUser(targetUser);
        %><h1>(Admin) <%=targetUser%>'s Booking</h1><%
    } else {
        %><h1>My Booking</h1><%
    }
    
    if (user != null) {
        //Check if user has a booking
        Booking userBooking = user.getBooking();
        if (userBooking != null) { //User has a valid booking
            //Get flight from the flight app
            Flight flight = flightApp.getFlights().findById(userBooking.getFlightId());
            if (flight != null) {
    %>
                <ul>
                    <li>Flight: <%=userBooking.getFlightId()%></li>
                    <li>Seat type: <%=userBooking.getSeatType()%></li>
                    <li>Seat (row/seat): <%=userBooking.getRow()%><%=userBooking.getSeatNumber()%> </li>
                    <li>Departure (city/date): <%=flight.getDeparture()%> at <%=flight.getDepartureDate()%> to <%=flight.getDestination()%></li>
                    <li>Return from (city/date): <%=flight.getDestination()%> at <%=flight.getReturnDate()%></li>
                </ul>

                <%//TODO - add logic here to hid the button depending on the date compared to departure date
                //e.g. if currentdate < departuredate then display button
                if (adminMode) {%>
                    <p>WARNING: This will cancel a user's booking!</p>
                    <form action="cancelBooking.jsp?targetUser=<%=targetUser%>" method="post">
                        <input type="submit" name="submit" value="Cancel Booking">
                    </form>
                <%} else {%>
                    <form action="cancelBooking.jsp" method="post">
                        <input type="submit" name="submit" value="Cancel Booking">
                    </form>
                <%}%>
        <%  }
        } else { //Display no booking stuff%>
            <h3>You do not have a booking. Please go to the main page to search for a flight to book.</h3>
    <%  } 
    } else { //user is not logged in%>
        <h3>You are not logged in. Please <a href="login.jsp">login</a> first.</h3>
    <%}%>
    </body>
</html>
