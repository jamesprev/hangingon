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
    <!needs a menu>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
    <form name="registration" method ="post" action="">
        <table>
            <tr><td>Full name   <td> <input type="text" name="name"></td></tr>
            <tr><td>Email       <td><input type="text" name="email"></td></tr>
            <tr><td>Password    <td> <input type="password" name="password"></td></tr>
            <tr><td>Date of Birth<td> <input type="dob" name="dob"></td></tr>
            <tr><td><input type="submit" value="Register"></td>
                <td><input type="button" value="Cancel" onclick=""></td>
                <td><input type="button" name="Back" onclick="document.history.back();"</td></tr>
            
            <!Registered details are verified to be correct format then added to XML doc>
        </table>
    </form>
    </body>
</html>
