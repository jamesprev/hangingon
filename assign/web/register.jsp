<%-- 
    Document   : register
    Created on : 16/05/2017, 11:49:48 AM
    Author     : 11987839
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <h1>Register</h1>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
    <form method ="post" action="">
        <table>
            <tr><td>Full name   <td> <input type="text" name="name"></td></tr>
            <tr><td>Email       <td><input type="text" name="email"></td></tr>
            <tr><td>Password    <td> <input type="password" name="password"></td></tr>
            <tr><td>Date of Birth<td> <input type="dob" name="dob"></td></tr>
            <tr><td></td><td><input type="submit" value="Register"></td></tr>
        </table>
    </form>
    </body>
</html>
