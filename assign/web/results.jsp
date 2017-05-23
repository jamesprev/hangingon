<%-- 
    Document   : results
    Created on : 17/05/2017, 11:08:21 PM
    Author     : Jamie Prevedoros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="flightclub.Flight"%>
<%
	String filePath = application.getRealPath("WEB-INF/flights.xml");
%>
<jsp:useBean id="userApp" class="flightclub.UserApplication"
	scope="application">
	<jsp:setProperty name="userApp" property="filePath"
		value="<%=filePath%>" />
</jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <!Needs menu>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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


    </body>
</html>
