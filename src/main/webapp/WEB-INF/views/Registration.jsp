<%--
  Created by IntelliJ IDEA.
  User: PC Net Computers
  Date: 1/1/2023
  Time: 12:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Registration Form</h1>
<form method="post" action="register">

        <label for="role">Choose a Role:</label>

        <select name="role" id="role">
            <option value="admin">Admin</option>
            <option value="user">User</option>
        </select>

    <br>
    <table border="1">

        <tr>
            <td>
                Username
            </td>
            <td>
                <input type="text" name="username" id="username"/>
            </td>
        </tr>
        <tr>
            <td>
                Password
            </td>
            <td>
                <input type="password" name="password" id="password"/>
            </td>
        </tr>
        <tr>
            <td>
               Confirm Password
            </td>
            <td>
                <input type="password" name="cpassword" id="cpassword">
            </td>
        </tr>

    </table>

    <br>

        <input type="submit" value="Register">

</form>

</body>
</html>
