<%-- 
    Document   : admin
    Created on : 19/05/2017, 12:03:57 AM
    Author     : Harrison
--%>

<%@page import="flightclub.User"%>
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
        
        
        <%if (sessionUser == null) { //User is not logged in%>
            <h1>Please log in to access this page</h1>
        <%} else {  //User is logged in%>
            <%if (!sessionUser.getIsAdmin()) { //User is not an admin%>
                <h1>Please log in with an admin account to access this page</h1>
            <%} else { //USER IS AN ADMIN, load page as usual%>
                
            <%}%>
        <%}%>
    </body>
</html>
