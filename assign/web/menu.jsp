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
//User has logged in
    
        <div style="text-align: right;">
            <% if (sessionUser != null) { %>
                You are logged in as <%= sessionUser.getName() %> &#60;<%=sessionUser.getEmail()%>&#62; | <a href="logout.jsp">Log out</a>
            <%} else { %>
            <a href="login.jsp">Log in</a> | <a href="register.jsp">Register</a>
            <%}%>
        </div>
        
        <div style="background: #eee; border: solid 1px #333; width: 100%;">
            <table>
                <tr>
                    <td>
                        <a href="main.jsp">Home</a>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <a href="main.jsp">Home</a>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <a href="main.jsp">Home</a>
                    </td>
                </tr>
                 <tr>
                    <td>
                        <a href="main.jsp">Home</a>
                    </td>
                </tr>
            </table>
            
            <div style='text-align: right;'>
                <a href="logout.jsp">Logout</a>
            </div>
        </div>
<%}%>