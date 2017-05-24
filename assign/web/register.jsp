<%@page contentType="text/html" pageEncoding="UTF-8"  import="flightclub.*"%>

<% //Gets the filepath of the project for writing a new user
    String filePath = application.getRealPath("WEB-INF/users.xml"); %>
<jsp:useBean id="userApp" class="flightclub.UserApplication" scope="application">
    <jsp:setProperty name="userApp" property="filePath" value="<%=filePath%>"/>
</jsp:useBean>

<%
    //Set up page variables to default values
    boolean nameValid = true, 
            emailValid = true, 
            passwordValid = true, 
            dobValid = true;
    boolean emailInSystem = false;
    String email = "", 
            name = "", 
            password = "", 
            dob = "";
    
    //User has tried to register previously, check if valid
    String submitted = request.getParameter("submit");
    if (submitted != null && submitted.equals("Register")) {
        //Create user from given values
        email = request.getParameter("email");
        name = request.getParameter("name");
        password = request.getParameter("password");
        dob = request.getParameter("dob");
        User user = new User(name, email, password, dob, false);
        
        //Perform data validation
        nameValid = user.isNameValid();
        emailValid = user.isEmailValid();
        passwordValid = user.isPasswordValid();
        dobValid = user.isDobValid();

        //Check if user valid:
        if (nameValid && emailValid && passwordValid && dobValid) {
            //User is valid, check if already exists in database
            Users users = userApp.getUsers(); //Get list of users read in from XML
            if (users.checkEmailExists(email) == false) {
                users.addUser(user); //Add user to that list
                userApp.setUsers(users); //Write it back to the XML file
                session.setAttribute("user", user);
                response.setHeader("Refresh", "0;url=" + session.getAttribute("returnToPage")); //Redirect to main page
                session.setAttribute("user", user); 
            } 
            else { //Email already exists
                emailInSystem = true;
                email = "";
            }
        }
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <style>
            .errorMessage {
                color: red;
            }
        </style>
        
    <h1>Register</h1>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    
    <body>
        <jsp:include page="menu.jsp"/>
        
        <form name="registration" method ="post" action="register.jsp">
            <table>
                <tr>
                    <td>Full name</td>   
                    <td><input type="text" name="name" value="<%=name%>"></td>
                    <% if (!nameValid) {%>
                    <td class="errorMessage"><b>Please enter your full name</b></td>
                    <%}%>
                </tr>
                
                
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email" value="<%=email%>"></td>
                    <% if (!emailValid) {%>
                    <td class="errorMessage"><b>Please enter a valid email address</b></td>
                    <%}%>
                    <% if (emailInSystem) {%>
                    <td class="errorMessage"><b>That email address already belongs to an account</b></td>
                    <%}%>
                </tr>
                
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"></td>
                    <% if (!passwordValid) {%>
                    <td class="errorMessage"><b>Password must be 7+ characters long</b></td>
                    <%}%>
                </tr>
                
                
                <tr>
                    <td>Date of Birth</td>
                    <td><input type="text" name="dob" value="<%=dob%>"></td>
                    <% if (!dobValid) {%>
                    <td class="errorMessage"><b>DOB must be a valid date, (typed dd/MM/yyyy)</b></td>
                    <%}%>
                </tr>
                
                <tr><td>User Type</td>
                    <td><select name="usertype">
                            <option value="customer"> Customer </option>
                            <option value="admin"> Admin </option>
                       </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" name="submit" value="Register"></td>
                    <td><input type="button" value="Cancel" onclick="history.back();"></td>
                </tr>

                <!Registered details are verified to be correct format then added to XML doc>
            </table>
        </form>
    </body>
</html>
