<%-- 
    Document   : menu
    Created on : 18/05/2017, 10:43:36 PM
    Author     : Harrison
--%>

<%@page import="flightclub.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    User sessionUser = (User)session.getAttribute("user"); 
    //If null, then don't do anything
    %>
<%//User has logged in
        if (sessionUser != null) { %>
        <div style="background: #eee; border: solid 1px #333; text-align: right; width: 100%;">
            You are logged in as <%= sessionUser.getName() %> &#60;<%=sessionUser.getEmail()%>&#62;
        </div>
        <div style='text-align: right;'>
            <a href="logout.jsp">Logout</a>
        </div>
<%}%>