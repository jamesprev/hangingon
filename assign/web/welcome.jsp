<%-- 
    Document   : welcome
    Created on : 17/05/2017, 11:03:48 PM
    Author     : Jamie Prevedoros
    NOTE       : ALL OF THIS FUNCTIONALITY IS NOW HANDLED BY REGISTER.JSP
--%>

<%@page import="flightclub.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!Needs a menu>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>

<%
    //Refresh after 5 seconds, pulls the register details & displays in body
    //This section written by Jamie, pushed by Harry
    response.setHeader("Refresh", "5;url=main.jsp");
    String email = request.getParameter("email");
    String name = request.getParameter("name");
    String password = request.getParameter("password");
    String dob = request.getParameter("dob");
    //Admin?
    //dfsdfsdfdsfsdfdddd
%>

<body>
    <jsp:include page="menu.jsp"/>

    <%
        User user = new User(name, email, password, dob, false);
        session.setAttribute("user", user);
    %>
    <table>
        <tr><td> Welcome, <%= name%>!</td></tr>
        <tr><td> Your Email is <%= email%>.</td></tr>
        <tr><td> Your password is <%= password%>.</td></tr>
        <tr><td> Your date of birth is <%= dob%>.</td></tr>
    </table>

</body>
</html>
