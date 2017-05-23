<%-- 
    Document   : LoginAction
    Created on : 20/05/2017, 1:11:02 PM
    Author     : Andrew
--%>


<%@page import="flightclub.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%
	String filePath = application.getRealPath("WEB-INF/users.xml");
%>
=======

<% String filePath = application.getRealPath("WEB-INF/users.xml"); %>
>>>>>>> 186ec9acea710853c21ba530de5067ee1df1fef6
<jsp:useBean id="userApp" class="flightclub.UserApplication"
	scope="application">
	<jsp:setProperty name="userApp" property="filePath"
		value="<%=filePath%>" />
</jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
<<<<<<< HEAD
    <body> 
=======
    <body>
>>>>>>> 186ec9acea710853c21ba530de5067ee1df1fef6
       <%
            String email = request.getParameter("email"); 
            String password = request.getParameter("password");

            User user = userApp.getUsers().login(email, password);
            if (user != null) {
                //user login successful, store user object in session
                session.setAttribute("user", user);
<<<<<<< HEAD
        %>

=======
            
        %> 
        
>>>>>>> 186ec9acea710853c21ba530de5067ee1df1fef6
        <div>
            Login successful. Click <a href="main.jsp">here</a> to return to the main page.
        </div>
        <%} else { %>
        <div>
            Password incorrect. Click <a href="login.jsp">here</a> to try again.
        </div>
<<<<<<< HEAD
        <%}%>  
=======
        <%}%>
  
>>>>>>> 186ec9acea710853c21ba530de5067ee1df1fef6
    </body>
</html>



