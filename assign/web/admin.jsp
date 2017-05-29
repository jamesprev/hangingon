<%-- 
    Document   : admin
    Created on : 19/05/2017, 12:03:57 AM
    Author     : Harrison
--%>

<%@page import="flightclub.dom.*"%>
<%@page import="flightclub.dom.UsersPrinter.*"%>
<%@page import="flightclub.dom.UsersPrinter.Printer.*"%>
<%@page import="java.io.*"%>
<%@page import="flightclub.*"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    User sessionUser = (User)session.getAttribute("user"); 
    //If null, then don't do anything
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        
        <%if (sessionUser == null) { //User is not logged in%>
            <h1>Please log in to access this page</h1>
        <%} else {  //User is logged in%>
            <%if (!sessionUser.getIsAdmin()) { //User is not an admin%>
                <h1>Please log in with an admin account to access this page</h1>
            <%} else { //USER IS AN ADMIN, load page as usual%>
            
                <c:import url="WEB-INF/users.xml" var="xml" />
                <c:import url="bookings.xsl" var="xsl" />
                <x:transform xml="${xml}" xslt="${xsl}">
                    <%--<x:param name="departure" value="<%=departure%>"/>--%>
                </x:transform>
            
                <%
                    //DEBUGGING - prints out xml files to server log
                    Printer xml = new XMLPrinter();       
                    PrintWriter systemOut = new PrintWriter(new OutputStreamWriter(System.out), true);
                    
                    //Print flights.xml and users.xml
                    xml.print(application.getRealPath("WEB-INF/flights.xml"), systemOut);
                    xml.print(application.getRealPath("WEB-INF/users.xml"), systemOut);
                %>
                <p>Flights.xml & users.xml printed out to server log</p>
            <%}%>
        <%}%>
    </body>
</html>
