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
<html>
    <body>
        <div>
            <br/>
            <table style='width: 50%;'> 
                <tr>
                    <td style='text-align:left; width: 50%;'>
                        <a href="#" type="button" name="Back" onclick="document.history.back();" style="text-align:left;">BACK</a>
                    </td>
                    <td style='text-align:right; width: 50%;'>
                        <% if (sessionUser != null) { %>
                            You are logged in as <%= sessionUser.getName() %> &#60;<%=sessionUser.getEmail()%>&#62; | <a href="logout.jsp">Log out</a>
                        <%} else { %>
                            <a href="login.jsp">Log in</a> | <a href="register.jsp">Register</a>
                        <%}%>
                    </td>
                </tr> 
            </table>
            <br/>
        </div>
        
        <div style="background: #eee; border: solid 1px #333; width: 100%; margin: 10px; margin-right: 30px; padding: 10px">
            <table>
                <tr>
                    <td style="background: #eee; border: solid 1px #333; padding: 10px">
                        <a href="main.jsp">Main</a>
                    </td>
                    <td style="background: #eee; border: solid 1px #333; padding: 10px">
                        <a href="booking.jsp">Booking</a>
                    </td>
                    <%if (sessionUser != null && sessionUser.getIsAdmin()) {%>
                    <td style="background: #eee; border: solid 1px #333; padding: 10px">
                        <a href="admin.jsp">Admin</a>
                    </td>
                    <%}%>
                </tr>
            </table>
        </div>
    </body>
</html>