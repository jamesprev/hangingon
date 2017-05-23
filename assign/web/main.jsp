<%-- 
    Document   : main
    Created on : 18/05/2017, 9:59:45 PM
    Author     : Harrison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.setAttribute("returnToPage", "main.jsp");%>
<!DOCTYPE html>
<html>
    <head>
        <!Needs a menu>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FlightClub</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        
        <!Search fields:
            From one city to another
            Type of flight
            Departure Date
            Return Date>
    
        <!Either logged in or not logged in changes outcome in RESULTS PAGE
            Logged in takes them to results - clickable to book
            Not logged in has non-clickable results and a prompt to register/login>
    
        <h1>FlightClub</h1>
        <h3>The first rule of Fight Club is: you do not talk about Fight Club. 
            The second rule of Fight Club is: you DO NOT talk about Fight Club! 
            Third rule of Fight Club: someone yells "stop!", goes limp, taps out, the fight is over.
            Fourth rule: only two guys to a fight.</h3>
    </body>
</html>
