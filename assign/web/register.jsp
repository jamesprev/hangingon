
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <h1>Register</h1>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
    <form name="registration" method ="post" action="welcome.jsp">
        <table>
            <tr><td>Full name   <td> <input type="text" name="name"></td></tr>
            <tr><td>Email       <td><input type="text" name="email"></td></tr>
            <tr><td>Password    <td> <input type="password" name="password"></td></tr>
            <tr><td>Date of Birth<td> <input type="text" name="dob"></td></tr>
            <tr><td>User Type 
                <td><select name="usertype">
                       <option value="customer"> Customer
                       <option value="admin"> Admin
                   </select>
                </td>
            </tr>
            <tr><td><input type="submit" value="Register"></td>
                <td><input type="button" value="Cancel" onclick="history.back()"></td>
                <td><input type="button" name="Back" onclick="history.back()"></td></tr>
            
            <!Registered details are verified to be correct format then added to XML doc>
        </table>
    </form>
    </body>
</html>
