<%-- 
    Document   : booking
    Created on : 19/05/2017, 12:01:31 AM
    Author     : Harrison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        
        <%
            String flightId = request.getParameter("flightId");
        %>
        
        <h1>Booking page, please implement me</h1>
        
        <h3>You are viewing Flight <%=flightId%></h3>
    </body>
</html>
