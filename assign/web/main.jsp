<%-- 
    Document   : main
    Created on : 18/05/2017, 9:59:45 PM
    Author     : Jamie Prevedoros
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% session.setAttribute("returnToPage", "main.jsp");%>
<!--Set up for reading XML-->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<!DOCTYPE html>
<html>
<head>
        <!Needs a menu>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Flight Club</title>
</head>

<body>

    <jsp:include page="menu.jsp"/>
    <h1>Flight Club</h1>
    <h3>The first rule of Flight Club is: you do not talk about Flight Club. <br>
        The second rule of Flight Club is: you DO NOT talk about Flight Club! <br>
        Third rule of Flight Club: someone yells "stop!", goes limp, taps out, the flight is over.<br>
        Fourth rule: only two guys to a flight.</h3>
    <!Search fields:
    From one city to another
    Type of flight
    Departure Date
    Return Date>

<!Either logged in or not logged in changes outcome in RESULTS PAGE
    Logged in takes them to results - clickable to book
    Not logged in has non-clickable results and a prompt to register/login>

<form action="results.jsp" method ="post">
    <table>

        <tr><h1>Search for flight</h1></tr>
        <tr><td>Departure:<td> <input type="text" name="departure"></td></tr>
        <tr><td>Destination:<td> <input type="text" name="destination"></td></tr>
        <tr><td>Type of Flight:</td>
                     <td>Economy<input type="radio" name="typeofflighte" value="Economy"></td></tr>
        <tr><td></td><td>Business<input type="radio" name="typeofflightb" value="Business"></td></tr>
        <tr><td>Departure Date:<td> <input type="text" name="departuredate"></td></tr>
        <tr><td>Return Date:<td> <input type="text" name="returndate"></td></tr>
        <tr><td><input type="submit" value="Search"></td>
            <td><input type="button" value="Cancel" onclick=""></td></tr>
    </table>
</form>

        <br><br>

        <c:import url="WEB-INF/flights.xml" var="xml" />
        <c:import url="flights.xsl" var="xsl" />
        <x:transform xml="${xml}" xslt="${xsl}" />

    </body>
    
    </html>
<!--
<td>Departure: 
<td><select name="departure">
        <option value="any"> Any
        <option value="sydney"> Sydney
        <option value="melbourne"> Melbourne
        <option value="brisbane"> Brisbane   
    </select>
</td>

<tr><td>Destination 
    <td><select name="destination">
            <option value="any"> Any
            <option value="sydney"> Sydney
            <option value="melbourne"> Melbourne
            <option value="brisbane"> Brisbane   
        </select>
    </td>
</tr>
<tr><td>Type of Flight: 
    <td><select name="typeofflight">
            <option value="any"> Choose a Flight Type
            <option value="economy"> Economy
            <option value="business"> Business
            <option value="first"> First Class   
        </select>
    </td>
</tr>
<tr><td>Departure Date: 
    <td><select name="departuredate">
            <option value="any"> Any
            <option value="01/06/17"> 01/06/17
            <option value="02/06/17"> 02/06/17
            <option value="03/06/17"> 03/06/17   
        </select>
    </td>
</tr>
<tr><td>Return Date: 
    <td><select name="returndate">
            <option value="any"> Any
            <option value="04/06/17"> 04/06/17
            <option value="05/06/17"> 05/06/17
            <option value="06/06/17"> 06/06/17   
        </select>
    </td>
</tr>
-->







