<%-- 
    Document   : logout
    Created on : 29/03/2017, 11:53:19 AM
    Author     : Harrison
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% session.invalidate(); %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta HTTP-EQUIV="REFRESH" content="2; url=index.jsp">
        <title>Logged out</title>
    </head>
    <body>
        <h1>
            You have been Logged Out
        </h1>
        <h2>
            Returning to Main Page
        </h2>
    </body>
</html>
