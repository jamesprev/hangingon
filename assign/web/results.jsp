<%-- 
    Document   : results
    Created on : 17/05/2017, 11:08:21 PM
    Author     : Jamie Prevedoros
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="flightclub.*"%>
<%
    String filePath = application.getRealPath("WEB-INF/flights.xml");
    session.setAttribute("returnToPage", "main.jsp");
%>
<jsp:useBean id="flightApp" class="flightclub.FlightApplication" scope="application">
    <jsp:setProperty name="flightApp" property="filePath" value="<%=filePath%>" />
</jsp:useBean>

<!--Set up for using XSLT-->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
    <head>
        <!Needs menu>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
 <jsp:include page="menu.jsp"/>
<% //Get search parameters and perform actual search
    String departure = request.getParameter("departure");
    String destination = request.getParameter("destination");
    String typeOfFlight = request.getParameter("typeOfFlight");
    String returndate = request.getParameter("returndate");
    String departuredate = request.getParameter("departuredate");
%>


<% 
    User sessionUser = (User)session.getAttribute("user"); 
%> 
    <%  boolean isLoggedIn = false;

    if (sessionUser != null)
    { isLoggedIn = true; }
 
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
    

    
    <c:import url="WEB-INF/flights.xml" var="xml" />
    <c:import url="flightSearch.xsl" var="xsl" />
    <x:transform xml="${xml}" xslt="${xsl}">
        <x:param name="departure" value="<%=departure%>"/>
        <x:param name="destination" value="<%=destination%>"/>
        <x:param name="typeOfFlight" value="<%=typeOfFlight%>"/>
        <x:param name="departureDate" value="<%=departuredate%>"/>
        <x:param name="returnDate" value="<%=returndate%>"/>
        <x:param name="isLoggedIn" value="<%=isLoggedIn%>"/>
    </x:transform>

</body>
</html>
