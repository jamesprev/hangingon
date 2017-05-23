<%-- 
    Document   : login
    Created on : 17/05/2017, 11:06:21 PM
    Author     : Jamie Prevedoros
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!Needs Menu>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <form action="loginAction.jsp" method ="post">
      <table>
            <tr>
            <h1>Log In</h1> 
            </tr> 
            <tr><td>Email:</td><td><input type="text" name ="email"></td></tr>
            <tr><td>Password:</td><td><input type="password" name="password"></td></tr>
            <tr><td><input type="submit" value="Login"></td></tr>
                <td><input type="button" value="Cancel" onclick="history.back();"></td>
        </table>
    </form>
    <!Login page asks for email and password in a form
    Checks against XML sheet for verification
    Once logged in, they are returned to the page they were on in the session>
</body>
</html>
